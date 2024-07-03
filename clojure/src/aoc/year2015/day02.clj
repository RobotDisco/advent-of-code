(ns aoc.year2015.day02
  (:require [clojure.string :as str]))

(defn str2vec [s]
  (let [strs (str/split s #"x")]
    (map parse-long strs)))

(defn side-areas [boxvec]
  (let [[length width height] boxvec]
    (seq
     [(* length width)
      (* width height)
      (* height length)])))

(defn double-areas [side-areas]
  (map (partial * 2) side-areas))

(defn smallest-area [areas]
  (apply min areas))

(defn total-paper [boxvec]
  (let [areas (side-areas boxvec)
        smallest (smallest-area areas)]
    (+ smallest (apply + (double-areas areas)))))

(defn cubic-volume [boxvec]
  (apply * boxvec))

(defn side-perimeters [boxvec]
  (let [[length width height] boxvec]
    (seq
     [(* 2 (+ length width))
      (* 2 (+ width height))
      (* 2 (+ height length))])))

(defn smallest-perimeter [perimeters]
  (apply min perimeters))

(defn ribbon-length [boxvec]
  (let [perimeters (side-perimeters boxvec)
        smallest (smallest-perimeter perimeters)
        volume (cubic-volume boxvec)]
    (+ smallest volume)))

(defn star1 [input]
  (reduce
   (fn [acc x] (+ acc (total-paper (str2vec x))))
   0
   (str/split-lines input)))

(defn star2 [input]
  (reduce
   (fn [acc x] (+ acc (ribbon-length (str2vec x))))
   0
   (str/split-lines input)))


