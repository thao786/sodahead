# sodahead

3 kinds of clojure code access:

1. block: 
	%{
		expression 1
		expression 2
	}

2. single expression:
	%expression
	ex: %(+ 8 9)

3. single variable:
	%variable name
	ex: %Math/PI