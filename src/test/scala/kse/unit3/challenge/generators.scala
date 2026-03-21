package kse.unit3.challenge

import kse.unit3.challenge.expressions.*
import org.scalacheck.*
import org.scalacheck.Gen.lzy

object generators:

  val genBoolean: Gen[Boolean] = Gen.oneOf(True, False)

  val genVariableName: Gen[String] = Gen.alphaStr.suchThat(_.nonEmpty)

  val genVariable: Gen[Variable] =
    for name <- genVariableName
    yield Variable(name)

  val genNegation: Gen[Negation] =
    lzy(genExpression.map(Negation(_)))

  val genConjunction: Gen[Conjunction] =
    lzy(for l <- genExpression; r <- genExpression yield Conjunction(l, r))

  val genDisjunction: Gen[Disjunction] =
    lzy(for l <- genExpression; r <- genExpression yield Disjunction(l, r))

  val genImplication: Gen[Implication] =
    lzy(for l <- genExpression; r <- genExpression yield Implication(l, r))

  val genEquivalence: Gen[Equivalence] =
    lzy(for l <- genExpression; r <- genExpression yield Equivalence(l, r))

  lazy val genExpression: Gen[Expression] =
    Gen.frequency(
      3 -> lzy(genBoolean),
      2 -> lzy(genVariable),
      1 -> lzy(genNegation),
      1 -> lzy(genConjunction),
      1 -> lzy(genDisjunction),
      1 -> lzy(genImplication),
      1 -> lzy(genEquivalence),
    )

  given Arbitrary[Boolean]    = Arbitrary(genBoolean)
  given Arbitrary[Variable]   = Arbitrary(genVariable)
  given Arbitrary[Expression] = Arbitrary(genExpression)
