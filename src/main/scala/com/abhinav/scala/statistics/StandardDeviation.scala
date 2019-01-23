package com.abhinav.scala.statistics

import java.text.DecimalFormat

import scala.collection.mutable

/**
  * Given an array, X, of N integers, calculate and print the standard deviation.
  * https://www.hackerrank.com/challenges/s10-standard-deviation/problem
  */
object StandardDeviation {
  def main(args: Array[String]): Unit = {
    val count: Int = 5
    //StdIn.readInt()
    val numbers: List[Int] = List(10, 40, 30, 50, 20)
    //StdIn.readLine().split(" ").map(_.toInt).toList

    val mean: Float = numbers.sum / count.toFloat

    val variance: Double = numbers.foldLeft(mutable.ListBuffer.empty[Float]) {
      (temp, i) =>
        temp += Math.abs(mean - i) * Math.abs(mean - i)
    }.sum / count.toFloat

    val stdDev: Double = Math.sqrt(variance)

    val numberFormat = new DecimalFormat("#.0")
    println(numberFormat.format(stdDev))
  }

}
