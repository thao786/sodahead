# sodahead

Sodahead is a tiny front end engine for Clojure inspired by .NET Razor syntax. It lets you embed Clojure code in plain text (html tags, css, etc), executes the code and replaces it with resulted output.


<h3>Install</h3>
Include  ```org.clojure/clojure "0.1.0"``` in your lein dependency.


<h3>Include file</h3>



<h3>Embed code</h3>
There are 3 ways to execute code in Sodahead:

1. <b>Block of code:</b> a chunk of clojure expression wrapped in brackets %{}. Sodahead will execute the block and replace it with the result<br>
	%{ <br>
		expression 1 <br>
		expression 2 <br>
		... <br>
	} <br>

2. <b>single expression:</b> %expression<br>

3. <b>single variable:</b> %variable <br>

Example:
%{  (def a 9)  (+ a 7)  } <br>
%(+ 8 9)
%Math/PI

outputs



Next coming feature: Template.