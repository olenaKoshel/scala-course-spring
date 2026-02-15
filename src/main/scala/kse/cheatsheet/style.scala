package kse.cheatsheet

object style:

  object naming:

    /**
     * We do not use C-style naming. There is no reason to save on naming.
     */
    val s = 42

    /**
     * Explicitness and readability must be in the first place.
     */
    val theAnswerToLifeTheUniverseAndEverything = 42

    /**
     * We use only camelCase naming conventions. We prefer this notation over names like `it is true or false`.
     */
    val theOnlyAcceptableNaming: Boolean = true

    /**
     * Keep backtick-based naming for learning materials, not for your production or homework code.
     */
    val `for learning purposes only`: String =
      "My name highlights that this is just a fancy syntax"

    /**
     * We do not use snake_case naming. It is forbidden in this course. Fortunately, kebab-case naming such as
     * `it-is-true-or-false` is not supported by Scala syntax anyway.
     */
    val not_acceptable_val_naming: String = "Boo, such an ugly value naming"

    /**
     * All of the above applies to naming for methods, objects, classes, etc.
     */
    def not_acceptable_method_naming: String = "Boo, such an ugly method naming"

  /**
   * Optional syntax
   */
  end naming

  /**
   * We prefer the Python-like Scala 3 code style, using indentation instead of curly braces.
   */
  object scala3StyleObject:
    /**
     * You should use indentation (tabs/spaces) to control nesting of structures.
     *
     * This code simply prints `I like Scala 3 style`. We do not use `print` or `println` for testing - it is much
     * better to use explicit tests.
     *
     * If, for some reason, you decide to use printing for local testing, do not forget to clean up the code before
     * committing it.
     */
    println("I like Scala 3 style")

    /**
     * Curly braces are not preferred.
     */
    def scala3StyleMethod: String =
      println("""I'm printing something without curly braces and returning "Hello world"""")
      "Hello World"

    /**
     * Indentation matters. Explicit types can help us avoid errors. The next method does not compile:
     * ```
     *  def indentsMattersMethod: String =
     *    println("""I'm printing something without curly braces and but not returning "Hello world"""")
     * ```
     */
    def indentsMattersMethod: Unit =
      println("""I'm printing something without curly braces and but not returning "Hello world"""")

  /**
   * Optional syntax
   */
  end scala3StyleObject

  /**
   * …over the Java-style syntax with curly braces.
   *
   * Sometimes it is not possible to use only Scala 3 indentation-based syntax; such cases will be explicitly explained.
   */
  object javaStyleObject:
    println("Sometimes I have to use ugly curly braces")

    /**
     * Curly braces are not preferred.
     */
    def scala3StyleMethod: String =
      println("""I'm printing something with curly braces and returning "Hello world"""")

      /**
       * You should never use the `return` keyword; `return` is explicitly forbidden in this course.
       */
      return "Hello World"
