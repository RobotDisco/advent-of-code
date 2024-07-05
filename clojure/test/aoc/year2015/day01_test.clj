(ns aoc.year2015.day01-test
  (:require [clojure.test :refer [deftest is]]
            ;; system under test
            [aoc.year2015.day01 :as sut]))

(deftest star1
  (is (= 0 (sut/star1 "(())")))
  (is (= 0 (sut/star1 "()()")))

  (is (= 3 (sut/star1 "(((")))
  (is (= 3 (sut/star1 "(()(()(")))

  (is (= 3 (sut/star1 "))(((((")))

  (is (= -1 (sut/star1 "())")))
  (is (= -1 (sut/star1 "))(")))

  (is (= -3 (sut/star1 ")))")))
  (is (= -3 (sut/star1 ")())())"))))


(deftest star2
  (is (= 1 (sut/star2 ")")))
  
  (is (= 5 (sut/star2 "()())"))))
