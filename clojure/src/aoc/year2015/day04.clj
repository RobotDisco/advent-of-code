;;;; Solution for Advent of CodeYear 2015 Day 04.
;;;; See question and examples at https://adventofcode.com/2015/day/4.
;;;; See your specific input at https://adventofcode.com/2015/day/4/input

(require '[babashka.pods :as pods])
(pods/load-pod 'org.babashka/buddy "0.3.4")

(ns aoc.year2015.day04
  (:require [clojure.string :as str]
            [clojure.test :refer [with-test is]]
            [pod.babashka.buddy.core.codecs :refer [bytes->hex]]
            [pod.babashka.buddy.core.hash :as hash]))

(defn find-counter
  [key target-prefix]
  (loop [ctr 1]
    (let [plaintext (format "%s%d" key ctr)
          hashed (-> plaintext
                     hash/md5
                     bytes->hex)]
      (if (str/starts-with? hashed target-prefix)
        ctr
        (recur (inc ctr))))))


(with-test
  (defn star1 [input]
    (find-counter input "00000"))

  (is (= 609043 (star1 "abcdef")))
  (is (= 1048970 (star1 "pqrstuv"))))

(with-test
  (defn star2 [input]
    "Not Implemented"))
