"
This class contains tests for `AOC2015Day03`
"
Class {
	#name : #AOC2015Day03Test,
	#superclass : #TestCase,
	#category : #'AdventOfCode-2015-Tests-Solutions'
}

{ #category : #stars }
AOC2015Day03Test >> testStar1 [

	self assert: (AOC2015Day03 star1WithInput: '>') equals: 2.
	self assert: (AOC2015Day03 star1WithInput: '^>v<') equals: 4.
	self assert: (AOC2015Day03 star1WithInput: '^v^v^v^v^v') equals: 2.
]

{ #category : #stars }
AOC2015Day03Test >> testStar2 [

	self assert: (AOC2015Day03 star2WithInput: '^v') equals: 3.
	self assert: (AOC2015Day03 star2WithInput: '^>v<') equals: 3.
	self assert: (AOC2015Day03 star2WithInput: '^v^v^v^v^v') equals: 11
]
