"
Solution for [Advent of Code 2015, Day 4](https://adventofcode.com/2015/day/4)

See `star1WithInput:` and `star2WithInput:` for the exercise definitions.

Public API:
•	`star1withInput:` - Compute star 1 with provided input.
•	`star2withInput:` - Compute star 2 with provided input.
•	`star1` - Compute star1 with website-provided evaluation input.
•	`star2` - Compute star2 with website-provided evaluation input.
"
Class {
	#name : #AOC2015Day04,
	#superclass : #AOC2015Day,
	#classVars : [
		'INPUT'
	],
	#category : #'AdventOfCode-2015-Solutions'
}

{ #category : #'private  - implementation' }
AOC2015Day04 class >> findNumberWithPrefix: prefix forInput: input [

	^ (1 to: SmallInteger maxVal) detect: [ :i | 
		  | hash |
		  hash := ZnDigestAuthenticator md5Hash: input , i asString.
		  hash beginsWith: prefix ]
]

{ #category : #'class initialization' }
AOC2015Day04 class >> initialize [ 

INPUT := 'yzbqklnj'
]

{ #category : #stars }
AOC2015Day04 class >> star1 [

	^ self star1WithInput: INPUT
]

{ #category : #stars }
AOC2015Day04 class >> star1WithInput: input [

	"Santa needs help mining some AdventCoins (very similar to bitcoins) to use as gifts for all the economically forward-thinking little girls and boys.

To do this, he needs to find MD5 hashes which, in hexadecimal, start with at least five zeroes. The input to the MD5 hash is some secret key (your puzzle input, given below) followed by a number in decimal. To mine AdventCoins, you must find Santa the lowest positive number (no leading zeroes: 1, 2, 3, ...) that produces such a hash.

For example:

If your secret key is abcdef, the answer is 609043, because the MD5 hash of abcdef609043 starts with five zeroes (000001dbbfa...), and it is the lowest such number to do so.
If your secret key is pqrstuv, the lowest number it combines with to make an MD5 hash starting with five zeroes is 1048970; that is, the MD5 hash of pqrstuv1048970 looks like 000006136ef...."

	^ self findNumberWithPrefix: '00000' forInput: input
]

{ #category : #stars }
AOC2015Day04 class >> star2 [

	^ self star2WithInput: INPUT
]

{ #category : #stars }
AOC2015Day04 class >> star2WithInput: input [

	"Now find one that starts with six zeroes."

	^ self findNumberWithPrefix: '000000' forInput: input
]
