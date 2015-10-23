package org.scalalabs.basic.lab02

import scala.collection.mutable.ListBuffer
 import sys._


object ListManipulationExercise02 {

  /**
   * Find the maximum element in a list, e.g. maxElementInList(List(1,9,3,5)) == 9
   * As usual, various ways exist: pattern matching, folding, ...
   */
  def maxElementInList(l: List[Int]): Int = {
    l.reduceLeft( _ max _ )
  }

  /**
   * Calculate the sum of the equally position elements
   * of the two lists
   */
  def sumOfTwo(l1: List[Int], l2: List[Int]): List[Int] = {
    (if (l1.length > 0 && l2.length > 0) (l1, l2).zipped.map(_+_)
    else if(l1.length == 0) l2
    else l1)
  }

  /**
   *  For this exercise preferably make use of the sumOfTwo
   * method above
   */
  def sumOfMany(l: List[Int]*): List[Int] = {
    l.reduceLeft(sumOfTwo)
  }

  case class Person(age: Int, firstName: String, lastName: String)

  /**
   * The following method is implemented in the most in-elegant way we could think of.
   * The idea is to re-write the method into more functional style. In the end, you
   * may be able to achieve the same functionality as implemented below
   * in a one-liner.
   */
  def separateTheYoungFromTheOld(persons: List[Person]): List[List[String]] = {
    List(persons.filter(_.age < 18).sortBy(_.age).map((person: Person) => person.firstName), 
        persons.filter(_.age >= 18).sortBy(_.age).map((person: Person) => person.firstName))
  }

}