"
Tests for `AOC2015Day01`
"
Class {
	#name : #AOC2015Day01Test,
	#superclass : #TestCase,
	#category : #'AdventOfCode-2015-Tests-Solutions'
}

{ #category : #'class tests' }
AOC2015Day01Test >> testStar1 [

	"test that star1WithInput correctly tells me the floor I am currently on after evaluating the input string.
	
	Example: '(())' places us on floor 0
	Example: '()()' places us on floor 0
	Example: '(((' places us oj floor 3
	Example: '()) places us on floor -1"

	self
		assert: (AOC2015Day01 star1WithInput: '(())') equals: 0;
		assert: (AOC2015Day01 star1WithInput: '()()') equals: 0;
		assert: (AOC2015Day01 star1WithInput: '(((') equals: 3;
		assert: (AOC2015Day01 star1WithInput: '(()(()(') equals: 3;
		assert: (AOC2015Day01 star1WithInput: '))(((((') equals: 3;
		assert: (AOC2015Day01 star1WithInput: '())') equals: -1;
		assert: (AOC2015Day01 star1WithInput: '))(') equals: -1;
		assert: (AOC2015Day01 star1WithInput: ')))') equals: -3;
		assert: (AOC2015Day01 star1WithInput: ')())())') equals: -3
]

{ #category : #'class tests' }
AOC2015Day01Test >> testStar2 [

	"Test that star2WithInput correctly finds the position of the first character in the input string that caused Santa to enter the basement (floor -1).
	
	Example ')' reaches the basement after step 1
	Example '()())' reaches the basement after step 5"

		self assert: (AOC2015Day01 star2WithInput: ')') equals: 1.
		self assert: (AOC2015Day01 star2WithInput: '()())') equals: 5
]
