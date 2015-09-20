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
  def checkValuesIncrease(seq: Seq[Int]): Boolean = {
    if (seq.length == 0) return false
    if (seq.length == 1) return true
    else
      (seq(0) < seq(1)) match {
      case true => return checkValuesIncrease(seq.tail)
      case false => return false
    }
  }
  
  /**
   * Group Consecutive values
   * List(1,1,2,3,1,1) -> List(1,1), List(2), List(3), List(1,1)
   */
  def groupConsecutive[T](in: List[T]): List[List[T]] = in.length match{
    case 0 => List()
    case 1 => List(in)
    case _ => subGroup(in) :: groupConsecutive(in.drop(subGroup(in).length))
  }
  
  def subGroup[T](in: List[T]): List[T] = in.length match {
    case 0 => List()
    case 1 => in
    case _ => in takeWhile {in.head ==}
  }

  /**
   * Group Equal values
   * List(1,1,2,3,1,1) -> List(1,1,1,1), List(2), List(3)
   */
  def groupEquals[T](in: List[T]): List[List[T]] = in.length match{
    case 0 => List()
    case 1 => List(in)
    case _ => List(in.filter((item: T) => item == in.head)) ::: groupEquals(in.filter((item: T) => item != in.head))
  }

  /**
   * Compress values
   * List(1,1,2,3,1,1) -> List(1,2,3)
   */
  def compress[T](in: List[T]): List[T] = in.length match{
    case 0 => List()
    case 1 => in
    case _ => List(in.head) ::: compress(in.filter((item: T) => item != in.head))
  }
  
  /**
   * Define the amount of all equal members
   * List(1,1,2,3,1,1) -> List((4,1),(1,2),(1,3))
   */
  def amountEqualMembers[T](in: List[T]): List[(Int, T)] = in.length match{
    case 0 => List()
    case 1 => List((1, in.head))
    case _ => List(((in.filter((item: T) => item == in.head)).length, in.head)) ::: amountEqualMembers(in.filter((item: T) => item != in.head))
  }
  
  /**
   * Zip multiple lists
   * List(List(1,2,3), List('A, 'B, 'C), List('a, 'b, 'c)) -> List(List(1, 'A, 'a), List(2, 'B, 'b), List(3, 'C, 'c))
   */
  def zipMultiple(in: List[List[_]]): List[List[_]] = {
    if (in.length == 0 || in.length == 1) return in
    (in.head).length match{
    case 0 => List()
    case _ => List(zipHeads(in)) ::: zipMultiple(in.map(_.tail))
    }
  }
  
  def zipHeads(in: List[List[_]]): List[_] = {
    if (in.length == 0) return List()
    if (in.length == 1) return List((in.head).head)
    else return List((in.head).head) ::: zipHeads(in.tail)
  }

  /**
   * Zip multiple lists with different sizes
   * List(List(1), List('A, 'B, 'C), List('a, 'b)) -> List(List(1, 'A, 'a))
   */
  def zipMultipleWithDifferentSize(in: List[List[_]]): List[List[_]] = {
    if (in.length == 0 || in.length == 1) return in
    in.foldLeft(true)((b: Boolean, list: List[_]) => b && (list.length != 0)) match{
    case false => List()
    case true => List(zipHeads(in))::: zipMultipleWithDifferentSize(in.map(_.tail))
    }
  }

}
