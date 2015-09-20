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
    seq match {
      case first :: second :: _ if second <= first => false
      case first :: second :: rest => checkValuesIncrease(second :: rest)
      case _ => true
    }
  }
  
  /**
   * Group Consecutive values
   * List(1,1,2,3,1,1) -> List(1,1), List(2), List(3), List(1,1)
   */
  def groupConsecutive[T](in: List[T]): List[List[T]] = {
    in match {
      case Nil => Nil
      case head :: tail => {
        groupConsecutive[T](tail) match {
          case (newhead :: restOfFirstGroup) :: restOfLists if head == newhead
            => (newhead :: newhead :: restOfFirstGroup) :: restOfLists
          case lists => List(head) :: lists
        }
      }
    }
  }

  /**
   * Group Equal values
   * List(1,1,2,3,1,1) -> List(1,1,1,1), List(2), List(3)
   */
  def groupEquals[T](in: List[T]): List[List[T]] = {
    in match {
      case Nil => Nil
      case head :: tail => {
        val (same, rest) = in.partition(_ == head)
        same :: groupEquals(rest)
      }
    }
  }

  /**
   * Compress values
   * List(1,1,2,3,1,1) -> List(1,2,3)
   */
  def compress[T](in: List[T]): List[T] = {
    in match {
      case Nil => Nil
      case head :: tail => {
        head :: compress( tail.filterNot(_ == head) )
      }
    }
  }
  
  /**
   * Define the amount of all equal members
   * List(1,1,2,3,1,1) -> List((4,1),(1,2),(1,3))
   */
  def amountEqualMembers[T](in: List[T]): List[(Int, T)] = {
    in match {
      case Nil => Nil
      case head :: tail => {
        (in.count(_ == head), head) :: amountEqualMembers( tail.filterNot(_ == head) )
      }
    }
  }
  
  /**
   * Zip multiple lists
   * List(List(1,2,3), List('A, 'B, 'C), List('a, 'b, 'c)) -> List(List(1, 'A, 'a), List(2, 'B, 'b), List(3, 'C, 'c))
   */
  def zipMultiple(in: List[List[_]]): List[List[_]] = {

    // Applies f to every pair. a and b should be same length
    def zipWith[T,U,V](a: List[T], b: List[U], f: (T, U) => V ) : List[V] = {
      (a,b) match {
        case (Nil, Nil) => Nil
        case (af :: ar, bf :: br) => f(af, bf) :: zipWith(ar, br, f)
      }
    }

    def cons(a: Any, b: List[_]) : List[_] = a :: b

    in match {
      case Nil => Nil
      case last :: Nil => last.map(List(_))
      case first :: rest => zipWith(first, zipMultiple(rest), cons)
    }
  }

  /**
   * Zip multiple lists with different sizes
   * List(List(1), List('A, 'B, 'C), List('a, 'b)) -> List(List(1, 'A, 'a))
   */
  def zipMultipleWithDifferentSize(in: List[List[_]]): List[List[_]] = {
    def min(a:Int,b:Int):Int = if (a < b) a else b
    val shortestSize = in.foldLeft(Int.MaxValue)((oldmin, curList) => min(oldmin, curList.length))
    zipMultiple(in.map(_.take(shortestSize)))
  }

}
