# Unit 2

Your task is to implement Boolean algebra:
* Implement `negation`, `conjunction`, `disjunction`, `implication`, and `equivalence`.
* Do not use the built-in `scala.Boolean`.
* Do not use built-in logical operators to implement your Boolean operators.
* Implement `fold` recursively; do not use the `List`/`Seq` API (for example, `list.fold(...)`).
* Provide implementations for `NegationSpecification`, `ConjunctionSpecification`,
  `DisjunctionSpecification`, `ImplicationSpecification`, `AxiomsSpecification`, and `FoldSpecification`.
* The following properties are required: `False ∧ value` ignores the second argument, `True ∨ value` ignores the
  second argument, and `False → value` ignores the second argument.
* `EquivalenceSpecification` is an optional challenge.
* Implement the required tests.
* All tests must pass.
* The GitHub build must be green.

Implementing the optional challenge is rewarded with an additional **1 point** and **1 Wolkov point**.

One Wolkov point will be awarded to the first person who suggests an approach for implementing these tests.
```scala 3
property("False ∧ value should ignore the second argument")

property("True ∨ value should ignore the second argument")

property("False → value should ignore the second argument")
```

## Key notes

### Math
In mathematics, a semiring is an algebraic structure similar to a ring, but it does not require the existence of additive inverses. 
A semiring consists of a set equipped with two binary operations, typically called addition and multiplication.

