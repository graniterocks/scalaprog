package week2

object Rationals {
  val x = new Rational(1, 3)                      //> x  : week2.Rational = 1/3
	x.numer                                   //> res0: Int = 1
	
	val y = new Rational(5, 7)                //> y  : week2.Rational = 5/7
	x.add(y)                                  //> res1: week2.Rational = 22/21
	
	val z = new Rational(3, 2)                //> z  : week2.Rational = 3/2

	x.sub(y).sub(z)                           //> res2: week2.Rational = -79/42

	x.less(y)                                 //> res3: Boolean = true
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