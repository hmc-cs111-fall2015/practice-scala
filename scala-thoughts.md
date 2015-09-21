##What's easy to do in Scala? What's not?

It is easy to write simple scripts that follow functional design, including lambda functions, immutable object transformations and type generality. It also has some concepts from java like static (or companion) that make it really easy to do sort of complicated things. Since it has the same capabilities of Java, I can't really see how it couldn't handle a large project also. The only complaint I would have is that the syntax between the OOP and functional parts of the language don't always clash well together, but I have really seen any language that has pulled that off, so I can't bash Scala too much for that. 

##What is/are your favorite language design choice(s) that the designers of Scala made? Why?

I guess my favorite language design choice was the way they chose to do multiple function, function calls, such as with foldLeft. Having it in two very minimalistic sets of parenthesis both allow for clean syntax but also help the user understand what is happening. By separating out the base case in a separate set of parenthesis, the user will know that it is not being used in the iterative step. This is the cleanest way I have seen this implemented in any language, even purely functional ones. 

##What is/are your least favorite language design choice(s)? Why? And why do you think the designers made that / those choice(s)?

I think my least favorite design choices are coming from my inexperience with the language, but I would have to say the way types are defined. In so many languages over the last 20 years, we have come to expect Type variablename, in that order. To switch it around seems needless and slightly confusing for those new to the language. The only reason I can think of the designers choosing this is so that the type isn't confused with a function being applied, but more of just a descriptive tag on the end of a variable. 

##What Scala features would you like to learn more about?

I think the optionals are really cool but can't think of that many really important use cases for them. I would also like to learn more about companion classes since it seemed like a large part of the language design that I didn't get to try out that well. 