Review:
* [Monoid](https://en.wikipedia.org/wiki/Monoid)
* [Semiring](https://en.wikipedia.org/wiki/Semiring)
* [Boolean algebra](https://en.wikipedia.org/wiki/Boolean_algebra)

### Union types

```scala 3
type Nat3 = Zero | One | Two
```

Review:
* [Union type](https://en.wikipedia.org/wiki/Union_type)
* [Scala 3 Reference. Union Types](https://docs.scala-lang.org/scala3/reference/new-types/union-types.html)
* [Scala 3 Book. Union Types](https://docs.scala-lang.org/scala3/book/types-union.html)
* [Baeldung. Type Disjunction (Union Types) in Scala](https://www.baeldung.com/scala/type-disjunction)
* [Understanding Union Types in Scala 3](https://www.turingtaco.com/understanding-union-types-in-scala-3/)

### Explicit Nulls
Explicit nulls is an opt-in feature that modifies the Scala type system,
making reference types (anything that extends AnyRef) non-nullable.

Review:
* [Scala 3 Reference. Explicit Nulls](https://docs.scala-lang.org/scala3/reference/experimental/explicit-nulls.html)

### Pattern matching

```scala 3
def addition(left: Nat3, right: Nat3): Nat3 =
  (left, right) match
    case (Zero, value)           => value
    case (value, Zero)           => value
    case (One, One)              => Two
    case (One, Two) | (Two, One) => Zero
    case (Two, Two)              => One
```

Review:
* [Pattern matching](https://en.wikipedia.org/wiki/Pattern_matching)
* [Scala 3 Book. Pattern Matching](https://docs.scala-lang.org/tour/pattern-matching.html)
* [Baeldung. Pattern Matching in Scala](https://www.baeldung.com/scala/pattern-matching)
* [Rock the JVM. Scala 3: Match Types Quickly Explained](https://rockthejvm.com/articles/scala-3-match-types)
* [Lean 4 Reference. Pattern Matching](https://lean-lang.org/doc/reference/latest/Terms/Pattern-Matching/)

### Call-by-value and call-by-name parameters

Call-by-name parameters are used when an argument's evaluation is not always required.

```scala 3
def multiplication(left: Nat3, right: => Nat3): Nat3
```

Review:
* [Scala 3 Book. By-name parameters](https://docs.scala-lang.org/tour/by-name-parameters.html)
* [Baeldung. By-Value and By-Name Parameters in Scala](https://www.baeldung.com/scala/parameters-by-value-by-name)
* [Rock the JVM. 3 Fun Call-by-Name Tricks in Scala](https://rockthejvm.com/articles/3-call-by-name-tricks-in-scala)


### The @targetName annotation
```scala 3
@targetName("addition")
```
Review:
* [Scala 3 Reference. The @targetName annotation](https://docs.scala-lang.org/scala3/reference/other-new-features/targetName.html)
* [Baeldung. @targetName Annotation in Scala 3](https://www.baeldung.com/scala/targetname-annotation)

### Operators
Scala 3 is fully object-oriented: everything in Scala is an object. Therefore, there are no built-in primitive operators;
each operator is a method on a class.

```scala 3
def +(that: Nat3): Nat3
```
Review:
* [Scala 3 Reference. Rules for Operators](https://docs.scala-lang.org/scala3/reference/changed-features/operators.html)
* [Scala 3 Book. Operators](https://docs.scala-lang.org/tour/operators.html)
* [Baeldung. Introduction to Scala Operators](https://www.baeldung.com/scala/operators-intro)


### Extension methods
Extension methods provide extra functionality without adding inheritance, especially when it is not possible to extend
classes.
```scala 3
extension (value: Nat3)

    @targetName("addition")
    infix def +(that: Nat3): Nat3 = functions.addition(value, that)
    
    @targetName("multiplication")
    infix def *(that: => Nat3): Nat3 = functions.multiplication(value, that)
```

Review:
* [Scala 3 Reference. Extension Methods](https://docs.scala-lang.org/scala3/reference/contextual/extension-methods.html)
* [Scala 3 Book. Extension Methods](https://docs.scala-lang.org/scala3/book/ca-extension-methods.html)
* [Extension Methods in Scala 3](https://www.baeldung.com/scala/extension-methods)
* [. Scala 3: Extension Methods Quickly Explained](https://rockthejvm.com/articles/scala-3-extension-methods)


### Folding

Folds allow you to process data recursively in sequential data structures.

```scala 3
  def fold(operation: (Nat3, Nat3) => Nat3, unit: Nat3)(list: List[Nat3]): Nat3 =
    @tailrec
    def foldReq(list: List[Nat3], acc: Nat3): Nat3 =
      list match
        case Nil          => acc
        case head :: tail => foldReq(tail, operation(head, acc))

    foldReq(list, unit)
```

Review:
* [Fold (higher-order function)](https://en.wikipedia.org/wiki/Fold_(higher-order_function))
* [Catamorphism](https://en.wikipedia.org/wiki/Catamorphism)
* [Understanding Scala folds](https://avapl.github.io/posts/understanding-scala-folds/)
* [Writing Tail-Recursive Algorithms in Scala (and the tailrec annotation)](https://alvinalexander.com/scala/fp-book/tail-recursive-algorithms/)

### ScalaCheck properties

A parameterless property when all arguments are known:
```scala 3
  property("One + One is Two") = propBoolean:
    (One + One) == Two
```

A property with generated arguments:
```scala 3
  property("value + Zero is value") = forAll: (value: Nat3) =>
    (value + Zero) == value
```

`forAll` implicitly takes an `Arbitrary` instance for `Nat3` and uses it to generate values.

Compare with `Unit 1`:
```scala 3
forAll(genSmallNonNegativeNumber, genSmallNonNegativeNumber)
```

Review:
* [User Guide. Properties](https://github.com/typelevel/scalacheck/blob/main/doc/UserGuide.md#properties)
* [Stateless Tests: Properties](https://www.baeldung.com/scala/scalacheck#stateless-tests-properties)
* [Scala Exercises. ScalaCheck Properties](https://www.scala-exercises.org/scalacheck/properties)
* [Conditional Properties](https://github.com/typelevel/scalacheck/blob/main/doc/UserGuide.md#conditional-properties)
  (required for the optional challenge)


### ScalaCheck generators
`Gen` is used as a schema to generate values. `Gen` does not generate values immediately, but provides a pattern that
is used for generation.

```scala 3
lazy val genNat3: Gen[Nat3] = Gen.oneOf(Zero, One, Two)
```

Review:
* [User Guide. Generators](https://github.com/typelevel/scalacheck/blob/main/doc/UserGuide.md#generators)
* [Scala Exercises. ScalaCheck Generators](https://www.scala-exercises.org/scalacheck/generators)
* [Introduction to ScalaCheck. Generators](https://www.baeldung.com/scala/scalacheck#generators)

### ScalaCheck `Arbitrary`
`Arbitrary` encapsulates generation logic used in tests via Scala's implicit (`given` and `using`) mechanism.

```scala 3
given Arbitrary[Nat3] = Arbitrary(genNat3)
```

Review:
* [User Guide. Arbitrary](https://github.com/typelevel/scalacheck/blob/main/doc/UserGuide.md#the-arbitrary-generator)
* [Scala Exercises. ScalaCheck Arbitrary](https://www.scala-exercises.org/scalacheck/arbitrary)


### The magic of `given` and `using` (formerly `implicit`s)
Generally, a `given`/`using` pair is used to create type classes for ad-hoc polymorphism. This approach can also be
used for implicit substitution of variables that depend on their type.

```scala 3
given Arbitrary[Nat3] = Arbitrary(genNat3)
```

```scala 3
  /** Converts a function into a universally quantified property */
  def forAll[A1, P](
      f: A1 => P
  )(implicit // use `using` in Scala 3
      p: P => Prop,
      a1: Arbitrary[A1],
      s1: Shrink[A1],
      pp1: A1 => Pretty
  ): Prop = forAllShrink(arbitrary[A1], s1.shrink)(f andThen p)
```

Given instances exist in a separate namespace.

Wildcard import:
```scala 3
import kse.unit2.topic.generators.*
```
imports everything except `given` instances.

Given-only import:
```scala 3
import kse.unit2.topic.generators.given
```
imports only `given` instances.


Review:
* [Given Instances](https://docs.scala-lang.org/scala3/reference/contextual/givens.html)
* [Using Clauses](https://docs.scala-lang.org/scala3/reference/contextual/using-clauses.html)
* [Scala 3: Given and Using Clauses](https://rockthejvm.com/articles/scala-3-given-and-using-clauses)
* [Implicit Parameters in Scala](https://www.baeldung.com/scala/implicit-parameters)
