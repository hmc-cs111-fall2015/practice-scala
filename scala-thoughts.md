The first thing I would say about Scala is that there is too much syntax. It
seems that there are several different ways of doing every simple thing, and
which syntax you should use in each place is very unclear. For example, I'm
still unclear what the difference between the following statements are:

    f g x
    f.g(x)
    f(g(x))

Since Scala likes implementing DSLs so much, it appears that lots of packages
are more DSL than API, which usually makes the API easier to read, but harder
to learn and write since you have to learn a largely new syntax over again.

Scala is really cool in that it can be used in lots of different ways and each
one is pretty nice to use. C++ also aims to be able to be used in many
different ways, but its syntax gets really obscene for things like functional
programming because it basically runs out of short syntax and thus has to go
into longer, more convoluted things. Scala has so much syntax that it can
implement all these different programming models without getting too gross.
Scala is still weighted toward the functional model but the object-oriented
model is nice and imperative programming is... possible.

I had a lot of trouble with the lambdas and multiple function
arguments/functions taking tuples. At one point, I got a type mismatch error:

    [error]  found   : ((Int, (Int, Option[String]))) => Int
    [error]  required: (Int, (Int, Option[String])) => Int

This is really strange because it appears to just want an extra pair of
parentheses (a 1-tuple?) but adding the parentheses to the type did not fix it.
I fixed this by scrapping my function and rewriting it as a lambda so I didn't
need to specify types. This is really frustrating because the error didn't
really have anything that I could search for and I could not find any way to
fix it.

I am interested to learning more about how to leverage Scala's extendible
syntax. Overloading the + operator was cool but seeing how to implement
something like the unit test library with random strings being used as
operators would be really neat.
