(ns aoc.year2015.day03-test
  (:require [clojure.test :refer [deftest is]]
            [aoc.year2015.day03 :as sut]))

(deftest star1
  (is (= 2 (sut/star1 ">")))
  (is (= 4 (sut/star1 "^>v<")))
  (is (= 2 (sut/star1 "^v^v^v^v^v"))))


(deftest star2)