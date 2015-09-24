package org.scalalabs.basic.lab02

import scala.collection.mutable.ListBuffer
 import sys._


object ListManipulationExercise02 {

  /**
   * Find the maximum element in a list, e.g. maxElementInList(List(1,9,3,5)) == 9
   * As usual, various ways exist: pattern matching, folding, ...
   */
  def maxElementInList(l: List[Int]): Int = {
    l.reduce(math.max)
  }

  /**
   * Calculate the sum of the equally position elements
   * of the two list
   */
  def sumOfTwo(l1: List[Int], l2: List[Int]): List[Int] = {
    (l1, l2) match {
      case (Nil, l) => l
      case (l, Nil) => l
      case (x::xs, y::ys) => (x+y)::sumOfTwo(xs, ys)
    }
  }

  /**
   *  For this exercise preferably make use of the sumOfTwo
   * method above
   */
  def sumOfMany(l: List[Int]*): List[Int] = {
    l reduce sumOfTwo
  }

  case class Person(age: Int, firstName: String, lastName: String)

  /**
   * The following method is implemented in the most in-elegant way we could think of.
   * The idea is to re-write the method into more functional style. In the end, you
   * may be able to achieve the same functionality as implemented below
   * in a one-liner.
   */
  def separateTheYoungFromTheOld(persons: List[Person]): List[List[String]] = {
    // This isn’t a very nice one-liner; it looks like there’s no way to got from (T, T) to List[T] nicely
    (persons.partition(p => p.age < 18) match {case (x, y) => List(x, y)}).map(l => l.sortBy(_.age).map(_.firstName))
  }

}