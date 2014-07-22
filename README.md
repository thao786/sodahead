# sodahead

Sodahead is a tiny front end engine for Clojure inspired by .NET Razor syntax. It lets you embed Clojure code in plain text (html tags, css, etc), executes the code and replaces it with resulted output.<br>

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
<p>Circle A has a radius of %radius. Its area is %(* Math/PI radius radius)</p>
```
Rendering the obove code outputs
```
<div>**********</div>
<p>Circle A has a radius of 2. Its area is 12.566370614359172</p>
```

There are 3 ways to execute code in Sodahead:

1. <b>Block of code:</b> Multiple clojure expressions can be wrapped in brackets %{}. Output is the result of the last expression.<br>

2. <b>single expression:</b> `%(- 9 8)`<br>

3. <b>single variable:</b> `%variable` <br>
It is assumed that variable name does not contain ^(){}[]@\~`',."<>. If it does, put it in braces %{variable}.


Sodahead use the symbol % to signify the start of a code block. If you dont intend to write Clojure, add some space after it.

<h3>Include file</h3>
First of all Sodahead looks for all %include blocks and recursively replaces them with concatenated file contents.
```
%include {
	"file1.html"
	"file2.html"
	...
}
```

<h3>Render </h3>
To render code embedded text, use **(sodahead.render/render filename {:param value})**. This method first "cache" the file's final executable form and then renders the content. Ex:
```
(require [sodahead.render :as r]  
		[compojure.route :as route])

(defroutes app-routes 
        (GET "/" [] (r/render "HomePage.html" {:userID 798659})))
```
Passed over parameters can be accessed as if they are defined locally (embedded in plain text). For example, in HomePage.html:
```
<p>Your ID is %userID </p>
```
gives
```
<p>Your ID is 798659 </p>

```

Other options (same parameters):
**render-file** only renders file with no caching
**render-text** renders text


**Next coming feature:** 
- Template.
- Line by line debugging.