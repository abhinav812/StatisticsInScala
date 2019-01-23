package com.abhinav.scala.statistics

/**
  * Calculates quartiles of given range of Integers.
  * https://www.hackerrank.com/challenges/s10-quartiles/problem
  */
object Quartiles {
  def main(args: Array[String]): Unit = {
    val count: Int = 9
    //StdIn.readInt()
    val numbers: List[Int] = List(3, 7, 8, 5, 12, 14, 21, 13, 18)
    //StdIn.readLine().split(" ").map(_.toInt).toList

    val sortedNumbers = numbers.sorted

    val halfIndx = sortedNumbers.length / 2
    val lowerHalf = sortedNumbers.slice(0, halfIndx)
    val upperHalf = sortedNumbers.slice(halfIndx + (sortedNumbers.length % 2), sortedNumbers.length + 1)

    val q1 = calucateMedian(lowerHalf)
    val q2 = calucateMedian(sortedNumbers)
    val q3 = calucateMedian(upperHalf)

    println(q1)
    println(q2)
    println(q3)
  }

  private def calucateMedian(list: List[Int]): Int = {
    val halfIndx = list.length / 2
    if (list.length % 2 != 0)
      list(halfIndx)
    else
      list.slice(halfIndx - 1, halfIndx + 1).sum / 2
  }
}
