(ns sodahead.render
	(:require 	[clojure.java.io :as io]
				[sodahead.parse :as p]
				[sodahead.prep :as pe]))


(defn render [original-text params]
	(let 	[text 	(pe/get-included original-text)
			chunks 	(p/chop text)
			cach-able-vector 	(map pe/morph-into-code chunks)]
		5))

(defn get-def-str 
	"return string (def variable value)"
	[params key-word]
	(let [value 	(params key-word)
		 variable	(name key-word)]
		(str " (def " variable " " value ") ")))

(defn mk-defs [params]
	(if-let [key-list (keys params)]
		(let [key-vector 	(vec key-list)
			 def-vector 	(map (partial get-def-str params) key-vector)]
			(apply str def-vector))))


