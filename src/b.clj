(ns test5)



(def data {:a 3 :b 9})


(require 'clojure.stacktrace
		'[sodahead.parse :as p])
(import 'java.io.File)

(def res
	[	(do 
			
			(def x 49)
			x
		)
		
		(do (import 'java.io.File)
			(def f (File. "a"))
			(.canRead f))
		(data :b)
		*ns*
		(p/getClosingBrac (slurp "a") 0 "{" "}")
		Math/PI
	])


(apply str res)

