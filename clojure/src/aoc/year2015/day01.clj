(ns aoc.year2015.day01
  (:require [clojure.test :refer [with-test is]]))

(with-test
  (defn star1
    "Solution for Advent of Code Year 2015, Day 1, Star 1"
    [input]
  ;; Assuming we start at floor 0, iterate through the string.
  ;; If we find a \(, increment the floor.
  ;; If we find a \), decrement the floor.
  ;; Return the floor we wind up on.
    (reduce (fn [acc x]
              (cond (= \( x) (inc acc)
                    (= \) x) (dec acc)))
            0
            input))

  (is (= 0 (star1 "(())")))
  (is (= 0 (star1 "()()")))

  (is (= 3 (star1 "(((")))
  (is (= 3 (star1 "(()(()(")))

  (is (= 3 (star1 "))(((((")))

  (is (= -1 (star1 "())")))
  (is (= -1 (star1 "))(")))

  (is (= -3 (star1 ")))")))
  (is (= -3 (star1 ")())())"))))

(with-test
  (defn star2
    "Solution for Advent of Code Year 2015, Day 1, Star 2"
    [input]
  ;; Let's do this without producing an output sequence, because all we really
  ;; care about is the position of the string at the time we switch to a
  ;; negative floor.
  ;; We can use loop/recur for this.
    (loop [;; Generate a sequence view for our input string
           input (seq input)
         ;; Start with the 0th character in the string
           pos 0
         ;; Start on floor 0
           floor 0]
    ;; Are we on a negative floor? Immediately return the current input position.
      (if (neg? floor)
        pos
        (let [char (first input)]
          (recur
         ;; Iterate through the rest of the input
           (rest input)
         ;; Increase the position counter
           (inc pos)
           (cond
           ;; If we find a \(, increment the floor
             (= \( char) (inc floor)
           ;; If we find a \), decrement the floor
             (= \) char) (dec floor)))))))

  (is (= 1 (star2 ")")))
  (is (= 5 (star2 "()())"))))
