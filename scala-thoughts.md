
The feeling of using Scala is slightly odd. Most things really well, but only because it
"was made that way." Of course, that's the whole point of having a scalable language.
You can feel domain-specific in a much larger range of places. Even so, it still feels
a bit unsettling. Does it ever happen that accidental implicit casts cause huge issues, for example?
I think not, if you're doing things sensibly, but it's there in the back of my mind.

I did run into a problem that I was unable to solve, which had to do with String.split.
Apparently, String.split can also take in an integer argument, or at least that's what the error
message seemed to imply, and the two functions were somehow ambiguous despite the fact that
each takes a different number of arguments. Regardless, in general I was less than satisfied
with Scala's error messages. That's a place where nearly every language can improve, though.

I like and dislike many of their decisions. Covariant and contravariant types are a good
(/necessary?) idea. However, it does bother me that Scala's type system totally co-opted
square brackets, which seems a strange thing to do for a language that is trying to let you
write DSLs. Some of the pattern matching rules aren't very consistent. For example, you can
match Seq(a, _*) but not Seq(a, rest*). You have to do Seq(a, rest@_*) instead. 
You also cannot use a variable as a specific value to match, though that decision makes
sense. Underscore is in general extremely overloaded. It isn't clear when it needs to be the
same value and when it doesn't. For example, we saw a type declaration which used
List[List[_]] and List[_], where the underscores seemed to represent the same type,
but used in anonymous functions (_+_) each underscore is the next argument.

All in all, I think Scala is great. It lets you do a lot of really useful things elegantly. I'm just
a little scared that it might also make it easy to tie yourself into an incredibly complicated
web. Still, it will be fun to use.

I do wish it was possible to use brackets though.
