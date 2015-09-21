package org.scalalabs.basic.lab03
import sys._
/**
 * This exercise introduces you to pattern matching in combination with recursion.
 *
 * Recursion is a key concept for the functional style programming.
 * In the exercises below you learn how to apply recursion in combination with Scala's pattern matching facilities.
 *
 * For this exercise exclusively use pattern matching constructs in order to make the corresponding unittest work.
 *
 * Reference material to solve these exercises can be found here:
 * Pattern matching in general: http://programming-scala.labs.oreilly.com/ch03.html#PatternMatching
 * Pattern matching and recursion: http://programming-scala.labs.oreilly.com/ch08.html#Recursion
 */

object RecursionPatternMatchingExercise {

  /**
   * ***********************************************************************
   * Recursive algorithms with pattern matching
   * For expected solution see unittest @RecursionPatternMatchingExerciseTest
   * ***********************************************************************
   */
  /**
   * Create a method that checks that each subsequent value is greater than
   * the previous one.
   * E.g.:
   * checkValuesIncrease(Seq(1,2,3)) == true
   * checkValuesIncrease(Seq(1,2,2)) == false
   */
  
  
  // Essentially all of these are much nicer to implement using higher-order functions
  // than by manual recursion. :(
  
  def checkValuesIncrease(seq: Seq[Int]): Boolean = {
    seq match {
      case a +: (rest@Seq(b, _*)) => (a < b) && checkValuesIncrease(rest)
      case _ => true
    }
  }
  
  /**
   * Group Consecutive values
   * List(1,1,2,3,1,1) -> List(1,1), List(2), List(3), List(1,1)
   */
  def groupConsecutive[T](in: List[T]): List[List[T]] = {
    in match {
      case List() => List()
      case a :: rest =>
        groupConsecutive(rest) match {
          case (b::rrest) :: groups if b == a => (a::b::rrest) :: groups
          case groups => List(a) :: groups
        }
    }
  }

  
  /**
   * Group Equal values
   * List(1,1,2,3,1,1) -> List(1,1,1,1), List(2), List(3)
   */
  def groupEquals[T](in: List[T]): List[List[T]] = {
    // groupEquals never produces empty groups
    groupEqualsHelp(in).values.toList sortBy {case a::_ => in indexOf a}
  }
  
  def groupEqualsHelp[T](in: List[T]): Map[T, List[T]] = {
    in match {
      case List() => Map()
      case a::rest =>
        val restMap = groupEqualsHelp(rest)
        restMap get a match {
          case None => restMap + (a -> List(a))
          case Some(as) => restMap + (a -> (a::as))
        }
    }
  }

  /**
   * Compress values
   * List(1,1,2,3,1,1) -> List(1,2,3)
   */
  def compress[T](in: List[T]): List[T] = {
    in match {
      case l@List() => l
      case l@List(a) => l
      case a :: rest => 
        if (a == rest.head)
          compress(rest)
        else
          a :: compress(rest)
    }
  }
  
  /**
   * Define the amount of all equal members
   * List(1,1,2,3,1,1) -> List((4,1),(1,2),(1,3))
   */
  def amountEqualMembers[T](in: List[T]): List[(Int, T)] = {
    groupEquals(in) map ((L) => (L.length, L.head))
  }
  
  /**
   * Zip multiple lists
   * List(List(1,2,3), List('A, 'B, 'C), List('a, 'b, 'c)) -> List(List(1, 'A, 'a), List(2, 'B, 'b), List(3, 'C, 'c))
   */
  def zipMultiple(in: List[List[_]]): List[List[_]] = {
    error("fix me")
  }
  
  

  /**
   * Zip multiple lists with different sizes
   * List(List(1), List('A, 'B, 'C), List('a, 'b)) -> List(List(1, 'A, 'a))
   */
  def zipMultipleWithDifferentSize(in: List[List[_]]): List[List[_]] = {
    error("fix me")
  }

}
