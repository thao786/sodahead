(ns sodahead.render
	(:require 	[clojure.java.io :as io]
				[sodahead.parse :as p]
				[sodahead.prep :as pe]))

(def ns-list (atom {}))

(defn gen-ns-header []
	(str "(ns " (gensym "sodahead") ")\n"))

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
	[original-text key-str]
	(let 	[chunks 	(-> original-text (pe/get-included) (p/chop))
			ns-block-index 	(some (partial bloc-or-expr chunks) chunks)
			ns-block 	(get chunks ns-block-index)
			ns-block-content (str (pe/morph-into-code ns-block) "\n")
			body-chunks 	(remove #(= ns-block-index (.indexOf chunks %)) chunks)
			code-vector 	(map pe/morph-into-code body-chunks)
			body-code 	(pe/wrap-do code-vector key-str)
			body-str 	(str (gen-ns-header) ns-block-content body-code)]
		body-str))

(defn assemble
	"if first time, create file namespace containing function wt such params"
	[file params]
	(let 	[param-val 	(vals params)
			param-key 	(keys params)
		 	key-str 	(apply str (for [x (keys params)] 
		 						(str (name x) " ")))
		 	]
		))

(defn render
	"if first time, create file namespace containing function wt such params"
	[file params]
	(if-let [file-ns	(get ns-list file)]
		(apply file-ns/render (vals params))
		()))