package com.abhinav.scala.statistics

/*
  Calculates Mean, Median, and Mode.
  https://www.hackerrank.com/challenges/s10-basic-statistics/copy-from/96530968
 */
object BasicStatistics {
  val count: Int = scala.io.StdIn.readInt()
  val numbers: List[Int] = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList

  val mean: Float = numbers.sum / count.toFloat
  println(mean)

  val halfIndx: Int = (numbers.length / 2) - 1
  val median: Float = numbers.sorted.slice(halfIndx, halfIndx + 2).sum / 2F
  println(median)

  val temp: Seq[(Int, Int)] = numbers.groupBy(identity)
    .mapValues(_.size).
    toSeq
    .sortWith(_._2 > _._2)

  val highestCount: Int = temp.headOption.map(_._2).getOrElse(-1)

  val mode: Int = temp.filter(_._2 == highestCount).sortWith(_._1 < _._1).map(_._1).head

  println(mode)

}
