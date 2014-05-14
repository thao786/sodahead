(ns sodahead.prep
	(:require 	[sodahead.parse :as p]
				[clojure.java.io :as io]))

(defn get-file-content
	"strip off quote and get the content of the file. doesn't check for quote"
	[file-name-within-quote]
	(let 	[name 	(subs file-name-within-quote 1 
							(dec (count file-name-within-quote)))
			err-msg (str "Cannot find " name ". Please make sure file name is surounded by double quote and accessible via clojure.java.io/resource")
			content  (io/resource name)]
		(if content
			(slurp content)
			err-msg)))

(defn get-included
	"recursively replace all include blocks with files' content concatenation"
	[original-text]
	(loop 	[text original-text]
		(if-let [includeToken 		(re-find #"%include\{[\s]+" text)]
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

(defn morph-into-code
	"depends on the type of the block, wrap it in appropriate try/catch"
	[single-raw-data-chunk]
	(let 	[type 	(single-raw-data-chunk :type)
			data 	(single-raw-data-chunk :content)
			data-length 	(count data)
			escaped-data 	(.replace data "\\" "\\\\")]
		(cond
			(= type "text")
			(str "(str \"" escaped-data "\")")

			(= type "var")
			(let [variable (subs data 1 data-length)]
				(str "(try (load-string \"" variable 
					"\") (catch Exception e (str \"" escaped-data "\")))"))

			(= type "expr")
			(let [expr (subs data 1 data-length)]
				(str "(try " expr 
					" (catch Exception e \"Exception happened\"))"))

			(= type "bloc")
			(let 	[code 	(subs data 2 (dec data-length))
					do-bloc 	(str "(do " code ")")]
				(str "(try " do-bloc " (catch Exception e \"Exception happened\"))")))))

(defn get-def-str 
	"return string (def variable value)"
	[params key-word]
	(let [value 	(params key-word)
		 variable	(name key-word)]
		(str "(def " variable " " value ")\n")))

(defn mk-defs
	"create def statement for every key/value pair in params map"
	[params]
	(if-let [key-list (keys params)]
		(let [key-vector 	(vec key-list)
			 def-vector 	(map (partial get-def-str params) key-vector)]
			(apply str def-vector))))

(defn wrap-do
	"wrap the whole code vector in a def to be executed by map"
	[code-vector]
	(str "(def sodahead-chunk-vector ["
		(apply str code-vector) "])"
		"\n(apply str sodahead-chunk-vector)"))
