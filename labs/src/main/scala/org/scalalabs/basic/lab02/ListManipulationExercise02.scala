package org.scalalabs.basic.lab02

import scala.collection.mutable.ListBuffer
 import sys._


object ListManipulationExercise02 {

  /**
   * Find the maximum element in a list, e.g. maxElementInList(List(1,9,3,5)) == 9
   * As usual, various ways exist: pattern matching, folding, ...
   */
  def maxElementInList(l: List[Int]): Int = {
    return l.foldLeft(0)((m: Int, n:Int) => if (n > m) n else m)
  }

  /**
   * Calculate the sum of the equally position elements
   * of the two list
   */
  def sumOfTwo(l1: List[Int], l2: List[Int]): List[Int] = {
    if (l1.length == 0)
      return l2
    if (l2.length == 0)
      return l1
    else
      return (l1.zip(l2)) map ({ case (i:Int, j:Int) => i+j})
  }

  /**
   *  For this exercise preferably make use of the sumOfTwo
   * method above
   */
  def sumOfMany(l: List[Int]*): List[Int] = {
    if (l.length == 0)
      return List()
    else if (l.length == 1)
      return l.head
    else 
      return l.reduceLeft((l1: List[Int], l2: List[Int]) => sumOfTwo(l1, l2))
  }

  case class Person(age: Int, firstName: String, lastName: String)

  /**
   * The following method is implemented in the most in-elegant way we could think of.
   * The idea is to re-write the method into more functional style. In the end, you
   * may be able to achieve the same functionality as implemented below
   * in a one-liner.
   */
  def separateTheYoungFromTheOld(persons: List[Person]): List[List[String]] = {
    List((persons.filter(_.age<18).sortBy(_.age)).map((person: Person) => person.firstName), 
        (persons.filter(_.age>=18).sortBy(_.age)).map((person: Person) => person.firstName))
  }

}