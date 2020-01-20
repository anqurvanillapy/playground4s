package Fanta

import org.scalatest.FunSuite

import Prelude._

class PreludeTest extends FunSuite {
  test("Prelude.id") {
    assert(id(42) == 42)
  }

  test("Prelude.const") {
    assert(const(42)(id _) == 42)
  }
}
