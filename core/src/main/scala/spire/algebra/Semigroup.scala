package spire.algebra

import spire.macrosk.Ops

import scala.{ specialized => spec }

/**
 * A semigroup is any set `A` with an associative operation (`op`).
 */
trait Semigroup[@spec(Int,Long,Float,Double) A] {
  def op(x:A, y:A): A
}

object Semigroup {
  @inline final def apply[A](implicit s: Semigroup[A]) = s

  @inline final def additive[A](implicit A: AdditiveSemigroup[A]) =  A.additive

  @inline final def multiplicative[A](implicit A: MultiplicativeSemigroup[A]) = A.multiplicative
}

final class SemigroupOps[A](lhs:A)(implicit ev:Semigroup[A]) {
  def |+|(rhs:A) = macro Ops.binop[A, A]
}
