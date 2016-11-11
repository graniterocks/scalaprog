

object SICP {
  println("Welcome to the Scala worksheet")
  
  
  def pascal(c: Int, r: Int): Int =
  	if (c == 0 || c == r)
  		1
  	else
  		pascal(c, r - 1) + pascal(c - 1, r - 1)
  def getPascal(rows: Int) : List[List[Int]] = {
  	
  }
  
  
  // Exercise 2.4
  // (define (cons x y) (lambda (m) (m x y)))
  def cons[T](x : T, y : T) = (m : (T, T) => Int) => m(x, y)
 	// (define (car z) (z (lambda (p q) p)))
 	def car[T](z : (((T, T) => T) => T)) = z((p : T, q : T) => p)
 	def cdr[T](z : (((T, T) => T) => T)) = z((p : T, q : T) => q)
 
  car(cons(2,3))
  

  cdr(cons(1,2))
 
}