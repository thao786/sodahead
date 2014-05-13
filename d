htg %{ (def a 3)
Math/frde}  {ge_n-sym}oikujy uyht{g  %((+ 8 7 ) )  uyhgf} %yc-v4	{j	hy{}
ghj}ghjk %(+ 9 8 (- 9 5))
}hjrfgh}
ui %(ns test)

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

(apply str res)
yhtgrf
--------------------------------------\
%include
}
===============