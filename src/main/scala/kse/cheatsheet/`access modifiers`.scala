package kse.cheatsheet

object `access modifiers`:
  /**
   * Importing `MyClass` into this namespace to get rid of the `classes.MyClass` prefix.
   */
  import classes.MyClass

  /**
   * All objects, values, and methods are public by default and can be accessed from anywhere. That's why we do not use
   * the `public` modifier at all.
   */
  object `public object`:

    val publicValue: String          = "I'm public"
    private val privateValue: String = "I'm private"

    def publicMethod(value: String): Unit =
      println(s"Calling public methods with $value value")

    private def privateMethod(value: String): Unit =
      println(s"Calling private methods with $value value")

  end `public object`

  /**
   * We can call `publicMethod` and `publicValue` since they are public by default.
   */
  `public object`.publicMethod(`public object`.publicValue)

  /**
   * We can't call `privateMethod` or `privateValue`; it leads to a compilation error.
   */
  // `public object`.privateMethod(`public object`.privateValue) // Compilation error

  /**
   * We do not use the `new` keyword to create an instance of a class.
   */
  val publicClassInstance: MyClass = MyClass("Keep it private. Forever", "Happy to share")

  val iLikePublicInfo: String = publicClassInstance.publicMember // Works
  // val iLikeSecrets: String = publicClassInstance.privateMember // Compilation error

  publicClassInstance.publicMethod() // Works
  // publicClassInstance.revealASecret() // Compilation error

end `access modifiers`
