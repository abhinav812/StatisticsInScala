package com.abhinav.scala.statistics

/*
Solution to "Poisson Distribution II" problem
https://www.hackerrank.com/challenges/s10-poisson-distribution-2/problem
 */
object PoissonDistribution2 {
  def main(args: Array[String]): Unit = {
    val meanA = 0.88F
    val meanB = 1.55F

    val resultA = 160 + 40 * (meanA + Math.pow(meanA, 2))
    val resultB = 128 + 40 * (meanB + Math.pow(meanB, 2))

    val numberFormat = new java.text.DecimalFormat("0.000")
    println(numberFormat.format(resultA))
    println(numberFormat.format(resultB))
  }

}
