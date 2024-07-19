;;;; Solution for Advent of CodeYear 2015 Day 04.
;;;; See question and examples at https://adventofcode.com/2015/day/4.
;;;; See your specific input at https://adventofcode.com/2015/day/4/input

(require '[babashka.pods :as pods])
(pods/load-pod 'org.babashka/buddy "0.3.4")

(ns aoc.year2015.day04
  (:require #_ [clojure.core.reducers :as r]
            [clojure.string :as str]
            [clojure.test :refer [with-test is]]
            [pod.babashka.buddy.core.codecs :refer [bytes->hex]]
            [pod.babashka.buddy.core.hash :as hash]))


;; Original version, way too slow
(defn find-counter-single-threaded
  [key target-prefix]
  (loop [ctr 1]
    (let [plaintext (format "%s%d" key ctr)
          hashed (-> plaintext
                     hash/md5
                     bytes->hex)]
      (if (str/starts-with? hashed target-prefix)
        ctr
        (recur (inc ctr))))))

;; Reducer version, would work if Babashka supported reducers
#_ (defn find-counter-reducer
  [key target-prefix]
  (loop [millionth 0]
    (let [start (* millionth 1000000)
          end (+ start 999999)
          res (first
               (sort
                (r/filter (fn [ctr]
                            (let [plaintext (format "%s%d" key ctr)
                                  hashed (-> plaintext
                                             hash/md5
                                             bytes->hex)]
                              (str/starts-with? hashed target-prefix)))
                          (range start end))))]
      (if res
        res
        (recur (inc millionth))))))

(defn find-counter
  [key target-prefix]
  (let [generate-hash (fn [ctr]
                        (let [plaintext (format "%s%d" key ctr)
                              hashed (-> plaintext
                                         hash/md5
                                         bytes->hex)]
                          [ctr hashed]))
        is-valid? (fn [[_ hashed]] (str/starts-with? hashed target-prefix))]
    (loop [millionth 0]
      (let [start (* millionth 1000000)
            end (+ start 1000000)
            ;; `pmap` uses parallelism and futures to generate a lazy sequence
            hashes (pmap generate-hash (range start end))
            ;; Return the `ctr` part of our [ctr hashed] tuple.
            val (first
                 ;; Return the first value in our future seq that begins with
                 ;; the supplied `target-prefix`
                 (first (filter is-valid? hashes)))]
        (if val
          val
          (recur (inc millionth)))))))


(with-test
  (defn star1 [input]
    (find-counter input "00000"))

  (is (= 609043 (star1 "abcdef")))
  (is (= 1048970 (star1 "pqrstuv"))))


(with-test
  (defn star2 [input]
    (find-counter input "000000")))
