package org.scalalabs.basic.lab02

import scala.collection.mutable.ListBuffer
 import sys._


object ListManipulationExercise02 {

  /**
   * Find the maximum element in a list, e.g. maxElementInList(List(1,9,3,5)) == 9
   * As usual, various ways exist: pattern matching, folding, ...
   */
  def maxElementInList(l: List[Int]): Int = {
    l match{
      case List(x:Int) => x
      case x :: y :: xs => maxElementInList((if (x>y) x else y)::xs)
      case nil => throw new IllegalArgumentException("empty list")
    }
  }

  /**
   * Calculate the sum of the equally position elements
   * of the two list
   */
  def sumOfTwo(l1: List[Int], l2: List[Int]): List[Int] = {
    (l1,l2) match {
      case (Nil,Nil) => List()
      case (x::xs,Nil) => (x::xs)
      case (Nil, y::ys) => (y::ys)
      case (x::xs,y::ys) => ((x+y)::sumOfTwo(xs,ys))
    }
  }

  /**
   *  For this exercise preferably make use of the sumOfTwo
   * method above
   */
  def sumOfMany(l: List[Int]*): List[Int] = {
    val listOfLists = l.toList
    def sumHelper(list:List[List[Int]]):List[Int] = {
      list match{
        case x::xs => sumOfTwo(x,sumHelper(xs))
        case Nil => Nil
      }
    }
    sumHelper(listOfLists)
  }

  case class Person(age: Int, firstName: String, lastName: String)

  /**
   * The following method is implemented in the most in-elegant way we could think of.
   * The idea is to re-write the method into more functional style. In the end, you
   * may be able to achieve the same functionality as implemented below
   * in a one-liner.
   */
  def separateTheYoungFromTheOld(persons: List[Person]): List[List[String]] = {
    val ageSorted = persons.sortBy(_.age)
    var (young,old) = ageSorted.partition(_.age<18)
    var (youngins,elders) = (young.sortBy(_.firstName),old.sortBy(_.firstName))
    List(youngins.map(_.firstName),elders.map(_.firstName))
  }
}