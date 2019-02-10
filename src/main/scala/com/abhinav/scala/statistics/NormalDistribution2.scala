package com.abhinav.scala.statistics

/*
  Solution to "Normal Distribution II" problem
  https://www.hackerrank.com/challenges/s10-normal-distribution-2/
 */
object NormalDistribution2 {
  def main(args: Array[String]): Unit = {
    val mean = 70
    val stdDev = 10

    val result1 = 100 * (1 - commulativeDistribution(mean, stdDev, 80))
    val result2 = 100 * (1 - commulativeDistribution(mean, stdDev, 60))
    val result3 = 100 * commulativeDistribution(mean, stdDev, 60)

    val numberFormat = new java.text.DecimalFormat("0.00")
    println(numberFormat.format(result1))
    println(numberFormat.format(result2))
    println(numberFormat.format(result3))
  }

  def commulativeDistribution(mean: Double, stdDev: Double, value: Double): Double = {
    val erfParam = (value - mean)/( stdDev *  Math.sqrt(2))
    1/2F * ( 1 + erf(erfParam))
  }



  def erf(z: Double): Double = {
    val t: Double = 1.0 / (1.0 + 0.5 * Math.abs(z))

    // use Horner's method
    val ans: Double = 1 - t *
      Math.exp(-z * z - 1.26551223
        + t * (1.00002368
        + t * (0.37409196
        + t * (0.09678418
        + t * (-0.18628806
        + t * (0.27886807
        + t * (-1.13520398
        + t * (1.48851587
        + t * (-0.82215223
        + t * 0.17087277)))))))))

    if (z >= 0) ans
    else  -ans
  }
}
