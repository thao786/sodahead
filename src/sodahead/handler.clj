(ns sodahead.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] (sodahead.render "homepage" {:a 8 :b 7 :c 6}))



  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))



(defn render [file args]
	create such file:

(ns sodahead.homepage)
(require)/import

(def res [a b c]
	[(do ...)
	(do ...)
	(+ 9 8)
	])


	)

to remove namespace: remove-ns