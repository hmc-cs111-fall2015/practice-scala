package org.scalalabs.basic.lab02
/**
 * This Lab contains exercises where the usage of
 * higher order collection methods can be rehearsed.
 */
import sys._

object CollectionExercise01 {

  /**
   * Taken from: <a href="http://code.google.com/codejam/contest/1460488/dashboard">Problem A. Speaking in Tongues</a>
   *
   * Problem
   * The aim of this task is to translate a language into a new language called Googlerese.
   * To translate we take any message and replace each English letter with another English letter.
   * This mapping is one-to-one and onto, which means that the same input letter always gets replaced
   * with the same output letter, and different input letters always get replaced with different output letters.
   * A letter may be replaced by itself. Spaces are left as-is.
   *
   * For example (and here is a hint!), the translation algorithm includes the following three mappings:
   * 'a' -> 'y', 'o' -> 'e', and 'z' -> 'q'. This means that "a zoo" will become "y qee".
   *
   * Sample Input/Output
   * Input:
   * Case 1: ejp mysljylc kd kxveddknmc re jsicpdrysi
   * Case 2: rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd
   * Case 3: de kr kd eoya kw aej tysr re ujdr lkgc jv
   *
   * Output:
   * Case 1: our language is impossible to understand
   * Case 2: there are twenty six factorial possibilities
   * Case 3: so it is okay if you want to just give up
   *
   */
  
  // Not worth it
  
    def googleCodeJamGooglerese(lines: String*): Seq[String] = {
    if (lines.length == 0) return Seq("")
    var letter: Char = lines.head(0)
    var outLetter: Char = ' ' 
//    letter match {
//      case 'a' => outLetter = 'y'
//      case 'b' => outLetter = ' '
//      case 'c' => outLetter = 'e'
//      case 'd' => outLetter = 's'
//      case 'e' => outLetter = 'o'
//      case 'f' => outLetter = 'c'
//      case 'g' => outLetter = 'v'
//      case 'h' => outLetter = ' '
//      case 'i' => outLetter = ' '
//      case 'j' => outLetter = 'u'
//      case 'k' => outLetter = 'i'
//      case 'l' => outLetter = 'g'
//      case 'm' => outLetter = 'l'
//      case 'n' => outLetter = 'b'
//      case 'o' => outLetter = 'k'
//      case 'p' => outLetter = 'r'
//      case 'q' => outLetter = 'z'
//      case 'r' => outLetter = 't'
//      case 's' => outLetter = 'n'
//      case 't' => outLetter = 'w'
//      case 'u' => outLetter = ' '
//      case 'v' => outLetter = 'p'
//      case 'w' => outLetter = 'f'
//      case 'x' => outLetter = 'm'
//      case 'y' => outLetter = 'a'
//      case 'z' => outLetter = ' '
//      case ' ' => outLetter = ' '
//    }
    return Seq(outLetter.toString) ++ googleCodeJamGooglerese(lines.drop(1).toString)
  }
}

/*========================================================== */

object CollectionExercise02 {

  class Person(val age: Int, val name: String)

  /**
   * Take a look at the java class: {@link ImperativeSample}. The
   * groupAdultsPerAgeGroup is implemented using an imperative programming
   * style.
   * Rewrite the method groupAdultsPerAgeGroup in the ImperativeSample java class
   * using a functional approach.
   */
  def groupAdultsPerAgeGroup(persons: Seq[Person]): Map[Int, Seq[Person]] = {
    var adults: Seq[Person] = (persons.filter((p: Person) => p.age > 17))
    var sortedAdults: Seq[Person] = adults.sortWith(_.name < _.name)
    var groupedAdults: List[Seq[Person]] = groupAdults(sortedAdults)
    var ageGroups: List[Int] = groupAges(groupedAdults)
    var groupings: List[(Int, Seq[Person])] = ageGroups.zip(groupedAdults)
    var map = Map(groupings map { pair => pair._1 -> pair._2 }: _*)
    return map
  }
  
  def groupAdults(persons: Seq[Person]): List[Seq[Person]] = {
    if (persons.length == 0) return List()
    else return List(persons.filter((p: Person) => (p.age) / 10 * 10 == ((persons.head).age) / 10 * 10)) ::: groupAdults(persons.filter ((p: Person) => (p.age) / 10 * 10 != ((persons.head).age) / 10 * 10))
  }
  
  def groupAges(personList: List[Seq[Person]]): List[Int] = {
    if (personList.length == 0) return List()
    else return List(((personList.head).head).age / 10 * 10) ::: groupAges(personList.tail)
  }
  
}

/*========================================================== */

object CollectionExercise03 {
  /**
   * Create a method that checks that each subsequent value is greater than
   * the previous one.
   * E.g.:
   * checkValuesIncrease(Seq(1,2,3)) == true
   * checkValuesIncrease(Seq(1,2,2)) == false
   */
  def checkValuesIncrease[T <% Ordered[T]](seq: Seq[T]): Boolean =
    if (seq.length == 0)
      return false
    else if (seq.length == 1)
      return true
    else
      return (seq(0) < seq(1)) && checkValuesIncrease(seq.tail)
}
/*========================================================== */

object CollectionExercise04 {
  /**
   * Calculate the length of the longest word in a list of sentences.
   * To keep it simple it's ok to use String.split to extract all words of a sentence.
   */
  def calcLengthLongestWord(lines: String*): Int = {
    if (lines.length == 0)
      return 0
    var longestWordList: List[Int] = lines.map(sizeOfLongestWord).toList
    return maxOfList(longestWordList)
  }
  
  def sizeOfLongestWord(sentence: String): Int = {
    var wordList: List[String] = sentence.split(" ").toList
    var wordSizeList: List[Int] = (wordList.map(_.length()))
    return maxOfList(wordSizeList)
  }
  
  def maxOfList(list: List[Int]): Int = {
    list.foldLeft(0)((m: Int, n: Int) => if(n>m) (n) else (m))
  }
}
