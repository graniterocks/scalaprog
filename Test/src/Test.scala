object Test {

  def isPrime(x: Long) = {
    def isPrimeHelper(x: Long, y: Long): Boolean = y == x || (x % y != 0 && isPrimeHelper(x, y + 1))
    isPrimeHelper(x, 2)
  }

  def nextPrimeNumber(x: Long): Long = if (isPrime(x + 1)) x + 1 else nextPrimeNumber(x + 1)

  def smallestPrimeFactor(x: Long) = {
    def smallestPrimeFactorHelper(x: Long, y: Long): Long = {
      if (x % y == 0) y else smallestPrimeFactorHelper(x, nextPrimeNumber(y))
    }
    smallestPrimeFactorHelper(x, 2)
  }

  def primeFactors(x: Long): List[Long] = {
    if (isPrime(x))
      List(x)
    else {
      val y = smallestPrimeFactor(x)
      y :: primeFactors(x / y)
    }
  } //> primeFactors: (x: Long)List[Long]

  def split(x: Int): List[Int] = x.toString.map(_.asDigit).toList

  def isPalindrome(x: Int): Boolean = {
    val xList = split(x)
    xList.zip(xList.reverse).filter(z => z._1 != z._2).size == 0
  }

  def palindromes(x : List[Int], y : List[Int]) : List[Int] = {
    def palindromesHelper(x : Int, y : List[Int]) : List[Int] = {
      if (y == Nil) {
        Nil
      } else if (isPalindrome(x * y.head)) {
        x * y.head :: palindromesHelper(x, y.tail)
      } else {
        palindromesHelper(x, y.tail)
      }   
    }
    
    if (x == Nil) {
      Nil
    } else {
      palindromesHelper(x.head, y) ::: palindromes(x.tail, y)
    }
  }
  
  def smallestEvenlyDivisible(x : Int, lx : List[Int]) : Int = {
    def canBeDividedBy(x : Int, lx : List[Int]) : Boolean = lx == Nil || (x % lx.head == 0 && canBeDividedBy(x, lx.tail))
    if (canBeDividedBy(x, lx)) { x } else { smallestEvenlyDivisible(x + 1, lx) }
  }
  
  def addtest(x : Int, y : Int) = x + y
  
  def addtestp(x : Int) : Int => Int = addtest(x, _ )
  
  def main(args: Array[String]) = {
  //println(palindromes(List.range(100, 1000), List.range(100, 1000)).max)
  //  println(smallestEvenlyDivisible(20, List.range(1, 20)))
    
    println(addtestp(1) (2))
  }
}