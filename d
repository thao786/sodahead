htg %{ge_n-sym}oik"ujy uyht{g  %((+ 8 7 ) )  uyhgf} %yc-v4	{j	h"y{}
ghj}ghjk %(+ 9 8 (- 9 5))
}hjrfgh}
ui %Cannot find include. Please make sure its name is surounded by double quote and can be found by clojure.java.io/resource(ns test)

(def data {:a 3 :b 4})


(require 'clojure.stacktrace
		'[sodahead.parse :as p])

(import 'java.io.File)

(def res
	[	(do
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

(apply str res)%include{ "b.clj"
}
yhtgrf