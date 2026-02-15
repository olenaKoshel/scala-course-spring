package kse.cheatsheet

/**
 * Sometimes we will use backtick naming for names with whitespace or special characters.
 *
 * This syntax can be used not only for objects, but for any identifiers, including variables, methods, classes, etc.
 *
 * This approach is not widely used in industry code, but it is acceptable for learning materials.
 */
object `variables and values`:
  /**
   * This is a value. We will use the terms "value" and "variable" interchangeably, since true (mutable) variables are
   * forbidden in this course (and are generally discouraged in Scala and functional programming).
   *
   * For obvious values, we can omit explicit type annotations, but we encourage you to use explicit types at least for
   * the first 2-3 homework assignments.
   */
  val value = 3.1415

  /**
   * You should never use `var` s in this course. If you are stuck with an implementation and have no idea how to solve
   * a task, you are welcome to ask the lecturer or a TA. Homework submissions will not be reviewed if there is any
   * `var` usage, (unless it is explicitly stated as allowed in the task description).
   */
  var `forget about it` = "You should never use variables "
  `forget about it` = `forget about it` + "because they can mutate"

  /**
   * This is an explicitly typed value.
   */
  val `I am an explicitly typed value`: Boolean = true

  /**
   * We use only camelCase naming conventions. We prefer this notation over names like `it is true or false`.
   *
   * Keep backtick-based naming for learning materials, not for your production or homework code.
   */
  val theOnlyAcceptableNaming: Boolean = `I am an explicitly typed value`

  /**
   * We do not use snake_case naming. It is forbidden in this course. Fortunately, kebab-case naming such as
   * `it-is-true-or-false` is not supported by Scala syntax anyway.
   */
  val not_acceptable_naming: Boolean = `I am an explicitly typed value`

  /**
   * We do not use C-style naming. There is no reason to save on naming.
   */
  val s = 42

  /**
   * Explicitness and readability must be in the first place.
   */
  val theAnswerToLifeTheUniverseAndEverything = 42

end `variables and values`
