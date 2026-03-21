package kse.unit3.challenge

import kse.unit3.challenge.expressions.*
import kse.unit3.challenge.generators.given
import org.scalacheck.*
import org.scalacheck.Prop.{forAll, propBoolean}

object BooleansSpecification extends Properties("Expressions"):

  include(BooleanEvaluationSpecification)
  include(VariableEvaluationSpecification)
  include(NegationEvaluationSpecification)
  include(ConjunctionEvaluationSpecification)
  include(DisjunctionEvaluationSpecification)
  include(ImplicationEvaluationSpecification)
  include(EquivalenceEvaluationSpecification)
  include(BooleanSubstitutionSpecification)
  include(VariableSubstitutionSpecification)
  include(ExpressionSubstitutionSpecification)

end BooleansSpecification

object BooleanEvaluationSpecification extends Properties("Boolean Evaluation"):

  property("boolean value should be evaluated to itself") = forAll: (boolean: Boolean) =>
    boolean.evaluate == boolean

end BooleanEvaluationSpecification

object VariableEvaluationSpecification extends Properties("Variable Evaluation"):

  property("variable should be evaluated to itself") = forAll: (v: Variable) =>
    v.evaluate == v

end VariableEvaluationSpecification

object NegationEvaluationSpecification extends Properties("Negation Evaluation"):

  property("!True should be evaluated to False") = (!True).evaluate == False

  property("!False should be evaluated to True") = (!False).evaluate == True

  property("!variable should be evaluated to !variable") = forAll: (v: Variable) =>
    (!v).evaluate == !v

  property("!expression should be correctly evaluated") = forAll: (expression: Expression) =>
    (!expression).evaluate == (!expression.evaluate).evaluate

end NegationEvaluationSpecification

object ConjunctionEvaluationSpecification extends Properties("Conjunction Evaluation"):

  property("True ∧ expression should be evaluated to expression evaluation") = forAll: (e: Expression) =>
    (True ∧ e).evaluate == e.evaluate

  property("expression ∧ True should be evaluated to expression evaluation") = forAll: (e: Expression) =>
    (e ∧ True).evaluate == e.evaluate

  property("False ∧ expression should be evaluated to False") = forAll: (e: Expression) =>
    (False ∧ e).evaluate == False

  property("expression ∧ False should be evaluated to False") = forAll: (e: Expression) =>
    (e ∧ False).evaluate == False

  property("left ∧ right should be correctly evaluated") = forAll: (l: Expression, r: Expression) =>
    (l ∧ r).evaluate == (l.evaluate ∧ r.evaluate).evaluate

end ConjunctionEvaluationSpecification

object DisjunctionEvaluationSpecification extends Properties("Disjunction Evaluation"):

  property("True ∨ expression should be evaluated to True") = forAll: (e: Expression) =>
    (True ∨ e).evaluate == True

  property("expression ∨ True should be evaluated to True") = forAll: (e: Expression) =>
    (e ∨ True).evaluate == True

  property("False ∨ expression should be evaluated to expression evaluation") = forAll: (e: Expression) =>
    (False ∨ e).evaluate == e.evaluate

  property("expression ∨ False should be evaluated to expression evaluation") = forAll: (e: Expression) =>
    (e ∨ False).evaluate == e.evaluate

  property("left ∨ right should be correctly evaluated") = forAll: (l: Expression, r: Expression) =>
    (l ∨ r).evaluate == (l.evaluate ∨ r.evaluate).evaluate

end DisjunctionEvaluationSpecification

object ImplicationEvaluationSpecification extends Properties("Implication Evaluation"):

  property("True → expression should be evaluated to expression evaluation") = forAll: (e: Expression) =>
    (True → e).evaluate == e.evaluate

  property("False → expression should be evaluated to True") = forAll: (e: Expression) =>
    (False → e).evaluate == True

  property("left → right should be correctly evaluated") = forAll: (l: Expression, r: Expression) =>
    (l → r).evaluate == (l.evaluate → r.evaluate).evaluate

end ImplicationEvaluationSpecification

object EquivalenceEvaluationSpecification extends Properties("Equivalence Evaluation"):

  property("Reflexivity") = forAll: (e: Expression) =>
    (e ↔ e).evaluate == True

  property("Symmetry") = forAll: (l: Expression, r: Expression) =>
    (l ↔ r).evaluate == (r ↔ l).evaluate

  property("Transitivity") = forAll: (a: Expression, b: Expression, c: Expression) =>
    ((a ↔ b).evaluate == True && (b ↔ c).evaluate == True) ==> {
      (a ↔ c).evaluate == True
    }

  property("left ↔ right should be correctly evaluated") = forAll: (l: Expression, r: Expression) =>
    (l ↔ r).evaluate == (l.evaluate ↔ r.evaluate).evaluate

end EquivalenceEvaluationSpecification

object BooleanSubstitutionSpecification extends Properties("Boolean Substitution"):

  property("substitution into boolean should make no changes") = forAll: (b: Boolean, v: Variable, e: Expression) =>
    b.substitute(v, e) == b

end BooleanSubstitutionSpecification

object VariableSubstitutionSpecification extends Properties("Variable Substitution"):

  property("substitution into different variable should make no changes") = forAll:
    (v1: Variable, v2: Variable, substitution: Expression) =>
      v1 != v2 ==> {
        v1.substitute(v2, substitution) == v1
      }

  property("substitution into the same variable should return the given expression") = forAll:
    (v: Variable, e: Expression) => v.substitute(v, e) == e

end VariableSubstitutionSpecification

object ExpressionSubstitutionSpecification extends Properties("Expression Substitution"):

  property("substitution into !expression should be equal to !(substitution into expression)") = forAll:
    (expr: Expression, v: Variable, s: Expression) => (!expr).substitute(v, s) == !expr.substitute(v, s)

  property("substitution into left ∧ right should be equal to substitution into left ∧ substitution into right") =
    forAll: (l: Expression, r: Expression, v: Variable, s: Expression) =>
      (l ∧ r).substitute(v, s) == (l.substitute(v, s) ∧ r.substitute(v, s))

  property("substitution into left ∨ right should be equal to substitution into left ∨ substitution into right") =
    forAll: (l: Expression, r: Expression, v: Variable, s: Expression) =>
      (l ∨ r).substitute(v, s) == (l.substitute(v, s) ∨ r.substitute(v, s))

  property("substitution into left → right should be equal to substitution into left → substitution into right") =
    forAll: (l: Expression, r: Expression, v: Variable, s: Expression) =>
      (l → r).substitute(v, s) == (l.substitute(v, s) → r.substitute(v, s))

  property("substitution into left ↔ right should be equal to substitution into left ↔ substitution into right") =
    forAll: (l: Expression, r: Expression, v: Variable, s: Expression) =>
      (l ↔ r).substitute(v, s) == (l.substitute(v, s) ↔ r.substitute(v, s))

end ExpressionSubstitutionSpecification
