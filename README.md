# sodahead

Sodahead is a tiny front end engine for Clojure inspired by .NET Razor syntax. It lets you embed Clojure code in plain text (html tags, css, etc), executes the code and replaces it with resulted output.

There are 3 ways to execute code in Sodahead:

1. <b>Block of code:</b> a chunk of clojure expression wrapped in brackets %{}. Sodahead will execute the block and replace it with the result<br>
	%{ <br>
		expression 1 <br>
		expression 2 <br>
		... <br>
	} <br>

	Ex:  <br>
	%{  (def a 9)  (+ a 7)  } <br>
	will give you 16

2. <b>single expression:</b> %expression<br>
	ex: %(+ 8 9) will give you 17

3. <b>single variable:</b> %variable <br>
	ex: %Math/PI will give you 3.14<br>


Non trivial example:


Next coming feature: Template.