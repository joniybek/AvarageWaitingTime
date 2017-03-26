package me.jakhashr

import java.util.Scanner

/**
  * Created by jakhashr on 26.03.2017.
  */
package object challenges {

  case class Order(orderTime: Int, duration: Int)

  def verifiedInput(varName: String, from: Int, to10thPow: Int)(implicit sc: Scanner): Int = {
    import Math._
    val value = sc.nextInt()
    if (value < from || value > pow(10, to10thPow))
      throw new IllegalArgumentException(s"Constraint violation; $varName is not within range of [$from;10^$to10thPow]")
    else value
  }
}
