package kse.cheatsheet

object `conditions and pattern-matching`:

  object `if-then-else`:

    object `if-then-else-expression`:

      /**
       * if-then-else is an expression that returns a value. It is not an operator that "does something"; it produces a
       * result.
       */
      val age = 18

      val status: String =
        if age >= 18 then "adult" else "minor"

      /**
       * The type of the whole expression is the common supertype of both branches. Here it is String.
       */
      val message: String = s"Status: $status"

    end `if-then-else-expression`

    object `prefer-complete-if-then-else`:

      /**
       * A standalone if (without else) returns Unit, which is not useful when you need a value.
       */
      val isWeekend = true

      /**
       * This expression returns Unit, so it is only useful for side effects.
       */
      val unitResult: Unit =
        if isWeekend then println("Sleep in")

      /**
       * Prefer a complete if-then-else when you need a value.
       */
      val plan: String =
        if isWeekend then "Sleep in"
        else "Go to work"

    end `prefer-complete-if-then-else`

  end `if-then-else`

  object `pattern-matching`:

    object `pattern-matching-basics`:

      /**
       * Pattern matching is an expression that selects the first matching case. Each case returns a value, so the whole
       * match returns a value too.
       */
      val dayNumber = 6

      val dayType: String =
        dayNumber match
          case 6 | 7             => "Weekend"
          case 1 | 2 | 3 | 4 | 5 => "Weekday"
          case _                 => "Unknown"

    end `pattern-matching-basics`

    object `pattern-matching-with-if-guard`:

      /**
       * A guard (an if clause) can refine a pattern. The guard is checked only after the pattern matches.
       */
      val temperature = 37.5

      val healthMessage: String =
        temperature match
          case t if t < 36.6  => "Low temperature"
          case t if t <= 37.5 => "Normal temperature"
          case t if t < 38.0  => "Mild fever"
          case _              => "High fever"

    end `pattern-matching-with-if-guard`

    object `list-decomposition`:

      /**
       * Lists can be decomposed with patterns like head :: tail. This lets us work with the first elements and the rest
       * of the list.
       */
      val numbers = 3 :: 2 :: 1 :: Nil // List(1, 2, 3)

      val description: String =
        numbers match
          case Nil                    => "Empty list"
          case head :: Nil            => s"Single element: $head"
          case head :: second :: rest => s"First: $head, second: $second, rest size: ${rest.size}"

      /**
       * We can also match on an exact list shape with List(a, b, c).
       */
      val exactThree: String =
        numbers match
          case List(a, b, c) => s"Three elements: $a, $b, $c"
          case _             => "Not three elements"

    end `list-decomposition`

    object `case-class-decomposition`:

      /**
       * Case classes expose their constructor fields for pattern matching.
       */
      case class Person(name: String, age: Int)

      val person = Person("Ada", 25)

      val greeting: String =
        person match
          case Person(name, _) => s"Hello, $name"

    end `case-class-decomposition`

    object `regex-pattern-matching`:

      /**
       * Regular expressions can be used in pattern matching. When the pattern matches, captured groups become values.
       */
      val userPattern = "([a-zA-Z]+):(\\d+)".r
      val input       = "alice:42"

      val parsed: String =
        input match
          case userPattern(name, id) => s"User: $name, id: $id"
          case _                     => "Input does not match the expected format"

      /**
       * Regex matching is still pattern matching, so we can combine it with guards.
       */
      val agePattern = "age=(\\d+)".r
      val payload    = "age=15"

      val ageMessage: String =
        payload match
          case agePattern(age) if age.toInt >= 18 => "Adult"
          case agePattern(_)                      => "Minor"
          case _                                  => "No age provided"

    end `regex-pattern-matching`

    object `sealed-trait-exhaustiveness`:

      /**
       * Sealed traits define a closed hierarchy of subtypes. The compiler knows all possible cases and can check
       * exhaustiveness.
       */
      sealed trait Shape
      case class Circle(radius: Double)                   extends Shape
      case class Rectangle(width: Double, height: Double) extends Shape
      case class Triangle(base: Double, height: Double)   extends Shape

      /**
       * This match is exhaustive, so it handles every possible Shape.
       */
      def area(shape: Shape): Double =
        shape match
          case Circle(radius)           => Math.PI * radius * radius
          case Rectangle(width, height) => width * height
          case Triangle(base, height)   => 0.5 * base * height

      /**
       * If we forget a case, the compiler warns: "Match is not exhaustive". That warning is useful because it points to
       * the missing cases.
       *
       * It is better to cover all cases explicitly than to hide missing logic behind a wildcard case.
       */
      // def areaUnsafe(shape: Shape): Double =
      //   shape match
      //     case Circle(radius) => Math.PI * radius * radius
      // The compiler would warn that Rectangle and Triangle are not handled.

    end `sealed-trait-exhaustiveness`

  end `pattern-matching`

end `conditions and pattern-matching`
