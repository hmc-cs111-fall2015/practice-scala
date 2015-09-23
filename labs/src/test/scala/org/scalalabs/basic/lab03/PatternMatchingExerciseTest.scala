package org.scalalabs.basic.lab03

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import PatternMatchingExercise._ 
/**
 * @see PatternMatchingExercise
 */
@RunWith(classOf[JUnitRunner])
class PatternMatchingExerciseTest extends Specification {

  "PatternMatchingExercise" should {
    "match language on strings" in {
      "OOP" === describeLanguage("Java")
      "OOP" === describeLanguage("Smalltalk")
      "Functional" === describeLanguage("Clojure")
      "Functional" === describeLanguage("Haskell")
      "Hybrid" === describeLanguage("Scala")
      "Procedural" === describeLanguage("C")
      "Unknown" === describeLanguage("Oz")
    }
    "match on input type" in {
      //"A string with length 8" === matchOnInputType("A String")
     //"A positive integer" === matchOnInputType(10)
//      "A person with name: Jack" === matchOnInputType(Person("Jack", 39))
//      "Seq with more than 10 elements" === matchOnInputType(1 to 11 toSeq)
      "first: first, second: second, rest: List(third, fourth)" === matchOnInputType(Seq("first", "second", "third", "fourth"))
      "Some Scala class" === matchOnInputType(10l)
      "A null value" === matchOnInputType(null)
    }
    "check age" in {
      Some("Jack") === older(new Person("Jack", 31))
      None === older(new Person("Jack", 30))
    }
  }
}