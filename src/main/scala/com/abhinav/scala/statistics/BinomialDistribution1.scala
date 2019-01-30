package com.abhinav.scala.statistics

import java.text.DecimalFormat

/*
  Solution to "Binomial Distribution I" problem
  https://www.hackerrank.com/challenges/s10-binomial-distribution-1/
 */
object BinomialDistribution1 {
  def main(args: Array[String]): Unit = {
    val BR: Float = 1.09F
    val GR: Float = 1.0F

    val p: Float = BR / (BR + GR)
    val n = 6

    val result: BigDecimal = (3 until 7).toList.map(x => binominal(x, n, p)).sum

    val numberFormat = new DecimalFormat("0.000")
    print(numberFormat.format(result))

  }

  def binominal(x: Double, n: Double, p: Float): BigDecimal = {
    val q: Float = 1 - p
    combination(n, x) * Math.pow(p, x) * Math.pow(q, n - x)
  }

  def combination(n: Double, x: Double): BigDecimal = fact(n.toInt) / (fact(x.toInt) * fact(n.toInt - x.toInt))

  def fact(num: Int): BigDecimal = if (num == 0) BigDecimal.valueOf(1)
  else
    (1 to num)
      .map(BigDecimal.valueOf(_))
      .foldLeft(BigDecimal.valueOf(1))(
        (fact, reminder) => fact * reminder
      )


}
