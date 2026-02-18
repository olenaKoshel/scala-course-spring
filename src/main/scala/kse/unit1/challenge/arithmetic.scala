package kse.unit1.challenge

import scala.annotation.tailrec

object arithmetic:

  type Number = Long

  val Z: Number => Number = (x: Number) => 0

  val S: Number => Number = (x: Number) => x + 1

  /**
   * Optional task: make `addition` tail-recursive.
   */
  val addition: (Number, Number) => Number =
    (m, n) =>
      require(n >= 0 && m >= 0, "should be positive or 0")
      (m, n) match
        case (m, 0) => m
        case (m, n) => S(addition(m, n-1))

  /**
   * Optional task: make `multiplication` tail-recursive.
   */
  val multiplication: (Number, Number) => Number =
    (m, n) =>
      require(n >= 0 && m >= 0, "should be positive or 0")
      (m,n) match
        case (m, 0) => 0
        case (m,n) => addition(multiplication(m,n-1), m)

  /**
   * Optional task: make `power` tail-recursive.
   */
  val power: (Number, Number) => Number =
    (m,n) =>
      require(n >= 0 && m >= 0, "should be positive or 0")
      (m,n) match
        case (m,0) => 1
        case (m,n) => multiplication(power(m,n-1),m)
