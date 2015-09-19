# Reflections on Learning Scala

Scala has been an interesting language to start to learn. What stood out to me
the most when I was learning it was that the syntax was super flexible - for
me that was actually very challenging to handle at first. I think in the end I
tried to just avoid the cases that seemed ambiguous to me, choosing to write

```
list1.zip(list2).drop(3)
```

in place of

```
list1 zip list2 drop 3
```

I don't think this flexibility is a bad thing (more thoughts on this later),
but I would note that it has been a long time since I learned a language with
even a slightly different syntax structure. Its surprising how much a few small
decisions can do to complicate that structure.

Regarding the functional parts of Scala, I found using them to be very
satisfying, mostly because I've done enough C++11 and Java to want that
expressiveness and written enough Python/Haskell/Rust to be comfortable
using it.

I could imagine that transitioning to Scala from an only-Java perspective would
be much more challenging.

# The Design Choices of Scala

One of the interesting design choices that has been made in Scala is to allow
for `A f B` in place of `A.f(b)`. This may seem like just a surface level
change, but I imagine that this is one of the changes that makes Scala
appropriate for writing internal DSL's in. There are also some other
parsing-related choices that contribute to that goal. Even though I don't
particularly like this decision right now, I imagine that it will grow on me
over time.

I think that Scala also has some very nice syntactic sugar around anonymous
functions. In particular consider this expression:

```
list1.zip(list2).map(_ + _)
```

I think being able to express the arguments to an anonymous function in-line is
a very nice touch.

One thing that I thought was interesting coming from Rust is that Scala has
exceptions. There isn't anything about the functional programming style that
forbids exceptions, but functional programming definitely makes it possible to
easily return errors instead of using exceptions (I should correct this - it
makes it easy to handle returned exceptions, it is always easy to return them).
I think that this decision makes some amount of sense. I know it would be very
hard to exorcise exceptions and still intermingle with Java as much as Scala
does. I also imagine that Scala wants to continue to conform to at least some
of the existing standards of software development, of which exceptions are
included.

The reason that Rust doesn't have exceptions is that they make predicting
control flow harder, and I can see that not being a priority in Scala.

# Moving Forward

Over the next few weeks I want to work hard to become more comfortable with the
syntax of Scala. I shouldn't be thrown by infixing methods or anything like
that. I think that doing this will pay off when it comes time to work on our
projects.

I also want to learn about the type system of Scala. I had 2-3 nasty run-ins
with the type inference system during the labs. Additionally, Prof Ben has
mentioned that Scala's type system is a bit complex, and I'd like to know what
he means by that.
