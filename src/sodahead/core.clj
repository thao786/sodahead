
(defn gen-ns-file3
	"return a loadable body string preceded by the require block"
	[original-text params]
	(let 	[chunks 	(-> original-text (pe/get-included) (p/chop))
			ns-block-index 	(some (partial r/bloc-or-expr chunks) chunks)
			ns-block 	(get chunks ns-block-index)
			ns-block-content (str (pe/morph-into-code ns-block) "\n")
			body-chunks 	(remove #(= ns-block-index (.indexOf chunks %)) chunks)
			code-vector 	(map pe/morph-into-code body-chunks)
			body-code 	(pe/wrap-do code-vector)
			body-str 	(str ns-block-content body-code)]
		body-str))

(defn gen-ns-file3
	"return a loadable body string preceded by the require block"
	[original-text params]
	(let 	[chunks 	(-> original-text (pe/get-included) (p/chop))
			ns-block-index 	(some (partial r/bloc-or-expr chunks) chunks)
			]
		ns-block-index))



