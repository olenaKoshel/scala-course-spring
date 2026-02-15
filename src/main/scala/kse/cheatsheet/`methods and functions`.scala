package kse.cheatsheet

object `methods and functions`:

  /**
   * Methods and functions can't be defined in thin air; they must be members of a class or an object.
   */
  def `I belong to the methods and functions object`: Unit =
    println("Im in the context of an object")

  object methods:

    /**
     * Methods can have arguments (`name`) and an explicit return type (`String`).
     *
     * We don't use curly braces or the `return` keyword.
     */
    def greeterMethod(name: String): String =
      s"Hello, $name!"

    def strictGreeterMethod(name: String, age: Int): String =
      /**
       * This message will be printed regardless.
       */
      println("This is ugly log, don't use `println`s as a logger!")

      /**
       * We can use conditions as operators...
       */
      if age < 14 then println("Call the parents!")

      /**
       * ... but we prefer to use them as expressions. The result of the method is the result of the last evaluated
       * expression.
       */
      if age < 14 then "You are to young to communicate!"
      else s"Hello, $name!"

    /**
     * This is how we call a method.
     */
    val greeted: String = strictGreeterMethod("John Doe", 42)

  end methods

  /**
   * Functions are values. Done.
   *
   * Functions are first-class citizens (values).
   */
  object functions:

    /**
     * We can consider regular values as zero-argument functions: nothing in, value out.
     */
    val contextlessGreeterValue = "Hello!"

    /**
     * This is a function with the type `String => String`. It means that it accepts a `String` argument and returns a
     * `String` result.
     */
    val greeterFunction: String => String =
      (name: String) => s"Hello, $name!"

    /**
     * This is a function with two arguments.
     */
    val strictGreeterFunction: (String, Int) => String =
      (name: String, age: Int) =>

        /**
         * This message will be printed regardless.
         */
        println("This is ugly log, don't use `println`s as a logger!")

        /**
         * We can use conditions as operators...
         */
        if age < 14 then println("Call the parents!")

        /**
         * ... but we prefer to use them as expressions. The result of the method is the result of the last evaluated
         * expression.
         */
        if age < 14 then "You are to young to communicate!"
        else s"Hello, $name!"

    /**
     * That's how we can call a function.
     */
    val greeted: String = strictGreeterFunction("John Doe", 42)

  end functions

  /**
   * Higher-order functions are functions that
   *   - can accept functions as arguments
   *   - can return functions as a result
   */
  object `higher order methods and functions`:

    val agePolicy: Int => Boolean =
      /**
       * The compiler is smart enough to understand that age is an Int, so instead of
       * ```
       * (age: Int) => age > 13
       * ```
       * we can use
       * ```
       * age => age > 13
       * ```
       *
       * By the way, `age > 13` is already a Boolean value.
       */
      age => age > 13

    /**
     * This method accepts a function as an argument.
     */
    def policyRespectfulMethod(policy: Int => Boolean, name: String, age: Int) =
      if policy(age) then s"Hello, $name!"
      else "You are young policy violator!"

    val greetedFollowingThePolicy        = policyRespectfulMethod(agePolicy, "John Doe", 42)
    val greetedFollowingTheInlinedPolicy = policyRespectfulMethod(age => age > 13, "John Doe", 42)

    /**
     * This method has two groups of arguments. If we initialize only the first argument group, this method returns a
     * function that accepts the next two arguments.
     */
    def thePerfectPolicyRespectfulMethod(policy: Int => Boolean)(name: String, age: Int) =
      if policy(age) then s"Hello, $name!"
      else "You are young policy violator!"

    val iKnowThePolicy: (String, Int) => String = thePerfectPolicyRespectfulMethod(age => age > 13)

    val greeted: String = iKnowThePolicy("John Doe", 42)

    /**
     * Each method can be considered as a function. Not vice versa!
     */
    val policyRespectfulFunction: (Int => Boolean, String, Int) => String = policyRespectfulMethod

    /**
     * That's why we can do a trick with `thePerfectPolicyRespectfulMethod`.
     */
    val thePerfectPolicyRespectfulFunction: (Int => Boolean) => (String, Int) => String =
      thePerfectPolicyRespectfulMethod

    /**
     * Here we have a kind of partially initialized function. When we provide a policy to
     * `(Int => Boolean) => (String, Int) => String`, we initialize the first component, and `(String, Int) => String`
     * is what's left. And it's a function!
     */
    val andIKnowThePolicy: (String, Int) => String = thePerfectPolicyRespectfulFunction(age => age > 13)

  end `higher order methods and functions`
