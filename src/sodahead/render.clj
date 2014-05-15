(ns sodahead.render
	(:require 	[clojure.java.io :as io]
				[sodahead.parse :as p]
				[sodahead.prep :as pe]))

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
	""
	[original-text key-str new-ns]
	(let 	[chunks 	(-> original-text (pe/get-included) (p/chop))
			ns-block-index 	(some (partial bloc-or-expr chunks) chunks)
			ns-block 	(get chunks ns-block-index)
			ns-block-content (str (pe/morph-into-code ns-block) "\n")
			body-chunks 	(remove #(= ns-block-index (.indexOf chunks %)) chunks)
			code-vector 	(map pe/morph-into-code body-chunks)
			body-code 	(pe/wrap-do code-vector key-str)
			body-str 	(str "(ns " new-ns ")\n" ns-block-content body-code)]
		body-str))

(defn assemble
	"create file namespace containing function wt such params"
	[text params]
	(let 	[param-val 	(vals params)
			param-key 	(keys params)
		 	key-str 	(apply str (for [x (keys params)] 
		 						(str (name x) " ")))
		 	new-ns 	(gensym "sodahead")		 	
		 	new-ns-file (str "src/" new-ns ".clj")
		 	dummy 	(swap! );need to update atom
		 	dummy 	(spit new-ns-file (gen-ns-file text key-str new-ns))
		 	dummy 	(load "temp")]
		new-ns))

(defn render
	[file params]
	(if-let [file-ns	(get ns-list file)]
		(apply file-ns/render (vals params))
		(if-let [text (try (slurp file) (catch Exception e nil))]
			(let [new-ns (assemble text params)] 
				(apply new-ns/render (vals params)))
			(str file " cannot be found by slurp."))))