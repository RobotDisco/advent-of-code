;;;; Solution for Advent of CodeYear 2015 Day 03.
;;;; See question and examples at https://adventofcode.com/2015/day/3.
;;;; See your specific input at https://adventofcode.com/2015/day/$d/input
(ns aoc.year2015.day03)

(defn move-location
  "Based on the cardinal direction represented by the character in `direction`,
  advance the coordinates `x` and `y` by one unit of distance."
  [[x y] direction]
  (case direction
    ;; West, decrement x coordinate
    \< [(dec x) y]
    ;; East, increment x coordinate
    \> [(inc x) y]
    ;; North, increment y coordinate
    \^ [x (inc y)]
    ;; South, decrement y coordinate
    \v [x (dec y)]))

(defn update-prezzies
  "Update the map `prezzies` so that the value for the key `location` is
  incremented, indicating that another gift has been delivered to the house at
  that location. If `location` has never been visited before, add it to
  `prezzies` with one gift having been delivered."
  [prezzies location]
  (update prezzies location (fn [val] (if (nil? val) 1 (inc val)))))

(defn deliver-gifts
  "Inputs:
  - `input` is a sequence of characters representing the direction of each
    gift
  - `locations` is a map of identifiers to sleigh coordinate tuples
  - `initial-cursor` is a key indicating the sleigh initially being moved
  - `next-cursor` is a function that takes the active sleigh and returns the next"
  [input locations initial-cursor next-cursor]
  ;; The problem specifies that Santa has already delivered a present to the
  ;; house at location [0 0]
  (loop [prezzies {[0 0] 1}
         locations locations
         cursor initial-cursor
         input (seq input)]
    ;; Do we still have more input to process?
    (if (seq input)
      (let
          [location (locations cursor)
           nextloc (move-location location (first input))
           new-prezzies (update-prezzies prezzies nextloc)]
          (recur
           new-prezzies
           (assoc locations cursor nextloc)
           (next-cursor cursor)
           (next input)))
      ;; We have no more input, return number of coordinates where households
      ;; were given multiple gift deliveries
      prezzies)))

(defn star1 [input]
  (count (deliver-gifts input
                        ;; There's only a single sleigh.
                        {true [0 0]}
                        true
                        ;; Constantly return the same cursor
                        (fn [_cur] true))))

(defn star2 [input]
  (count (deliver-gifts input
                        ;; There is Santa's sleigh and RoboSanta's sleigh
                        {true [0 0] false [0 0]}
                        ;; Move Santa first
                        true
                        ;; A boolean allows us to easily flip between the two sleighs
                        (fn [cur] (not cur)))))
