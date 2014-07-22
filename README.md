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

2. single expression:<br>
	%expression<br>
	ex: %(+ 8 9) will give you 17

3. single variable:<br>
	%variable <br>
	ex: %Math/PI will give you 3.14