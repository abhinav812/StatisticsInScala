package com.abhinav.scala.statistics

import java.text.DecimalFormat

import scala.collection.mutable
import scala.io.StdIn

/*
Calculates Weighted Mean for a set of weighted numbers
https://www.hackerrank.com/challenges/s10-weighted-mean/problem
 */

object WeightedMean extends {
  val count: Int = StdIn.readInt()

  val numbers: List[Int] = StdIn.readLine().split(" ").map(_.toInt).toList
  val weight: List[Int] = StdIn.readLine().split(" ").map(_.toInt).toList

  val weightedMean: Float = numbers.zip(weight).foldLeft(mutable.ListBuffer.empty[Int]) {
    (result, num) =>
      result += (num._1 * num._2)
  }.toList.sum / weight.sum.toFloat

  val numberFormat = new DecimalFormat("#.0")
  println(numberFormat.format(weightedMean))
}
