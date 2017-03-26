package me.jakhashr.challenges

/**
  * Created by jakhashr on 26.03.2017.
  */
object MinFunc {

  def main(args: Array[String]): Unit = {

    implicit val sc = new java.util.Scanner(System.in)

    val n = verifiedInput("Number of customers", from = 0, to10thPow = 5)

    var queue = Vector.fill(n)(0)
      .map(_ => Order(verifiedInput("Ordered time", from = 0, to10thPow = 9)
        , verifiedInput("Time to prepare", from = 1, to10thPow = 9))
      )

    // Algo has O(N^2)
    var totWaitTime = 0
    var totDur = 0
    while (queue.nonEmpty) {
      // Let L M be orderTime and duration of cooking, ' - denote previous iter vars
      // then Total time passed since start is T = M + max(0, L-T')
      // hence Total waiting time W = W' + M + max(0, T'-L), we want to minimize that
      val min = queue.minBy(x => {
        if (x.orderTime >= totDur) {
          Math.pow(10, 9) + x.duration // Penalty so that cook won't wait for future orders if he/she has already one
        } else {
          x.duration - totDur - x.orderTime
        }
      })
      totWaitTime += min.duration + Math.max(0, totDur - min.orderTime)
      totDur += min.duration + Math.max(0, min.orderTime - totDur)
      queue = queue.filter(x => x != min)
    }

    println(totWaitTime / n)

  }

}
