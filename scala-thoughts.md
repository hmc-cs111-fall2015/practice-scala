I found Scala to be very, very interesting.  It reminded me a lot of Haskell in 
the way you can mix and match how you write operations, however it also really
bothers me.  I understand how convenient and easy this makes it, but I think it
can also lead to confusion.  Why is

```
(myList zip myOtherList).map
```

just as valid as

```
myList zip myOtherList map {}
```

?

It seems to me that the additional flexibility comes at the cost of readability,
and I suspect any large-scale business project that used this would have to 
follow pretty strict conventions.  That being said, I think it wouldn't be too
bad after I got used to it.

Pattern matching was incredible.  If I had time I'd go back and do everything
with pattern matching, except for the ones I wouldn't.  

I found the `Option` type interesting as well - I remember liking that concept a
lot in C# as well, and wish there was a better analogue in other strongly and 
statically typed languages (if there is, please point me to it).  

I'm partial to functional programming in general - I've always found it elegant,
and I was known to cause problems at my summer internship by rewriting huge 
blocks of code in a more functional style "because it's better".  I like that 
Scala has the "functional first" mentality, but still lets me fall back to 
object orientation when it suits me.  It reminds me a lot of Python, but with 
more and better functional abilities.

I also love immutability.  I've been toying around with some pet projects that 
are immutability first, and I have to say they greatly speed up my development
and debugging time (although slow down my runtime, but who actually needs that?)

Overall I'm very excited to start using Scala this semester.
