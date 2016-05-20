object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
  println("Welcome to the Scala worksheet");$skip(65); 
  
   def cons[T](x : T, y : T) = (m : (T, T) => Int) => m(x, y);System.out.println("""cons: [T](x: T, y: T)((T, T) => Int) => Int""");$skip(107); 
 	// (define (car z) (z (lambda (p q) p)))
 	def car[T](z : (((T, T) => T) => T)) = z((p : T, q : T) => p);System.out.println("""car: [T](z: ((T, T) => T) => T)T""");$skip(64); 
 	def cdr[T](z : (((T, T) => T) => T)) = z((p : T, q : T) => q);System.out.println("""cdr: [T](z: ((T, T) => T) => T)T""");$skip(28); 
 
  println(car(cons(2,3)));$skip(28); 
 
  println(cdr(cons(1,2)))}
}
