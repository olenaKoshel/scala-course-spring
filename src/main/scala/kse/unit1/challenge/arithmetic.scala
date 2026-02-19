package kse.unit1.challenge

import scala.annotation.tailrec

object arithmetic:

  type Number = Long

  val Z: Number => Number = (x: Number) => 0

  val S: Number => Number = (x: Number) => x + 1

  val addition: (Number, Number) => Number =
    (m, n) =>
      require(n >= 0 && m >= 0, "should be positive or 0")

      @tailrec
      def additionRec(acc: Number, n: Number): Number =
        n match
          case 0 => acc
          case _ => additionRec(S(acc), n - 1L)
      additionRec(m, n)

  val multiplication: (Number, Number) => Number =
    (m, n) =>
      require(n >= 0 && m >= 0, "should be positive or 0")

      @tailrec
      def multRec(acc: Number, n: Number): Number =
        n match
          case 0 => 0
          case 1 => acc
          case _ => multRec(addition(acc, m), n - 1L)

      multRec(m, n)

  val power: (Number, Number) => Number =
    (b, p) =>
      require(p >= 0 && b >= 0, "should be positive or 0")

      @tailrec
      def powRec(acc: Number, n: Number): Number =
        n match
          case 0L => 1L
          case 1L => acc
          case n  => powRec(multiplication(acc, b), n - 1L)

      powRec(b, p)
