package com.abhinav.scala.statistics

/*
  Solution to "Geometric Distribution II" problem
  https://www.hackerrank.com/challenges/s10-geometric-distribution-2/problem
 */
object GeometricDistribution2 {
  def main(args: Array[String]): Unit = {
    val p : Float = 1 / 3.0F // defective probability

    val n = 5

    val result: BigDecimal = (1 to 5).toList.map(geoProgression(_, p)).sum

    val numberFormat = new java.text.DecimalFormat("0.000")
    println(numberFormat.format(result))

  }

  def geoProgression(n: Int, p: Float): BigDecimal = {
    val q: Float = 1 - p
    Math.pow(q, n - 1) * p
  }

}
