(ns sodahead.render
	(:require 	[clojure.java.io :as io]
				[sodahead.parse :as p]
				[sodahead.prep :as pe]))

(defn render [original-text params]
	(let 	[text 	(pe/get-included original-text)
			chunks 	(p/chop text)
			code-vector 	(map pe/morph-into-code chunks)
			body-code 	(pe/wrap-do code-vector)
			loadable-str 	(str "(ns sodahead.sudo-ns) " (pe/mk-defs params) body-code)]
		(load-string loadable-str)))


(defmacro ig 
	"comment macro"
	[& expr] 
	nil)

(ig 
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

)