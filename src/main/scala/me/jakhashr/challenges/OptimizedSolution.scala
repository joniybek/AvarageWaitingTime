package me.jakhashr.challenges

import scala.collection.mutable

object OptimizedSolution {
  def main(args: Array[String]): Unit = {

    implicit val sc = new java.util.Scanner(System.in)

    val n = verifiedInput("Number of customers", from = 0, to10thPow = 5)

    val queue = mutable.PriorityQueue.empty[Order](Ordering.by((t) => -t.orderTime))
    (1 until n).foreach(_ => {
      queue.enqueue(Order(verifiedInput("Ordered time", from = 0, to10thPow = 9)
        , verifiedInput("Time to prepare", from = 1, to10thPow = 9)))
    })

    val waiting = mutable.PriorityQueue.empty[(Int, Order)](Ordering.by((t) => -t._1))
    var min = queue.dequeue()
    var totDur = min.duration + min.orderTime
    var totWaitTime = min.duration - min.orderTime

    while (queue.nonEmpty || waiting.nonEmpty) {

      while (queue.nonEmpty && queue.head.orderTime < totDur) {
        min = queue.dequeue()
        waiting.enqueue((min.duration - min.orderTime, min))
      }

      min = if (waiting.isEmpty) queue.dequeue() else waiting.dequeue()._2
      totWaitTime += min.duration + Math.max(0, totDur - min.orderTime)
      totDur += min.duration + Math.max(0, min.orderTime - totDur)
    }

    println(totWaitTime / n)
  }
}
