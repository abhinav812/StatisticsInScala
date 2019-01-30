package com.abhinav.scala.statistics

/*
  Solution to "Binomial Distribution II" problem
  https://www.hackerrank.com/challenges/s10-binomial-distribution-2/problem
 */
object BinomialDistribution2 {
  def main(args: Array[String]): Unit = {
    val rejects: Float = 0.12F

    val p: Float = rejects
    val n = 10

    val result1: BigDecimal = (0 to 2).toList.map(x => binominal(x, n, p)).sum
    val result2: BigDecimal = (2 to 10).toList.map(x => binominal(x, n, p)).sum

    val numberFormat = new java.text.DecimalFormat("0.000")
    println(numberFormat.format(result1))
    println(numberFormat.format(result2))

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
