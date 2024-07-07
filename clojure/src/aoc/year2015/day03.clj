;;;; Solution for Advent of CodeYear 2015 Day 03.
;;;; See question and examples at https://adventofcode.com/2015/day/3.
;;;; See your specific input at https://adventofcode.com/2015/day/$d/input
(ns aoc.year2015.day03)

(defn bob [input]
  (loop [prezzies {[0 0] 1}
         location [0 0]
         input (seq input)]
    ;; Do we still have more input to process?
    (if (seq input)
      ;; Figure out our next destination based on the input glyph
      (let
       [[x y] location
        nextloc (case (first input)
                     ;; West, decrement x coordinate
                  \< [(dec x) y]
                     ;; East, increment x coordinate
                  \> [(inc x) y]
                     ;; North, increment y coordinate
                  \^ [x (inc y)]
                     ;; South, decrement y coordinate
                  \v [x (dec y)])]
        (recur
         (update prezzies nextloc (fn [val] (if (nil? val) 1 (inc val))))
         nextloc
         (next input)))
      ;; We have no more input, return number of coordinates where households
      ;; were given multiple gift deliveries
      prezzies)))

(defn star1 [input]
  (count (bob input)))

(defn star2 [input]
	input)
