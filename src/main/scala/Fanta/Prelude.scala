package Fanta

object Prelude {
  def id[A](a: A): A = a

  def const[A, B](a: A)(b: B): A = a
}
