(ns test)

(def data {:a 3 :b 4})


(require 'clojure.stacktrace
		'[sodahead.parse :as p]
		'[sodahead.render :refer :all])

(import 'java.io.File)

(def res
	[	(do
			(import 'java.io.File)
			(def x 9)
			nil
		)
		(+ x 8)
		(do
			(def f (File. "a"))
			(.canRead f))
		(.getPath f)
		(data :b)
		*ns*
		(p/getClosingBrac (slurp "a") 0 "{" "}")
	])

(apply str res)