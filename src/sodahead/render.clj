(ns sodahead.render
	(:require 	[sodahead.parse :as p]
				[clojure.java.io :as io]))


(defn get-file-content [file-name-within-quote]
	(let 	[name 	(subs file-name-within-quote 1 
							(- (count file-name-within-quote) 1))
			err-msg (str "Cannot find " name ". Please make sure its name is surounded by double quote and can be found by clojure.java.io/resource")
			content  (io/resource name)]
		(if content
			(slurp content)
			err-msg)))


(defn get-included [original-text]
	(loop 	[text original-text]
		(if-let [includeToken 		(re-find #"%include\{[ \n\t]" text)]
			(let 	[include-pos 		(.indexOf text includeToken)
					matching-sign-pos	(p/getClosingBrac text include-pos "{" "}")
					text-length 		(count text)
					missing-Err-Msg 	"No include matching sign % found"]
				(if (neg? matching-sign-pos)
					(str 	(subs text 0 include-pos) 
							missing-Err-Msg
							(subs text include-pos text-length))
					(let 	[file-list-start 	(+ include-pos (count "%include") 1)
							file-list-string 	(.trim (subs text file-list-start matching-sign-pos))
							file-names 			(.split file-list-string "[ \n\t]+")
							files-content-vector		(map get-file-content file-names)
							files-dump 			(apply str files-content-vector)]
						(recur (str 	(subs text 0 include-pos)
								files-dump
								(subs text (+ 1 matching-sign-pos) text-length))))))
			text)))


;(require '[clojure.java.io :as io])


;(require '[sodahead.parse :as p])


(defn render [original-text]
	(let 	[text 	(get-included original-text)]
		5))


