package org.scalalabs.basic.lab02

import scala.collection.mutable.ListBuffer
 import sys._


object ListManipulationExercise02 {

  /**
   * Find the maximum element in a list, e.g. maxElementInList(List(1,9,3,5)) == 9
   * As usual, various ways exist: pattern matching, folding, ...
   */
  def maxElementInList(l: List[Int]): Int = {
    l.reduce((a:Int, b:Int) => if (a >= b) a else b)
  }

  /**
   * Calculate the sum of the equally position elements
   * of the two list
   */
  def sumOfTwo(l1: List[Int], l2: List[Int]): List[Int] = {
    (l1, l2) match {
      case (Nil, ll2) => ll2
      case (ll1, Nil) => ll1
      case (ll1, ll2) => ll1.zip(ll2).map { case (a:Int,b:Int) => a+b }
    }
  }

  /**
   *  For this exercise preferably make use of the sumOfTwo
   * method above
   */
  def sumOfMany(l: List[Int]*): List[Int] = {
    l.toList match {
      case head :: tail => sumOfTwo( head, sumOfMany(tail:_*) )
      case Nil => Nil
    }
    //l.reduce{ lp:List[Int],List[Int] => lp match {case (a:List[Int], b:List[Int]) => sumOfTwo(a,b) }}
  }

  case class Person(age: Int, firstName: String, lastName: String)

  /**
   * The following method is implemented in the most in-elegant way we could think of.
   * The idea is to re-write the method into more functional style. In the end, you
   * may be able to achieve the same functionality as implemented below
   * in a one-liner.
   */
  def separateTheYoungFromTheOld(persons: List[Person]): List[List[String]] = {
    def dostuff(people: List[Person]) = people.sortBy(_.age).map(_.firstName)
    val (youngs, old) = persons.partition(p => p.age < 18)
    List( dostuff(youngs), dostuff(old) )
    //match {
    //  case (ys, os) => List(ys.sortBy(_.age).map(p => p.firstName), os.sortBy(_.age).map(p => p.firstName))
    //}
    //persons.partition(p => p.age < 18) match {
    //  case (ys, os) => List(ys.sortBy(_.age).map(p => p.firstName), os.sortBy(_.age).map(p => p.firstName))
    //}
    //var youngins: ListBuffer[Person] = new ListBuffer[Person]()
    //var elders: ListBuffer[Person] = new ListBuffer[Person]()
    //var validYoungNames: ListBuffer[String] = new ListBuffer[String]()
    //var validOldNames: ListBuffer[String] = new ListBuffer[String]()

    //for (person <- persons) {
    //    if (person.age < 18) {
    //      youngins += person
    //    } else {
    //      elders += person
    //    }
    //}

    //var sortedYoung = youngins.toList.sortBy(_.age)
    //var sortedOld = elders.toList.sortBy(_.age)

    //for (young <- sortedYoung) {
    //  validYoungNames += young.firstName
    //}
    //for (old <- sortedOld) {
    //  validOldNames += old.firstName
    //}
    //List(validYoungNames.toList, validOldNames.toList)
  }

}
