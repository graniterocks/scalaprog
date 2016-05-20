object test {
  println("Welcome to the Scala worksheet")
  
   def cons[T](x : T, y : T) = (m : (T, T) => Int) => m(x, y)
 	// (define (car z) (z (lambda (p q) p)))
 	def car[T](z : (((T, T) => T) => T)) = z((p : T, q : T) => p)
 	def cdr[T](z : (((T, T) => T) => T)) = z((p : T, q : T) => q)
 
  println(car(cons(2,3)))
 
  println(cdr(cons(1,2)))
}