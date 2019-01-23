package com.abhinav.scala.statistics

import scala.collection.mutable
import scala.io.StdIn

/**
  * Calculates interquartile range of a given array of Integers
  * https://www.hackerrank.com/challenges/s10-interquartile-range/problem
  *
  */
object InterquartileRange {
  def main(args: Array[String]): Unit = {
    val count: Int = 6
      //StdIn.readInt()
    val numbers: List[Int] = List(6, 12 ,8, 10, 20, 16)
      //StdIn.readLine().split(" ").map(_.toInt).toList
    val weights: List[Int] = List(5, 4, 3, 2, 1, 5)
      //StdIn.readLine().split(" ").map(_.toInt).toList

    val x: List[(Int, Int)] = numbers.zip(weights).sortWith(_._1 < _._1)

    val mergedList: List[Int] = x.foldLeft(mutable.ListBuffer.empty[Int]) {
      (mergedList, i) => mergedList ++= List.fill(i._2)(i._1)
    }.toList

    val (lowerHalf, upperHalf) = splitInTwo(mergedList)
    val q1: Float = calculateMedian(lowerHalf)
    val q3: Float = calculateMedian(upperHalf)

    val iq = q3 - q1
    println(iq)
  }

  private def splitInTwo(list: List[Int]): (List[Int], List[Int]) = {
    val halfIndx = list.length / 2
    val lowerHalf = list.slice(0, halfIndx)
    val upperHalf = list.slice(halfIndx + (list.length % 2), list.length + 1)

    (lowerHalf, upperHalf)
  }

  private def calculateMedian(list: List[Int]): Float = {
    val halfIndx = list.length / 2
    if (list.length % 2 != 0)
      list(halfIndx)
    else
      list.slice(halfIndx - 1, halfIndx + 1).sum / 2.0F
  }
}
