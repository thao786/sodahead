(ns sodahead.render
	(:require 	[clojure.java.io :as io]
				[sodahead.parse :as p]
				[sodahead.prep :as pe]))

(def ns-list
	"pairs of filename - containing namespace"
	(atom {}))

(defn bloc-or-expr
	"return true if this chunk is a block or expression"
	[chunks chunk]
	(let [type (chunk :type)]
		(cond 
			(= type "bloc") (.indexOf chunks chunk)
			(= type "expr") (.indexOf chunks chunk)
			:else false)))

(defn gen-ns-file
	"return a loadable body string preceded by the require and ns block"
	[text new-ns]
	(let 	[chunks 	(-> text (pe/get-included) (p/chop))
			require-block-index 	(some (partial bloc-or-expr chunks) chunks)
			require-block 	(get chunks require-block-index)
			require-block-content (str (pe/morph-into-code require-block) "\n")
			body-chunks 	(remove #(= require-block-index (.indexOf chunks %)) chunks)
			code-vector 	(map pe/morph-into-code body-chunks)
			body-code 	(pe/wrap-do code-vector)
			ns-expr 	(str "(ns " new-ns ")\n")
			body-str 	(str ns-expr require-block-content body-code)]
		body-str))

(defn cache
	"create a namespace and push it in list, return the name of containing namespace
	if rkey already exists throw exception"
	[rkey text]
	(if (@ns-list rkey)
		(throw (Exception. "Sodahead Exception: key already exists."))
		(let 	[new-ns 	(gensym "sodahead")
				load-str 	(gen-ns-file text new-ns)
				dummy 	(swap! ns-list assoc rkey new-ns)
				dummy 	(load-string load-str)]
			new-ns)))

(defn render-text
	"render text, remove temp namespace right after"
	[text params]
	(let 	[temp-ns 	(gensym "sodahead")
			load-str 	(gen-ns-file text temp-ns)
			dummy 	(load-string load-str)
			result 	(load-string (str "(" temp-ns "/render " params ")"))
			dummy 	(remove-ns temp-ns)]
		result))

(defn render-key
	"look up the filename in ns-list and load cached containing namespace"
	([rkey] (render-key rkey {}))

	([rkey params]
	(if-let [name-ns 	(@ns-list rkey)]
		(let [load-str 	(str "(" name-ns "/render " params ")")]
			(load-string load-str))
		nil)))

(defn render-file
	"render the text in file, dont cache"
	([file-path]
		(render-file file-path {}))
	([file-path params]
		(render-text (slurp (io/resource file-path)) params)))

(defn render-file-cache
	"first cache file, then render"
	([file-path]
		(render-file-cache file-path {}))
	([file-path params]
		(if-let [containing-ns 	(@ns-list file-path)]
			(load-string (str "(" containing-ns "/render " params ")"))
			;cache, then render
			(let [new-ns (cache file-path (slurp (io/resource file-path)))]
				(load-string (str "(" new-ns "/render " params ")"))))))

(def render render-file-cache)

(defmacro ig 
	"comment macro"
	[& expr] 
	nil)

(ig
(require 	'[clojure.java.io :as io]
			'[sodahead.parse :as p]
			'[sodahead.prep :as pe]
			'[sodahead.render :as r])

)