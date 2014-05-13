(ns sodahead.prep
	(:require 	[sodahead.parse :as p]
				[clojure.java.io :as io]))


(defn get-file-content [file-name-within-quote]
	(let 	[name 	(subs file-name-within-quote 1 
							(dec (count file-name-within-quote)))
			err-msg (str "Cannot find " name ". Please make sure its name is surounded by double quote and can be found by clojure.java.io/resource")
			content  (io/resource name)]
		(if content
			(slurp content)
			err-msg)))

;#"%\{include\[ \n\t]"
(defn get-included [original-text]
	(loop 	[text original-text]
		(if-let [includeToken 		(re-find #"[%]{1}[\{]{1}include[\s]+" text)]
			(let 	[include-pos 		(.indexOf text includeToken)
					matching-sign-pos	(p/getClosingBrac text include-pos "{" "}")
					text-length 		(count text)
					missing-Err-Msg 	"No include matching sign % found"]
				(if (neg? matching-sign-pos)
					(str 	(subs text 0 include-pos) 
							missing-Err-Msg
							(subs text include-pos text-length))
					(let 	[file-list-start 	(+ include-pos (count "%{include"))
							file-list-string 	(.trim (subs text file-list-start matching-sign-pos))
							file-names 			(.split file-list-string "[ \n\t]+")
							files-content-vector		(map get-file-content file-names)
							files-dump 			(apply str files-content-vector)]
						(recur (str 	(subs text 0 include-pos)
								files-dump
								(subs text (inc matching-sign-pos) text-length))))))
			text)))

(defn morph-into-code [single-raw-data-chunk]
	(let 	[type 	(single-raw-data-chunk :type)
			data 	(single-raw-data-chunk :content)
			data-length 	(count data)]
		(cond
			(= type "text")
			(str " (str \"" data "\") \n\n ")

			(= type "var")
			(let [variable (subs data 1 data-length)]
				(str " (try (load-string \"" variable 
					"\")  (catch Exception e (str \"" data "\"))\n\n "))

			(= type "func")
			(str " " (subs data 1 data-length) " \n\n ")

			(= type "bloc")
			(let 	[code 	(subs data 2 (dec data-length))]
				(str " (do " code ") \n\n ")))))

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

(defn wrap-do [code-vector]
	(str "(def sodahead-chunk-vector ["
		(apply str code-vector) "])"
		" (apply str sodahead-chunk-vector)"))