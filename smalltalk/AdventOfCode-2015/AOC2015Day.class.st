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
	self
		subclass: className
		instanceVariableNames: ''
		classVariableNames: 'INPUT'
		package: 'AdventOfCode-2015-Solutions'.

	"Create test class"
	self
		subclass: testClassName
		instanceVariableNames: ''
		classVariableNames: ''
		package: 'AdventOfCode-2015-Tests-Solutions'.

	class := Smalltalk at: className.
	class
		compile: 'star1
		self flag: #notYetImplemented'
		classified: 'stars'.
	class
		compile: 'star2
		self flag: #notYetImplemented'
		classified: 'stars'.

	"Define test stubs."
	testClass := Smalltalk at: testClassName.
	testClass
		compile: 'testStar1
	    self flag: #notYetImplemented'
		classified: 'stars'.
	testClass
		compile: 'testStar2
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
