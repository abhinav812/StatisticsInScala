package com.abhinav.scala.statistics

/*
Solution to "Poisson Distribution I" problem
https://www.hackerrank.com/challenges/s10-poisson-distribution-1/problem
 */
object PoissonDistribution1 {
  def main(args: Array[String]): Unit = {
    val l = 2.5F
    val k = 5

    val result = poissonDist(l, k)
    val numberFormat = new java.text.DecimalFormat("0.000")
    println(numberFormat.format(result))
  }

  def poissonDist(l: Float, k: Float): BigDecimal = {
    val e = Math.E
    (Math.pow(l, k) * Math.pow(e, -l)) / fact(k.toInt)
  }

  def fact(num: Int): BigDecimal = if (num == 0) BigDecimal.valueOf(1)
  else
    (1 to num)
      .map(BigDecimal.valueOf(_))
      .foldLeft(BigDecimal.valueOf(1))(
        (fact, reminder) => fact * reminder
      )

}
