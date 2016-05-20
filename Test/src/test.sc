object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  // (define (cons x y) (lambda (m) (m x y)))
  def cons[T](x : T, y : T) = (m : (T, T) => Int) => m(x, y)
                                                  //> cons: [T](x: T, y: T)((T, T) => Int) => Int
 	
 	// (define (car z) (z (lambda (p q) p)))
 	def car[T](z : (((T, T) => T) => T)) = z((p : T, q : T) => p)
                                                  //> car: [T](z: ((T, T) => T) => T)T
 
 	def cdr[T](z : (((T, T) => T) => T)) = z((p : T, q : T) => q)
                                                  //> cdr: [T](z: ((T, T) => T) => T)T
 
  println(car(cons(1,2)))                         //> 1
 
  println(cdr(cons(1,2)))                         //> 2
  
  def problem1Helper(i : Int, sum : Int) : Int = {
  	if (i >= 1000)
  		sum
  	else if (i % 3 == 0 || i % 5 == 0)
  		problem1Helper(i+1, sum + i)
  	else
  		problem1Helper(i+1, sum)
  }                                               //> problem1Helper: (i: Int, sum: Int)Int
  
  println(problem1Helper(1, 0))                   //> 233168
  
  def problem1Answer = List.range(1, 1000).filter(i => i % 3 == 0 || i % 5 == 0).sum
                                                  //> problem1Answer: => Int
                                                  
  println(List.range(1, 1000).filter(i => i % 3 == 0 || i % 5 == 0).sum)
                                                  //> 233168
                                                 
  def addFibHelper(x : Int, y : Int) : List[Int] = {
  	val z = x + y
  	if (z > 4000000) Nil else	z :: addFibHelper(y, z)
  }                                               //> addFibHelper: (x: Int, y: Int)List[Int]
  
  val fibList = 1 :: 2 :: addFibHelper(1, 2)      //> fibList  : List[Int] = List(1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 37
                                                  //| 7, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121
                                                  //| 393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578)
  
  println(fibList.filter(_ % 2 == 0).sum)         //> 4613732
  
  def isPrimeHelper(x : Long, y : Long) : Boolean = {
  	y > 0 && ( y == 1 || (x % y != 0 && isPrimeHelper(x, y - 1)))
  }                                               //> isPrimeHelper: (x: Long, y: Long)Boolean
  		
  def isPrime(x : Long) = isPrimeHelper(x, x - 1) //> isPrime: (x: Long)Boolean
  
  def nextPrimeNumber(x : Long) : Long = if (isPrime(x + 1)) x + 1 else nextPrimeNumber(x+1)
                                                  //> nextPrimeNumber: (x: Long)Long
 
 	def smallestPrimeFactorHelper(x : Long, y : Long) : Long = if (x % y == 0) y else smallestPrimeFactorHelper(x, nextPrimeNumber(y))
                                                  //> smallestPrimeFactorHelper: (x: Long, y: Long)Long
  def smallestPrimeFactor(x : Long) = smallestPrimeFactorHelper(x, 2)
                                                  //> smallestPrimeFactor: (x: Long)Long
  
  def primeFactors(x : Long) : List[Long] = {
  	if (isPrime(x))
  		List(x)
 		else {
 			val y = smallestPrimeFactor(x)
 			y :: primeFactors(x / y)
 		}
  }                                               //> primeFactors: (x: Long)List[Long]
  val x : Long = 600851475143L                    //> x  : Long = 600851475143\
  val test = primeFactors(x)
  
  
}