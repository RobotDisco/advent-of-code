Class {
	#name : #AOC2015Day04Test,
	#superclass : #TestCase,
	#category : #'AdventOfCode-2015-Tests-Solutions'
}

{ #category : #stars }
AOC2015Day04Test >> testStar1WithInput [

	self timeLimit: 5 minutes.
	self assert: (AOC2015Day04 star1WithInput: 'abcdef') equals: 609043.
	self assert: (AOC2015Day04 star1WithInput: 'pqrstuv') equals: 1048970.
]

{ #category : #stars }
AOC2015Day04Test >> testStar2WithInput [

	"No tests provided"
	self skip.
	
]
