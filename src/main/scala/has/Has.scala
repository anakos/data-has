package has

import cats.data._
import cats.effect._

/**
 * Defines behaviour for a simple extensible product.
*/
trait Has[A, E] { outer =>
  /** */
  def get: E => A
  /** */
  def view: ReaderT[IO, E, A] = ReaderT { e => IO { get(e) }}
  /** */
  def using[B](f: A => IO[B]): ReaderT[IO, E, B] =
    ReaderT(f.compose(get))
  /** */
  def andThenF[B](f: A => ReaderT[IO, E, B]): ReaderT[IO, E, B] =
    view.flatMap(f)
  /** */
  def compose[B](next: Has[B, A]): Has[B, E] =
    new Has[B, E] {
      override val get: E => B = next.get.compose(outer.get)
    }
}
object Has {
  def mk[A, E](_get: E => A): Has[A, E] =
    new Has[A, E] { override val get: E => A = _get }

  implicit def id[E]: Has[E, E] =
    Has.mk(identity[E])

  implicit def tuple2_1[A, B]: Has[A, (A, B)] =
    Has.mk(_._1)
  implicit def tuple2_2[A, B]: Has[B, (A, B)] = Has.mk(_._2)

  implicit def tuple3_1[A, B, C]: Has[A, (A, B, C)] = Has.mk(_._1)
  implicit def tuple3_2[A, B, C]: Has[B, (A, B, C)] = Has.mk(_._2)
  implicit def tuple3_3[A, B, C]: Has[C, (A, B, C)] = Has.mk(_._3)

  implicit def tuple4_1[A, B, C, D]: Has[A, (A, B, C, D)] = Has.mk(_._1)
  implicit def tuple4_2[A, B, C, D]: Has[B, (A, B, C, D)] = Has.mk(_._2)
  implicit def tuple4_3[A, B, C, D]: Has[C, (A, B, C, D)] = Has.mk(_._3)
  implicit def tuple4_4[A, B, C, D]: Has[D, (A, B, C, D)] = Has.mk(_._4)

  implicit def tuple5_1[A, B, C, D, E]: Has[A, (A, B, C, D, E)] = Has.mk(_._1)
  implicit def tuple5_2[A, B, C, D, E]: Has[B, (A, B, C, D, E)] = Has.mk(_._2)
  implicit def tuple5_3[A, B, C, D, E]: Has[C, (A, B, C, D, E)] = Has.mk(_._3)
  implicit def tuple5_4[A, B, C, D, E]: Has[D, (A, B, C, D, E)] = Has.mk(_._4)
  implicit def tuple5_5[A, B, C, D, E]: Has[E, (A, B, C, D, E)] = Has.mk(_._5)

  implicit def tuple6_1[A, B, C, D, E, F]: Has[A, (A, B, C, D, E, F)] = Has.mk(_._1)
  implicit def tuple6_2[A, B, C, D, E, F]: Has[B, (A, B, C, D, E, F)] = Has.mk(_._2)
  implicit def tuple6_3[A, B, C, D, E, F]: Has[C, (A, B, C, D, E, F)] = Has.mk(_._3)
  implicit def tuple6_4[A, B, C, D, E, F]: Has[D, (A, B, C, D, E, F)] = Has.mk(_._4)
  implicit def tuple6_5[A, B, C, D, E, F]: Has[E, (A, B, C, D, E, F)] = Has.mk(_._5)
  implicit def tuple6_6[A, B, C, D, E, F]: Has[F, (A, B, C, D, E, F)] = Has.mk(_._6)

  implicit def tuple7_1[A, B, C, D, E, F, G]: Has[A, (A, B, C, D, E, F, G)] = Has.mk(_._1)
  implicit def tuple7_2[A, B, C, D, E, F, G]: Has[B, (A, B, C, D, E, F, G)] = Has.mk(_._2)
  implicit def tuple7_3[A, B, C, D, E, F, G]: Has[C, (A, B, C, D, E, F, G)] = Has.mk(_._3)
  implicit def tuple7_4[A, B, C, D, E, F, G]: Has[D, (A, B, C, D, E, F, G)] = Has.mk(_._4)
  implicit def tuple7_5[A, B, C, D, E, F, G]: Has[E, (A, B, C, D, E, F, G)] = Has.mk(_._5)
  implicit def tuple7_6[A, B, C, D, E, F, G]: Has[F, (A, B, C, D, E, F, G)] = Has.mk(_._6)
  implicit def tuple7_7[A, B, C, D, E, F, G]: Has[G, (A, B, C, D, E, F, G)] = Has.mk(_._7)

  implicit def tuple8_1[A, B, C, D, E, F, G, H]: Has[A, (A, B, C, D, E, F, G, H)] = Has.mk(_._1)
  implicit def tuple8_2[A, B, C, D, E, F, G, H]: Has[B, (A, B, C, D, E, F, G, H)] = Has.mk(_._2)
  implicit def tuple8_3[A, B, C, D, E, F, G, H]: Has[C, (A, B, C, D, E, F, G, H)] = Has.mk(_._3)
  implicit def tuple8_4[A, B, C, D, E, F, G, H]: Has[D, (A, B, C, D, E, F, G, H)] = Has.mk(_._4)
  implicit def tuple8_5[A, B, C, D, E, F, G, H]: Has[E, (A, B, C, D, E, F, G, H)] = Has.mk(_._5)
  implicit def tuple8_6[A, B, C, D, E, F, G, H]: Has[F, (A, B, C, D, E, F, G, H)] = Has.mk(_._6)
  implicit def tuple8_7[A, B, C, D, E, F, G, H]: Has[G, (A, B, C, D, E, F, G, H)] = Has.mk(_._7)
  implicit def tuple8_8[A, B, C, D, E, F, G, H]: Has[H, (A, B, C, D, E, F, G, H)] = Has.mk(_._8)

