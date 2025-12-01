"
I track a moving target along a 2D plane via X/Y coordinates, moving according to a specific character syntax.

Usage:
```
santa := AOC2015Day03Sleigh new.
santa x. ""=> 0""
santa y. ""=> 0""
santa moveUp.
santa asPoint. ""=> 0@1"".
santa followDirection: $>. ""=> 1@1"".
``` 
"
Class {
	#name : #AOC2015Day03Sleigh,
	#superclass : #Object,
	#instVars : [
		'x',
		'y'
	],
	#category : #'AdventOfCode-2015-Framework'
}

{ #category : #converting }
AOC2015Day03Sleigh >> asPoint [

"Represent my position as a `Point`."

	^ Point x: x y: y
]

{ #category : #interpreting }
AOC2015Day03Sleigh >> followDirection: char [

	"Interpret select characters and move my position based on a syntax.
	
	< moves me left one position.
	> moves me right one position.
	^ moves me up one position.
	v moves me down one position.
	Any other character does nothing."

	char = $< ifTrue: [ self moveLeft ].
	char = $> ifTrue: [ self moveRight ].
	char = $^ ifTrue: [ self moveUp ].
	char = $v ifTrue: [ self moveDown ]
]

{ #category : #initialization }
AOC2015Day03Sleigh >> initialize [

	"I begin at position 0,0"

	x := 0.
	y := 0
]

{ #category : #movement }
AOC2015Day03Sleigh >> moveDown [

	y := y - 1
]

{ #category : #movement }
AOC2015Day03Sleigh >> moveLeft [

x := x - 1
]

{ #category : #movement }
AOC2015Day03Sleigh >> moveRight [

	x := x + 1
]

{ #category : #movement }
AOC2015Day03Sleigh >> moveUp [

	y := y + 1
]

{ #category : #accessing }
AOC2015Day03Sleigh >> x [

	^ x
]

{ #category : #accessing }
AOC2015Day03Sleigh >> y [

	^ y
]
