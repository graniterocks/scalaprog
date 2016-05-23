package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = if (c == 0 || c == r) 1 else pascal(c, r-1) + pascal(c-1, r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceHelper(openLefts: Int, chars: List[Char]): Boolean =
      if (chars.isEmpty)
        openLefts == 0
      else if (openLefts < 0)
        false
      else if (chars.head == '(')
        balanceHelper(openLefts + 1, chars.tail)
      else if (chars.head == ')')
        balanceHelper(openLefts - 1, chars.tail)
      else
        balanceHelper(openLefts, chars.tail)

    balanceHelper(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChangeHelper(money: Int, coins: List[Int]): Int = {
      if (money <= 0 || money > 0 && coins.isEmpty)
        0
      else if (money == coins.head)
        1
      else
        countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
    countChangeHelper(money, coins.sorted)
  }
}
