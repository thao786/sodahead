(defmacro ig 
	"comment macro"
	[& expr] 
	nil)


(require 	'[clojure.java.io :as io]
			'[sodahead.parse :as p]
			'[sodahead.prep :as pe]
			'[sodahead.render :as r])



(spit "d"
(let 	[text 	(pe/get-included (slurp "a"))
			chunks 	(p/chop text)
			code-vector 	(map pe/morph-into-code chunks)
			body-code 	(pe/wrap-do code-vector)
			loadable-str 	(str "(ns sodahead.sudo-ns) " (pe/mk-defs {:a 4 :b 5}) body-code)]
		loadable-str))




(ns sodahead.homepage)
(require)/import

(defn render [a b c]
	(let [blocks [	(do ...)
					(do ...)
					(+ 9 8)
				]]
	(apply str blocks))

	
to remove namespace: remove-ns
