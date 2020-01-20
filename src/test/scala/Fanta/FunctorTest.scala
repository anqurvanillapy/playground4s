package Fanta

import org.scalatest.FunSuite

// My first Scala snippet, just dumb as fuck... esketit!!
class FunctorTest extends FunSuite {
  class Dummy[+T](m: T) extends Functor[Dummy] {
    private val n: T = m

    override def fmap[A, B](f: A => B)(a: Dummy[A]): Dummy[B] = {
      new Dummy[B](f(a.n))
    }

    def data: T = n
  }

  test("Functor.fmap") {
    val dummy = new Dummy[Int](42)
    assert(
      dummy
        .fmap((n: Int) => n.toString)(dummy)
        .data == new Dummy[String]("42").data
    )
  }

  test("Functor.<*") {
    val dummy = new Dummy[Int](69)
    assert(
      dummy.<*(42)(new Dummy[String]("42")).data == new Dummy[Int](42).data
    )
  }
}
