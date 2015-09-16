package org.scalalabs.basic.lab02

import scala.collection.mutable.ListBuffer
 import sys._


object ListManipulationExercise02 {

  /**
   * Find the maximum element in a list, e.g. maxElementInList(List(1,9,3,5)) == 9
   * As usual, various ways exist: pattern matching, folding, ...
   */
  def maxElementInList(l: List[Int]): Int = l.max

  /**
   * Calculate the sum of the equally position elements
   * of the two list
   */
  def sumOfTwo(l1: List[Int], l2: List[Int]): List[Int] =
    if (l1.isEmpty)
      l2
    else if (l2.isEmpty)
      l1
    else
      (l1 zip l2).map(p ⇒ p._1 + p._2)

  /**
   *  For this exercise preferably make use of the sumOfTwo
   * method above
   */
  def sumOfMany(l: List[Int]*): List[Int] = (List.empty[Int] /: l)(sumOfTwo)

  case class Person(age: Int, firstName: String, lastName: String)

  /**
   * The following method is implemented in the most in-elegant way we could think of.
   * The idea is to re-write the method into more functional style. In the end, you
   * may be able to achieve the same functionality as implemented below
   * in a one-liner.
   */
  def separateTheYoungFromTheOld(persons: List[Person]): List[List[String]] =  {
    val (young, old) = persons.partition(_.age < 18)
    def sortAgeGetName(l: List[Person]): List[String] = 
      l.sortBy(_.age).map(_.firstName)
    List(sortAgeGetName(young), sortAgeGetName(old))
  }

}