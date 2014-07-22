# sodahead

Sodahead is a tiny front end engine for Clojure inspired by .NET Razor syntax. It lets you embed Clojure code in plain text (html tags, css, etc), executes the code and replaces it with resulted output.<br><br>

<h3>Install</h3>
Add the following to your lein dependency:
```org.clojure/clojure "0.1.0"```

<h3>Syntax</h3>
```
<div>
%{
	(def radius 2)
	(apply str (repeat 10 "*"))
}
</div>
<p>Circle A has a radius of %radius. Its area is %(* Math/PI 2 2)</p>
```
Rendering the obove code outputs
```
<div>**********</div>
<p>Circle A has a radius of 2. Its area is 12.566370614359172</p>
```

There are 3 ways to execute code in Sodahead:

1. <b>Block of code:</b> a chunk of clojure expression wrapped in brackets %{}.<br>
	```
	%{ 
		expression 1 
		expression 2 
		... 
	}
	```

2. <b>single expression:</b> `%(expression)`<br>

3. <b>single variable:</b> `%variable` <br>
search terminates until special symbols like <. Clojure is loose when it comes to variable naming. When in doubt use %{variable}


Sodahead use the symbol % to signify the start of a code block. If you dont intend to write Clojure, add some space after it.

<h3>Include file</h3>

<h3>Render </h3>
To render code embedded text


**Next coming feature:** 
- Template.
- Line by line debugging.