package kse.cheatsheet

object classes:

  /**
   * A regular class in Scala
   *
   * All members of a class are immutable. All members of a class are private unless they are prefixed with `val`.
   */
  class MyClass(privateMember: String, val publicMember: String):
    /**
     * This part of the class is part of the constructor and will be evaluated, i.e., `"Initializing MyClass..."` will
     * be printed.
     */
    println("Initializing MyClass...")

    /**
     * This part of the class is also part of the constructor and will be evaluated as well.
     */
    val anotherPublicMember          = 42
    private val anotherPrivateMember = publicMember

    def publicMethod(): Unit =
      println(s"Calling public method. The value of a public member is $publicMember.")
      revealASecret()

    private def revealASecret(): Unit =
      println(s"The value of a private member is $privateMember")

  /**
   * A case class, or data class, in Scala
   *
   * All members of a class are immutable. All members of a case class are public; no need to use `val`.
   */
  case class MyCaseClass(publicValue: String, anotherPublicValue: String)

  case class AnotherCaseClass(first: String, second: String)

  /**
   * We do not use the `new` keyword to create an instance of a class.
   */
  val myClassInstance = MyClass("Keep it private. Forever", "Happy to share")

  /**
   * We do not use the `new` keyword to create an instance of a case class.
   */
  val myCaseClassInstance = MyCaseClass("It's a public value", "As well as this")

  /**
   * We can change the order of arguments by using named arguments.
   */
  val yetAnotherCaseClassInstance = AnotherCaseClass(second = "Second value", first = "First value")

end classes
