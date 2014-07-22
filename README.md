# sodahead

3 ways to execute code in sodahead:

1. <b>Block of code:</b><br>
	%{ <br>
		expression 1 <br>
		expression 2 <br>
		... <br>
	} <br>

	Ex:  <br>
	%{ <br>
		(def a 9) <br>
		(+ a 7) <br>
	} <br>
	will give you 16

2. single expression:
	%expression
	ex: %(+ 8 9)

3. single variable:
	%variable name
	ex: %Math/PI