htg %{ge_n-sym}oik"ujy uyht{g  %((+ 8 7 ) )  uyhgf} %yc-v4	{j	h"y{}
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

(apply str res)Cannot find 76. Please make sure its name is surounded by double quote and can be found by clojure.java.io/resource
yhtgrf
--------------------------------------\
(defproject sodahead "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.7"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler sodahead.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
Cannot find gfrds. Please make sure its name is surounded by double quote and can be found by clojure.java.io/resource
===============