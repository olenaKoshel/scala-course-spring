# Unit 5

You are challenged to implement a set of numerals based on a binary tree:
* Implement `NumeralSet`, `Empty`, and `NonEmpty`.
* The `remove`, `difference`, and `symmetric difference` operations are optional challenges.
* Generators are already provided for you.
* Implement the required tests in `NumeralSetSpecification`.
* All tests must pass.
* The GitHub build must be green.

## Set
```
NumeralSet ::= Empty | NonEmpty(NumeralSet, Numeral, NumeralSet)
```

Review:
* [Set](https://en.wikipedia.org/wiki/Set_(mathematics))
* [Binary tree](https://en.wikipedia.org/wiki/Binary_tree)
