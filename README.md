## Functional Programming Course at KSE

# Scala Course Spring

## Documentation and Resources
* [Scala 3 Reference](https://docs.scala-lang.org/scala3/reference/)
* [Documentation](https://docs.scala-lang.org/)
* [Документація](https://docs.scala-lang.org/uk/)
* [Scala 3 Book](https://docs.scala-lang.org/scala3/book/introduction.html)
* [Introduction to Scala 3](https://www.baeldung.com/scala/dotty-scala-3)
* [Scala Exercises](https://www.scala-exercises.org/)

## External Courses
* [Functional Programming Principles in Scala](https://www.coursera.org/learn/scala-functional-programming?specialization=scala) (Scala 2 in general)
* [Functional Programming in Scala Specialization](https://www.coursera.org/specializations/scala) (Scala 2 in general)

## Telegram community
* [Scala Ukraine](https://t.me/scala_ukraine)

## Course format
Each homework assignment corresponds to a specific unit in the course, labeled `unit1`, `unit2`, and so on.

Each unit has two main components: `topic` and `challenge`, covering both the `main` and `test` sources.

In the `topic` section, the material is explained and template tests are provided.
The `challenge` section involves implementing or improving code and approaches similar to those covered in the `topic`.
Tests are required and are an integral part of the assignment contract unless explicitly stated otherwise.

### Requirements for Submitting Homework for Review
Failure to comply with any of the following rules will result in the homework not being reviewed:

* Both `main` and `test` code must compile successfully.
* Tests must be implemented unless explicitly stated otherwise.
* All tests must pass.
* The code must adhere to formatting guidelines.

Students may submit incomplete homework to verify assumptions, but any incompleteness must be explicitly stated in the submission.

## Code style
The project uses [scalafmt](https://scalameta.org/scalafmt/) as the code formatter for Scala.
All code must be formatted using scalafmt after each commit.

# Prerequisites

# How to start
1. Install [Git](https://git-scm.com/downloads) on your local machine if needed.
2. Install [sbt](https://www.scala-sbt.org/download/) on your local machine if needed.
3. Create a GitHub account (if you don't already have one).
4. Set up a private GitHub repository.
5. Clone the repository locally (do not fork it).
6. Push the local repository to your private GitHub repository.
7. Create a new branch for each challenge assignment.

### Create a GitHub account
Visit https://github.com/ and follow the sign-up process.
Choose a professional username, typically in the format `[First][Last]` (for example, my personal GitHub account is https://github.com/IgorWolkov).
Follow this [guide](https://www.jetbrains.com/help/idea/github.html) to set up your GitHub account in IntelliJ IDEA.

### Create a new repository on GitHub
To create a new repository on GitHub, follow this [guide](https://docs.github.com/en/repositories/creating-and-managing-repositories/creating-a-new-repository).
* Ensure the repository is private.
* Name the repository `scala-course-autumn` to match the original repository name.
* Add collaborators:
  * [Igor Wolkov](https://github.com/IgorWolkov);
  * [Kseniia Kravchenko](https://github.com/KravchenkoKseniia)

### Clone the course repository
To clone the repository, follow this [guide](https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository).

**Important**: Do not fork the repository.

The course repository is [here](https://github.com/Mexmath-Foundation/scala-course-autumn).
You can use IntelliJ IDEA or do it manually.
To clone manually, create a new folder called `scala-course-autumn`, move into the folder, and run
````shell
git clone https://github.com/Mexmath-Foundation/scala-course-autumn.git
````
in the command line.

### Verify the cloned repository
#### Check the remote
To check the remote repositories, run the following command in the command line:
```shell
git remote -v
```
The output should be:
```shell
origin	https://github.com/Mexmath-Foundation/scala-course-autumn.git (fetch)
origin	https://github.com/Mexmath-Foundation/scala-course-autumn.git (push)
```
#### Check the branches
To check the branches, run the following command in the command line:
```shell
git branch
```
The output should be:
```shell
* main
```
#### Compile the code
To check the code compiles, run the following command in the command line:
```shell
sbt clean compile
```

### Secure the original repository
Students are **not allowed** to push changes to the original course repository.
To prevent accidental pushes, it is necessary to detach the original repository from your private repository.
To do this, rename the `origin` and disable `push` to the original course repository.

#### Rename origin
To rename the origin, run the following command in the command line:
```shell
git remote rename origin course
```

Run `git remote -v` in the command line. The output should be:
```shell
course	https://github.com/Mexmath-Foundation/scala-course-autumn.git (fetch)
course	https://github.com/Mexmath-Foundation/scala-course-autumn.git (push)
```
#### Disable pushes
To prevent pushing to the course repository, replace the push URL with any non-existent value (for example, `DISABLED`) and run the following command in the command line:
```shell
git remote set-url --push course DISABLED
```

Run `git remote -v` in the command line. The output should be:
```shell
course	https://github.com/Mexmath-Foundation/scala-course-autumn.git (fetch)
course	DISABLED (push)
```

### Link the local repository to your private repository
To link the local repository to your private GitHub repository, add a new `origin`.

#### Open the newly created repository
Open your new GitHub repository page and follow the instructions in the `...or push an existing repository from the command line` section.
There should be a list of commands:
```shell
git remote add origin <your private repository>
git branch -M main
git push -u origin main
```
Run each command one by one in the command line.

Run `git remote -v` in the command line. The output should be:
```shell
course	https://github.com/Mexmath-Foundation/scala-course-autumn.git (fetch)
course	DISABLED (push)
origin  https://github.com/<your GitHub account>/scala-course-autumn.git (fetch)
origin  https://github.com/<your GitHub account>/scala-course-autumn.git (push)
```

### Pull Updates from the Original Course Repository
The original course repository may be updated from time to time.

To fetch updates from the original course repository, run the following command in the command line:
```shell
git pull course main
```

### New branch for each homework
A separate branch must be created for each homework assignment.
Students are *not allowed* to commit any changes to the `main` branch, except in explicitly described cases.

# Code compilation and verification
## Compilation

### Source code compilation
To compile the source code (located in the `main/` folder), run
```shell
sbt clean compile
```
in the command line, or

```shell
clean; compile
```

in the `sbt` shell.

### Test code compilation
To compile the test code (located in the `test/` folder), run
```shell
sbt "Test / compile"
```
in the command line, or

```shell
Test / compile
```

in the `sbt` shell.

## Test execution

To execute all tests in the project, run the `test` command.

**Note**: The following command fails, and that is expected:

```shell
sbt test
```
in the command line, or

```shell
test
```
in the `sbt` shell.

The failure occurs because the `test` command runs all tests in the project.
Since some homework tests have not been implemented yet, this results in a failure.

### Single test execution
To execute a single test, run the following command:
```shell
sbt "Test / testOnly <path to the test>"
```
in the command line, or

```shell
Test / testOnly <path to the test>
```

in the `sbt` shell.

For example, to execute `FunctionsSpecification` from Unit 1 `topic`, run the following command:

```shell
sbt "Test / testOnly kse.unit1.topic.FunctionsSpecification"
```
in the command line, or

```shell
Test / testOnly kse.unit1.topic.FunctionsSpecification
```

### Specific unit tests execution
To execute the tests for a specific unit, run the following command:

```shell
sbt "Test / testOnly <path to the specific unit>"
```
in the command line, or

```shell
Test / testOnly <path to the specific unit>
```

in the `sbt` shell, where `<path to the specific unit>` is:
* `kse.unit1` for the **Unit 1**;
* `kse.unit2` for the **Unit 2**;

  ...

* `kse.unitN` for the **Unit N**;

For example, to execute tests for Unit 1, run the following command:
```shell
sbt "Test / testOnly kse.unit1.*"
```
in the command line, or

```shell
Test / testOnly kse.unit1.*
```

in the `sbt` shell.


## Code style

[Scalafmt](https://scalameta.org/scalafmt/) is used to check code formatting
and reformat code according to the rules described in `.scalafmt.conf`
in the root (`scala-course-autumn`) folder.
These rules are applied in GitHub Actions builds.

Follow the [guide](https://scalameta.org/scalafmt/docs/installation.html#intellij)
for setting up code reformatting in your IDE.

### Checking code style
#### `main/` location
To check whether the code in `main/` is properly formatted, run
```shell
sbt scalafmtCheck
```
in the command line, or

```shell
scalafmtCheck
```

in the `sbt` shell.

#### `test/` location
To check whether the code in `test/` is properly formatted, run

```shell
sbt "Test / scalafmtCheck"
```
in the command line, or

```shell
Test / scalafmtCheck
```

in the `sbt` shell.

#### All locations
To check whether the code in all locations is properly formatted, run

```shell
sbt scalafmtCheckAll
```
in the command line, or


```shell
scalafmtCheckAll
```

in the `sbt` shell.


### Fixing code style

#### IDE

Follow the [guide](https://scalameta.org/scalafmt/docs/installation.html#intellij)
for setting up code reformatting in your IDE.

#### `main/` location
To format the code in `main/`, run
```shell
sbt scalafmt
```
in the command line, or

```shell
scalafmt
```

in the `sbt` shell.

#### `test/` location
To format the code in `test/`, run

```shell
sbt "Test / scalafmt"
```
in the command line, or

```shell
Test / scalafmt
```

in the `sbt` shell.

#### All locations
To format the code in all locations, run

```shell
sbt scalafmtAll
```
in the command line, or


```shell
scalafmtAll
```

in the `sbt` shell.

## One ~~ring~~ command to rule them all

### Compile and fix formatting
To compile the code and fix formatting, run

```shell
sbt clean compile Test/compile scalafmtAll scalafmtCheckAll
```
in the command line, or

```shell
clean; compile; Test/compile; scalafmtAll; scalafmtCheckAll
```
in the `sbt` shell.

### Compile, fix formatting and run tests
To compile the code, fix formatting, and run tests for a specific unit, run

```shell
sbt "clean compile Test/compile scalafmtAll scalafmtCheckAll Test / testOnly <path to the specific unit>"
```
in the command line, or

```shell
clean; compile; Test/compile; scalafmtAll; scalafmtCheckAll; Test / testOnly <path to the specific unit>
```

# GitHub Actions build
To replicate the behavior of the GitHub Actions build locally, run:

```shell
sbt "clean compile Test/compile scalafmtCheckAll Test / testOnly <path to the specific unit>"
```
in the command line, or
```shell
clean; compile; Test/compile; scalafmtCheckAll; Test / testOnly <path to the specific unit>
```
in the `sbt` shell.

# Passing the homework

## New branch for each homework
Students are not allowed to commit any changes to the `main` branch except in explicitly described cases.
* A separate branch is required for each homework.
* Follow the naming convention for branches:
  * `unit-1` for Unit 1
  * `unit-2` for Unit 2

    ...

  * `unit-n` for Unit n

The naming convention is used in the GitHub Actions build setup to run only the tests related
to a specific unit. Violating the conventions leads to failed builds.


## Repeat it every time

1. Check out the `main` branch.
2. Update the `main` branch.
3. Create or check out a local `unit-n` branch.
4. Merge the `main` branch into the local `unit-n` branch.
5. Commit all necessary changes to the local `unit-n` branch.
6. Push the changes to your private remote GitHub repository.
7. Create a pull request.
8. Assign reviewers: 
 * [Igor Wolkov](https://github.com/IgorWolkov);
 * [Kseniia Kravchenko](https://github.com/KravchenkoKseniia).


# IntelliJ IDEA UI Git management
Using the IntelliJ IDEA UI to manage Git actions is easy.

* [Sync with a remote Git repository](https://www.jetbrains.com/help/idea/sync-with-a-remote-repository.html)
  * [fetch](https://www.jetbrains.com/help/idea/sync-with-a-remote-repository.html#fetch)
  * [update](https://www.jetbrains.com/help/idea/sync-with-a-remote-repository.html#update-git-branch)
  * [pull](https://www.jetbrains.com/help/idea/sync-with-a-remote-repository.html#pull)

* [Managing branches](https://www.jetbrains.com/help/idea/manage-branches.html)
  * [create branch](https://www.jetbrains.com/help/idea/manage-branches.html#create-branch)
  * [checkout branch](https://www.jetbrains.com/help/idea/manage-branches.html#checkout-Git-branch)
  * [switch between branches](https://www.jetbrains.com/help/idea/manage-branches.html#switch-branches)
  * [shelve or stash changes](https://www.jetbrains.com/help/idea/shelving-and-unshelving-changes.html)
