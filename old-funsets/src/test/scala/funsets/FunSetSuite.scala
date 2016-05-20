package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
  
  test("intersect") {
    new TestSets {
      val s12 = union(s1, s2)
      val s23 = union(s2, s3)
      
      val si = intersect(s12, s23)
      assert(contains(si, 2), "Contains 2")
      assert(!contains(si, 3), "Not contain 3")
    }
  }
  
  test("diff") {
    new TestSets {
      val s12 = union(s1, s2)
      val s23 = union(s2, s3)
      
      val sd = diff(s12, s23)
      assert(contains(sd, 1), "Contains 1")
      assert(!contains(sd, 2), "Does not contain 2")
    }
  }
  
  test("filter") {
    new TestSets {
      def p(i: Int) = i == 2
      val s2p = filter(s2, p)
      val s3p = filter(s3, p)
      
      assert(contains(s2p, 2), "Contains 2")
      assert(!contains(s3p, 3), "Does not contain 3")
    }
  }
  
  test("forall") {
    val s: Set = (x: Int) => -1000 <= x && x <= 1000
    def pt(i: Int) = i > -5000 
    def pf(i: Int) = i != 0
  
    assert(forall(s, pt), "All x are > -5000")
    assert(!forall(s, pf), "All x are not <> 0")
  }
  
  test("forall2") {
    val s: Set = (x: Int) => 1 <= x && x <= 4
    def pt(i: Int) = i < 5 
    def pf(i: Int) = i > 5 
    
    assert(forall(s, pt), "All x are < 5")
    assert(!forall(s, pf))
  }
  
  test("exists") {
    val s: Set = (x: Int) => -1000 <= x && x <= 1000
    def pt(i: Int) = i == 0
    def pf(i: Int) = i == -5000
  
    assert(exists(s, pt), "Find x=0")
    assert(!exists(s, pf), "No x are = -5000")
  }
  
  test("map") {
    val s: Set = (x: Int) => 1 <= x && x <= 3
    def mf(x: Int) = x * 10
  
    val sm = map(s, mf)
    assert(contains(sm, 10))
    assert(!contains(sm, 1))
  }
}
