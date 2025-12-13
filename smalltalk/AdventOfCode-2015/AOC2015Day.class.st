"
Advent of Code 2015 base class

Each day subclasses this and implements solutions for both star puzzles.

Creating a new day:

	`AdventOfCode2015 createDay: 3`
	
This will create a solution class named ""AOC2015Day3"" and a test class named ""AOC2015Day3Test"", both having enough scaffolding to test and run puzzle solutions.
"
Class {
	#name : #AOC2015Day,
	#superclass : #Object,
	#category : #'AdventOfCode-2015-Framework'
}

{ #category : #stars }
AOC2015Day class >> createDay: dayNumber [

	"Create new daily solution class and test class, with boiler-plate."

	| className testClassName class testClass |
	className := ('AOC2015Day'
	              , (dayNumber asInteger printPaddedWith: $0 to: 2))
		             asSymbol.
	testClassName := ('AOC2015Day'
	                  , (dayNumber asInteger printPaddedWith: $0 to: 2)
	                  , 'Test') asSymbol.

	"Create Day class"
	class := (self
		          subclass: className
		          instanceVariableNames: ''
		          classVariableNames: 'INPUT'
		          package: 'AdventOfCode-2015-Solutions') class.
	class comment: ('Solution for [Advent of Code 2015, Day ', dayNumber asString, '](https://adventofcode.com/2015/day/', dayNumber asString, ')

See `star1WithInput:` and `star2WithInput:` for the exercise definitions.

Public API:
•	`star1withInput:` - Compute star 1 with provided input.
•	`star2withInput:` - Compute star 2 with provided input.
•	`star1` - Compute star1 with website-provided evaluation input.
•	`star2` - Compute star2 with website-provided evaluation input.').

	"Create test class"
	testClass := (TestCase
		              subclass: testClassName
		              instanceVariableNames: ''
		              classVariableNames: ''
		              package: 'AdventOfCode-2015-Tests-Solutions') class.

	class
		compile: 'initialize
	
	    INPUT := '''' "Official submission input."'
		classified: 'class initialization'.

	class
		compile: 'star1
		
		"solve for star 1 using pre-supplied input string INPUT"
		
		self test1WithInput: INPUT'
		classified: 'stars'.
	class
		compile: 'star1WithInput input
	   self flag: #notYetImplemented'
		classified: 'stars'.
	class
		compile: 'star2
		
		"invoke for star 2 using pre-supplied input string INPUT"
		
		self star2WithInput: INPUT'
		classified: 'stars'.
	class
		compile: 'star2WithInput input
	   self flag: #notYetImplemented'
		classified: 'stars'.

	"Define test stubs."
	testClass
		compile: 'testStarWithInput1
	    self flag: #notYetImplemented'
		classified: 'stars'.
	testClass
		compile: 'testStarWithInput2
	    self flag: #notYetImplemented'
		classified: 'stars'
]

{ #category : #stars }
AOC2015Day class >> star1 [
	self subclassResponsibility
]

{ #category : #stars }
AOC2015Day class >> star2 [

	self subclassResponsibility
]
