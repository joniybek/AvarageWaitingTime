package me.jakhashr.challenges

import java.util.Scanner

import org.scalatest.{FlatSpec, Matchers}

class GlobalsTest extends FlatSpec with Matchers {

  "verifiedInput" should "return Int from Scanner within given constraints" in {
    implicit val sc = new Scanner("3 10")
    verifiedInput("testVar",1, 1 ) shouldBe a[java.lang.Integer]
    verifiedInput("testVar",1, 1 ) should be(10)
  }

  "verifiedInput" should "produce Exception if lower constraint is violated" in {
    assertThrows[Exception] {
      implicit val sc = new Scanner("0")
      verifiedInput("testVar",1, 1 )
    }
  }

  "verifiedInput" should "produce Exception if upper constraint is violated" in {
    assertThrows[Exception] {
      implicit val sc = new Scanner("100")
      verifiedInput("testVar",1, 1 )
    }
  }
}
