(ns sodahead.render
	(:require 	[clojure.java.io :as io]
				[sodahead.parse :as p]
				[sodahead.prep :as pe]))


(defn render [original-text params]
	(let 	[text 	(pe/get-included original-text)
			chunks 	(p/chop text)
			cach-able-vector 	(map pe/morph-into-code chunks)]
		5))


(defn mk-defs [params]
	())