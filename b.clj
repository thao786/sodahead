(ns test)

(def data {:a 3 :b 4})


(require 'clojure.stacktrace
		'[sodahead.parse :as p]
		'[sodahead.render :refer :all])

(import 'java.io.File)

(def res
	[	(try (do 
			(import 'java.io.File)
			(def x 49)
			x
		) (catch Exception e "Exception happened"))
		
		(do x
			(def f (File. "a"))
			(.canRead f))
		(.getPath f)
		(data :b)
		*ns*
		(p/getClosingBrac (slurp "a") 0 "{" "}")
		Math/PI
	])

(apply str res)
