(ns aoc.year2015.day02-test
  (:require [clojure.test :refer [deftest is]]
            ;; system under test
            [aoc.year2015.day02 :as sut]))

(deftest star1
  (is (= 58 (sut/star1 "2x3x4")))
  (is (= 43 (sut/star1 "1x1x10"))))


(deftest star2
  (is (= 34 (sut/star2 "2x3x4")))
  (is (= 14 (sut/star2 "1x1x10"))))
