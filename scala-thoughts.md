I was initially pretty unimpressed with Scala. Sure, string interpolation is pretty cool,
and I can (now, at least) appreciate the "immutable/functional first" philosophy; but syntax-wise, I initially treated Scala much like Java
(because Scala let's you get away with it--more on this later), and so I was very much displeased by what I perceived to be a design decision
to maintain arguably overbearing syntax--particularly when compared to other languages to which I'm partial such as Haskell and Python.
This concept bugged me so much that I looked up the style guide and found something to my liking:
you don't, in fact, need to use a dot operator in many cases, and it is even frowned upon in some cases.
Not only did this make me appreciate Scala a little more, but I think it was a good design decision given its name derives from "scalable language."
A scalable language should be flexible in its syntax, and Scala's syntax is flexible on so many levels:
Scala supports unicode, operator overloading, and various ways of calling built-in (and presumably other) functions
via the ommission of periods and parentheses.

Since Programming Languages has introduced me to Haskell, it has, temporarily at least, become my favorite language;
so most of my complaints about Scala come from its failure to live up to some of Haskell's features--
though it's probably much easier to use Object-Oriented approaches in Scala than in Haskell.
For example, while I appreciate that Scala has its own version of pattern matching which extends the simplicity and power of typical switch-case statements,
Scala doesn't support pattern matching with functions--it's close but not as syntactically simple and pretty.
Also, in reviewing the solution code, I noticed that Scala has a `lazy` keyword, which I presume enforces lazy initialization; however,
it seems to me that one would pretty much always prefer lazy initialization as then values are only computed as they become necessary,
but I suppose if the values are pre-computed, then programs will run faster.