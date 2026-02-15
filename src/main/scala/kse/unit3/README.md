# Unit 3

You are challenged to implement Boolean expressions with variables:
* Implement `Boolean`, `Variable`, `Negation`, `Conjunction`, `Disjunction`, `Implication`, and `Equivalence` expressions.
* Implement `evaluate` to reduce an expression to the simplest possible form.
* Implement `substitute` to replace a variable with an expression.
* Implement the required tests.
* All tests must pass.
* The GitHub build must be green.

## Substitution

Examples of how substitution is expected to work:

```scala 3
True.substitute("a", "b" → True) == True
```

```scala 3
"a".substitute("a", "b" → True) == "b" → True
```

```scala 3
(("a" ∨ False) ∧ "b").substitute("a", "b" → True) == ((("b" → True) ∨ False) ∧ "b")
```

## Abstract data types

In computer science, an abstract data type (ADT) is a mathematical model for data types, defined by its behavior (semantics)
from the point of view of a user of the data, specifically in terms of possible values, possible operations on data of this type,
and the behavior of these operations.

Review:
* [Abstract data type](https://en.wikipedia.org/wiki/Abstract_data_type)
* [Scala 3 Book. Abstract Data Type](https://docs.scala-lang.org/scala3/book/types-adts-gadts.html)

## Traits and sealed traits

```scala 3
sealed trait Expression
```

Review:
* [Scala 3 Reference. Traits](https://docs.scala-lang.org/tour/traits.html)
* [Sealed Traits vs Enums for ADTS](https://www.scalamatters.io/post/sealed-traits-vs-enums-for-adts)
* [Baeldung. Sealed Keyword in Scala](https://www.baeldung.com/scala/sealed-keyword)
* [Scala 3 Book. Classes, Traits, and Objects](https://docs.scala-lang.org/scala3/book/domain-modeling-tools.html)

## Case classes

Case classes are like regular classes with a few key differences, which we will cover.
Case classes are good for modeling immutable data.

```scala 3
case class Addition(left: Expression, right: Expression) extends Expression
```

Review:
* [Scala 3 Reference. Case classes](https://docs.scala-lang.org/tour/case-classes.html)
* [Scala 3 Book. Case classes](https://docs.scala-lang.org/scala3/book/domain-modeling-tools.html#case-classes)
* [Medium. Programming in Scala [Chapter 15] — Case Classes and Pattern Matching](https://medium.com/@t.m.h.v.eijk/programming-in-scala-chapter-15-case-classes-and-pattern-matching-36ab45e4e495)
* [Scala Exercises. Classes vs Case Classes](https://www.scala-exercises.org/scala_tutorial/classes_vs_case_classes)

## Conversions
Implicit conversions are a powerful Scala feature that allows users to supply
an argument of one type as if it were another, to avoid boilerplate.

```scala 3
given Conversion[String, Variable] with
  def apply(str: String): Variable = Variable(str)
```

The defined conversion allows any `String` to be wrapped as a `Variable`, such that

```scala 3
(True ∧ "a") → "b"
```
is a valid expression, which expands to

```scala 3
Implication(Conjunction(True, Variable("a")), Variable("b"))
```

Review:
* [Scala 3 Reference. Implicit Conversion](https://docs.scala-lang.org/scala3/reference/contextual/conversions.html)
* [Scala 3 Book. Implicit Conversion](https://docs.scala-lang.org/scala3/book/ca-implicit-conversions.html)
* [Baeldung. Implicit Conversion](https://www.baeldung.com/scala/scala-3-implicit-redesign#2-usage-in-scala-3)

## ScalaCheck

#### ScalaCheck conditional properties

```scala 3
property("substitution into a different variable should make no changes") = forAll { (v1: Variable, v2: Variable, expression: Expression) =>
  v1 != v2 ==> {
    v1.substitute(v2, expression) == v1
  }
}
```
Review:
* [Conditional Properties](https://github.com/typelevel/scalacheck/blob/main/doc/UserGuide.md#conditional-properties)