  implicit def tuple9_1[A, B, C, D, E, F, G, H, I]: Has[A, (A, B, C, D, E, F, G, H, I)] = Has.mk(_._1)
  implicit def tuple9_2[A, B, C, D, E, F, G, H, I]: Has[B, (A, B, C, D, E, F, G, H, I)] = Has.mk(_._2)
  implicit def tuple9_3[A, B, C, D, E, F, G, H, I]: Has[C, (A, B, C, D, E, F, G, H, I)] = Has.mk(_._3)
  implicit def tuple9_4[A, B, C, D, E, F, G, H, I]: Has[D, (A, B, C, D, E, F, G, H, I)] = Has.mk(_._4)
  implicit def tuple9_5[A, B, C, D, E, F, G, H, I]: Has[E, (A, B, C, D, E, F, G, H, I)] = Has.mk(_._5)
  implicit def tuple9_6[A, B, C, D, E, F, G, H, I]: Has[F, (A, B, C, D, E, F, G, H, I)] = Has.mk(_._6)
  implicit def tuple9_7[A, B, C, D, E, F, G, H, I]: Has[G, (A, B, C, D, E, F, G, H, I)] = Has.mk(_._7)
  implicit def tuple9_8[A, B, C, D, E, F, G, H, I]: Has[H, (A, B, C, D, E, F, G, H, I)] = Has.mk(_._8)
  implicit def tuple9_9[A, B, C, D, E, F, G, H, I]: Has[I, (A, B, C, D, E, F, G, H, I)] = Has.mk(_._9)

  implicit def tuple10_1[A, B, C, D, E, F, G, H, I, J]: Has[A, (A, B, C, D, E, F, G, H, I, J)] = Has.mk(_._1)
  implicit def tuple10_2[A, B, C, D, E, F, G, H, I, J]: Has[B, (A, B, C, D, E, F, G, H, I, J)] = Has.mk(_._2)
  implicit def tuple10_3[A, B, C, D, E, F, G, H, I, J]: Has[C, (A, B, C, D, E, F, G, H, I, J)] = Has.mk(_._3)
  implicit def tuple10_4[A, B, C, D, E, F, G, H, I, J]: Has[D, (A, B, C, D, E, F, G, H, I, J)] = Has.mk(_._4)
  implicit def tuple10_5[A, B, C, D, E, F, G, H, I, J]: Has[E, (A, B, C, D, E, F, G, H, I, J)] = Has.mk(_._5)
  implicit def tuple10_6[A, B, C, D, E, F, G, H, I, J]: Has[F, (A, B, C, D, E, F, G, H, I, J)] = Has.mk(_._6)
  implicit def tuple10_7[A, B, C, D, E, F, G, H, I, J]: Has[G, (A, B, C, D, E, F, G, H, I, J)] = Has.mk(_._7)
  implicit def tuple10_8[A, B, C, D, E, F, G, H, I, J]: Has[H, (A, B, C, D, E, F, G, H, I, J)] = Has.mk(_._8)
  implicit def tuple10_9[A, B, C, D, E, F, G, H, I, J]: Has[I, (A, B, C, D, E, F, G, H, I, J)] = Has.mk(_._9)
  implicit def tuple10_10[A, B, C, D, E, F, G, H, I, J]: Has[J, (A, B, C, D, E, F, G, H, I, J)] = Has.mk(_._10)

  implicit def tuple11_1[A, B, C, D, E, F, G, H, I, J, K]: Has[A, (A, B, C, D, E, F, G, H, I, J, K)] = Has.mk(_._1)
  implicit def tuple11_2[A, B, C, D, E, F, G, H, I, J, K]: Has[B, (A, B, C, D, E, F, G, H, I, J, K)] = Has.mk(_._2)
  implicit def tuple11_3[A, B, C, D, E, F, G, H, I, J, K]: Has[C, (A, B, C, D, E, F, G, H, I, J, K)] = Has.mk(_._3)
  implicit def tuple11_4[A, B, C, D, E, F, G, H, I, J, K]: Has[D, (A, B, C, D, E, F, G, H, I, J, K)] = Has.mk(_._4)
  implicit def tuple11_5[A, B, C, D, E, F, G, H, I, J, K]: Has[E, (A, B, C, D, E, F, G, H, I, J, K)] = Has.mk(_._5)
  implicit def tuple11_6[A, B, C, D, E, F, G, H, I, J, K]: Has[F, (A, B, C, D, E, F, G, H, I, J, K)] = Has.mk(_._6)
  implicit def tuple11_7[A, B, C, D, E, F, G, H, I, J, K]: Has[G, (A, B, C, D, E, F, G, H, I, J, K)] = Has.mk(_._7)
  implicit def tuple11_8[A, B, C, D, E, F, G, H, I, J, K]: Has[H, (A, B, C, D, E, F, G, H, I, J, K)] = Has.mk(_._8)
  implicit def tuple11_9[A, B, C, D, E, F, G, H, I, J, K]: Has[I, (A, B, C, D, E, F, G, H, I, J, K)] = Has.mk(_._9)
  implicit def tuple11_10[A, B, C, D, E, F, G, H, I, J, K]: Has[J, (A, B, C, D, E, F, G, H, I, J, K)] = Has.mk(_._10)
  implicit def tuple11_11[A, B, C, D, E, F, G, H, I, J, K]: Has[K, (A, B, C, D, E, F, G, H, I, J, K)] = Has.mk(_._11)
}