package week1

import scala.annotation.tailrec

object Session {
  def abs(x: Double) = if (x > 0) x else -x       //> abs: (x: Double)Double
  
 
  def factorial(x: Int) = {
    @tailrec
  	def factorialHelper(factorial: Int, x: Int): Int =
  		if (x == 0)
  			factorial
  		else
  			factorialHelper(factorial*x, x-1)
  
  	factorialHelper(1, x)
  }                                               //> factorial: (x: Int)Int
  
  val test = factorial(4)                         //> test  : Int = 24
}