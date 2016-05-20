package week2

object Rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(62); 
  val x = new Rational(1, 3);System.out.println("""x  : week2.Rational = """ + $show(x ));$skip(9); val res$0 = 
	x.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(30); 
	
	val y = new Rational(5, 7);System.out.println("""y  : week2.Rational = """ + $show(y ));$skip(10); val res$1 = 
	x.add(y);System.out.println("""res1: week2.Rational = """ + $show(res$1));$skip(30); 
	
	val z = new Rational(3, 2);System.out.println("""z  : week2.Rational = """ + $show(z ));$skip(18); val res$2 = 

	x.sub(y).sub(z);System.out.println("""res2: week2.Rational = """ + $show(res$2));$skip(12); val res$3 = 

	x.less(y);System.out.println("""res3: Boolean = """ + $show(res$3))}
}

class Rational(x: Int, y: Int) {
	require(y != 0, "Division by zero")
	
	def this(x: Int) = this(x, 1)

	private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
	private val g = gcd(x, y)
	
	def numer = x / g
	def denom = y / g
	
	def less(that: Rational) : Boolean = numer * that.denom < that.numer * denom
	
	def max(that: Rational) : Rational = if (this.less(that)) that else this
	
	def add(that: Rational) : Rational = {
		new Rational(numer * that.denom + that.numer * denom,
			denom * that.denom)
	}
	
	def neg : Rational = new Rational(-numer, denom)
	
	def sub(that: Rational) : Rational = add(that.neg)
	
	override def toString = numer + "/" + denom
}
