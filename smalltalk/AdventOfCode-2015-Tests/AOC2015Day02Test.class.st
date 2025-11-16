"
Tests for `AOC2015Day02`
"
Class {
	#name : #AOC2015Day02Test,
	#superclass : #TestCase,
	#category : #'AdventOfCode-2015-Tests-Solutions'
}

{ #category : #'class tests' }
AOC2015Day02Test >> testStar1 [

	self assert: (AOC2015Day02 star1WithInput: '2x3x4') equals: 58.
	self assert: (AOC2015Day02 star1WithInput: '1x1x10') equals: 43
]

{ #category : #'class tests' }
AOC2015Day02Test >> testStar2 [

	self assert: (AOC2015Day02 star2WithInput: '2x3x4') equals: 34.
	self assert: (AOC2015Day02 star2WithInput: '1x1x10') equals: 14
]
