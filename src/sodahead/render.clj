(ns sodahead.render
	(:require 	[clojure.java.io :as io]
				[sodahead.parse :as p]
				[sodahead.prep :as pe]))

(defn render [original-text params]
	(let 	[text 	(pe/get-included original-text)
			chunks 	(p/chop text)
			code-vector 	(map pe/morph-into-code chunks)
			body-code 	(wrap-do code-vector)
			loadable-str 	(str "(ns sodahead.sudo-ns) " (mk-defs params) body-code)]
		loadable-str))


(defmacro ig 
	"comment macro"
	[& expr] 
	nil)

(ig 
(require 	'[clojure.java.io :as io]
				'[sodahead.parse :as p]
				'[sodahead.prep :as pe])


(spit "d" )

)