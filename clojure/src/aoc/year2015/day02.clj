(ns aoc.year2015.day02
  (:require [clojure.string :as str]))

(defn parse-dimensions
  "Convert a string of the format AxBxC into a 3-tuple of integers.

  A, B and C in the above should be parsable as integers."
  [s]
  (let [dim-strs (str/split s #"x")]
    (map #(Integer/parseInt %) dim-strs)))

(defn side-areas
  "Given a 3-tuple of rectangular prism `dimensions`, return 3-tuple of face
  areas.

  We are presupposing that the rectangular prism is regular, and as such there
  will be at most three unique sides."
  [dimensions]
  (let [[length width height] dimensions]
    (list
     (* length width)
     (* width height)
     (* height length))))

(defn total-paper
  "Compute the total amount of wrapping paper.

  This is going to be the sum of every area multiplied by two, in additional to
  adding the smallest area one more time.

  Inputs:
  `dimensions`: A 3-tuple of a rectangular prism's length, height, and width."
  [dimensions]
  (let [areas (side-areas dimensions)
        ; Multiply each area by 2
        double-areas (map (partial * 2) areas)
        ; The smallest area of the rectangular prism
        smallest (apply min areas)]
    (+ smallest (apply + double-areas))))

(defn side-perimeters
  "Compute a tuple of side perimeters for each edge of a rectangular prism.

  `dimensions` will be a tuple of box dimensions in the form [length width
  height]. Return a 3-tuple representing the perimeters of all three perimeters."
  [dimensions]
  (let [[length width height] dimensions]
    (list
     ;; A perimeter for a side that is s1 long by s2 units wide is (2 * (s1 + s2)) units)
     (* 2 (+ length width))
     (* 2 (+ width height))
     (* 2 (+ height length)))))

(defn ribbon-length
  "Given a sequence of [length width height] 3-tuples, compute the ribbon-length
  required for the box as defined by Advent of Code 2015 Day 2.

  Add the perimeter of the smallest side and the cubic volume of the box.

  Return a number indicating the total inches of ribbon required."
  [dimensions]
  (let [perimeters (side-perimeters dimensions)
        smallest (apply min perimeters)
        volume (apply * dimensions)]
    (+ smallest volume)))


;;; For both these stars, we are doing the same general thing:
;;; 1. Split input into a sequence of lines
;;; 2. Parse each line into a useful structure
;;; 3. Reduce the sequence of lines into a single answer.
;;;
;;; Is this a pattern many of our stars will follow?
;;; Keep an eye for that in the future to see if we need
;;; a function or macro for this.
(defn star1
  "Solution for Advent of Code Year 2015, Day 2, Star 1"
  [input]
  ;; Take the input string we fetch from adventofcode.com
  (->> input
       ;; Split it into lines (each line will be an item unto itself)
       str/split-lines
       ;; Decipher the line based on the question-specific domain specific
       ;; language and make sequence of data that is useful
       (map parse-dimensions)
       ;; Produce an answer from our processed data.
       (map total-paper)
       ;; Reduce sequence of computed subanswers into the total sum
       (apply +)
       ;;
       ;; This is probably fine to do in a thread, as this wouldn't be a huge
       ;; amount of data, and it's better to be readable until I'm fluent in
       ;; Clojure.
       ;;
       ;; If this becomes a pattern I keep using, I will consider making a macro
       ;; out of this flow.
       ))


(defn star2
  "Solution for Advent of Code Year 2015, Day 2, Star 2"
  [input]
  ;; Take the input string we fetch from adventofcode.com
  (->> input
  ;; Split it into lines (each line will be an item unto itself)
       str/split-lines
       ;; Decipher the line based on the question-specific domain specific
       ;; language and make sequence of data that is useful
       (map parse-dimensions)
       ;; Produce an answer from our processed data.
       (map ribbon-length)
       ;; Reduce sequence of computed subanswers into the total sum
       (apply +)
       ;;
       ;; This is probably fine to do in a thread, as this wouldn't be a huge
       ;; amount of data, and it's better to be readable until I'm fluent in
       ;; Clojure.
       ;;
       ;; If this becomes a pattern I keep using, I will consider making a macro
       ;; out of this flow.
       ))
