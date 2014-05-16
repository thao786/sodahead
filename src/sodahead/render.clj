(ns sodahead.render
	(:require 	[clojure.java.io :as io]
				[sodahead.parse :as p]
				[sodahead.prep :as pe]))
;(remove-ns 'sodahead)

(def ns-list (atom {}))

(defn bloc-or-expr
	"return true if this chunk is a block or expression"
	[chunks chunk]
	(let [type (chunk :type)]
		(cond 
			(= type "bloc") (.indexOf chunks chunk)
			(= type "expr") (.indexOf chunks chunk)
			:else false)))

(defn gen-ns-file
	"return a loadable body string preceded by the require block"
	[original-text params]
	(let 	[chunks 	(-> original-text (pe/get-included) (p/chop))
			ns-block-index 	(some (partial bloc-or-expr chunks) chunks)
			ns-block 	(get chunks ns-block-index)
			ns-block-content (str (pe/morph-into-code ns-block) "\n")
			body-chunks 	(remove #(= ns-block-index (.indexOf chunks %)) chunks)
			code-vector 	(map pe/morph-into-code body-chunks)
			body-code 	(pe/wrap-do code-vector params)
			body-str 	(str ns-block-content body-code)]
		body-str))

(defn assemble
	"create file namespace containing function wt such params"
	[text params]
	(let 	[
		 	new-ns 	(gensym "sodahead")		 	
		 	new-ns-file (str "src/" new-ns ".clj")
		 	dummy 	(swap! );need to update atom
		 	dummy 	(spit new-ns-file (gen-ns-file text key-str new-ns))
		 	dummy 	(load "temp")]
		new-ns))

(defn render
	[text params]
	(if-let [file-ns	(get ns-list file)]
		(file-ns/render params)
		(render-text (slurp text) params)))

(defn render2
	[text params]
	(if-let [file-ns	(get ns-list file)]
		(file-ns/render params)
		(if-let [text (try (slurp file) (catch Exception e nil))]
			(let [new-ns (assemble text params)] 
				(new-ns/render params))
			(str file " cannot be found by slurp."))))

(defn render-text
	"render text, remove temp ns right after"
	[text params]
	(let 	[temp-ns 	(gensym "sodahead")
			temp-ns-str 	(str "(ns " temp-ns ")\n")
			load-str 	(str temp-ns-str (gen-ns-file text params))
			dummy 	(load-string load-str)
			result 	(load-string (str "(" temp-ns "/render " params ")"))
			dummy 	(remove-ns temp-ns)]
		result))
