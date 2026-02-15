package kse.cheatsheet

/**
 * `objects` is a singleton type, but we will use `object` s extensively as namespaces/modules to logically organize
 * code.
 *
 * Sometimes we will use syntax that explicitly shows the end of an object, such as `end objects`. This syntax improves
 * readability but is optional.
 *
 * `extends App` means that this object is executable - we can run it. Usually, only one object in a project should be
 * executable. If we want to test code, we will use explicit tests, not executable objects.
 *
 * Executable objects are not accepted in homework submissions. If, for some reason, you decide to use them locally for
 * testing, do not forget to clean up the code before committing it.
 *
 * We keep the `objects` object executable here for simplicity, to give you a chance to play a bit with this cheat
 * sheet.
 */
object objects extends App:

  /**
   * All code between `object objects` and `end objects` will be evaluated. Whenever you use this object or run it as an
   * executable, `Hello, world!` will be printed.
   */
  println("Hello, world!")

  object utils:

    def statelessGreeterMethod(name: String): String =
      /**
       * This is an example of string interpolation. Instead of using
       * ```
       * "Hello, " + name
       * ```
       * we can inline a variable (value) into the string directly.
       */
      s"Hello, $name"

  /**
   * Optional syntax
   */
  end utils

  /**
   * Now we can call the stateless method. Here we use a more complex string interpolation: since we need to call a
   * method, the code is wrapped in curly braces.
   */
  println(s"The result of the execution of `statelessGreeterMethod`: ${utils.statelessGreeterMethod("John Doe")}")

/**
 * Optional syntax
 */
end objects
