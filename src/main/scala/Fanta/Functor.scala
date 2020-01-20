package Fanta

import Prelude._

/**
  * The `Functor` class is used for types that can be mapped over.
  */
trait Functor[F[+_]] {
  def fmap[A, B](f: A => B)(a: F[A]): F[B]

  def <*[A, B](a: A)(b: F[B]): F[A] =
    fmap(const(a))(b)
}
