object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
  println("Welcome to the Scala worksheet");$skip(108); 

  // (define (cons x y) (lambda (m) (m x y)))
  def cons[T](x : T, y : T) = (m : (T, T) => Int) => m(x, y);System.out.println("""cons: [T](x: T, y: T)((T, T) => Int) => Int""");$skip(110); 
 	
 	// (define (car z) (z (lambda (p q) p)))
 	def car[T](z : (((T, T) => T) => T)) = z((p : T, q : T) => p);System.out.println("""car: [T](z: ((T, T) => T) => T)T""");$skip(66); 
 
 	def cdr[T](z : (((T, T) => T) => T)) = z((p : T, q : T) => q);System.out.println("""cdr: [T](z: ((T, T) => T) => T)T""");$skip(28); 
 
  println(car(cons(1,2)));$skip(28); 
 
  println(cdr(cons(1,2)));$skip(192); 
  
  def problem1Helper(i : Int, sum : Int) : Int = {
  	if (i >= 1000)
  		sum
  	else if (i % 3 == 0 || i % 5 == 0)
  		problem1Helper(i+1, sum + i)
  	else
  		problem1Helper(i+1, sum)
  };System.out.println("""problem1Helper: (i: Int, sum: Int)Int""");$skip(35); 
  
  println(problem1Helper(1, 0));$skip(88); 
  
  def problem1Answer = List.range(1, 1000).filter(i => i % 3 == 0 || i % 5 == 0).sum;System.out.println("""problem1Answer: => Int""");$skip(124); 
                                                  
  println(List.range(1, 1000).filter(i => i % 3 == 0 || i % 5 == 0).sum);$skip(177); 
                                                 
  def addFibHelper(x : Int, y : Int) : List[Int] = {
  	val z = x + y
  	if (z > 4000000) Nil else	z :: addFibHelper(y, z)
  };System.out.println("""addFibHelper: (x: Int, y: Int)List[Int]""");$skip(48); 
  
  val fibList = 1 :: 2 :: addFibHelper(1, 2);System.out.println("""fibList  : List[Int] = """ + $show(fibList ));$skip(45); 
  
  println(fibList.filter(_ % 2 == 0).sum);$skip(126); 
  
  def isPrimeHelper(x : Long, y : Long) : Boolean = {
  	y > 0 && ( y == 1 || (x % y != 0 && isPrimeHelper(x, y - 1)))
  };System.out.println("""isPrimeHelper: (x: Long, y: Long)Boolean""");$skip(55); 
  		
  def isPrime(x : Long) = isPrimeHelper(x, x - 1);System.out.println("""isPrime: (x: Long)Boolean""");$skip(96); 
  
  def nextPrimeNumber(x : Long) : Long = if (isPrime(x + 1)) x + 1 else nextPrimeNumber(x+1);System.out.println("""nextPrimeNumber: (x: Long)Long""");$skip(135); 
 
 	def smallestPrimeFactorHelper(x : Long, y : Long) : Long = if (x % y == 0) y else smallestPrimeFactorHelper(x, nextPrimeNumber(y));System.out.println("""smallestPrimeFactorHelper: (x: Long, y: Long)Long""");$skip(70); 
  def smallestPrimeFactor(x : Long) = smallestPrimeFactorHelper(x, 2);System.out.println("""smallestPrimeFactor: (x: Long)Long""");$skip(163); 
  
  def primeFactors(x : Long) : List[Long] = {
  	if (isPrime(x))
  		List(x)
 		else {
 			val y = smallestPrimeFactor(x)
 			y :: primeFactors(x / y)
 		}
  };System.out.println("""primeFactors: (x: Long)List[Long]""");$skip(31); 
  val x : Long = 600851475143L;System.out.println("""x  : Long = """ + $show(x ));$skip(29); 
  val test = primeFactors(x);System.out.println("""test  : List[Long] = """ + $show(test ))}
  
  
}
