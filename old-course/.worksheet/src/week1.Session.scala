package week1

import scala.annotation.tailrec

object Session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(108); 
  def abs(x: Double) = if (x > 0) x else -x;System.out.println("""abs: (x: Double)Double""");$skip(211); 
  
 
  def factorial(x: Int) = {
    @tailrec
  	def factorialHelper(factorial: Int, x: Int): Int =
  		if (x == 0)
  			factorial
  		else
  			factorialHelper(factorial*x, x-1)
  
  	factorialHelper(1, x)
  };System.out.println("""factorial: (x: Int)Int""");$skip(29); 
  
  val test = factorial(4);System.out.println("""test  : Int = """ + $show(test ))}
}
