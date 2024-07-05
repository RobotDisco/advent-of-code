#!/usr/bin/env bb

;;;; test_runner.clj -- babashka test runner from https://book.babashka.org

(require '[clojure.test :as t]
         '[babashka.classpath :as cp])

;; search src/ and test/ directories for clojure file when requiring namespaces
(cp/add-classpath "src:test")

(require 'aoc.year2015.day01-test)
(require 'aoc.year2015.day02-test)

(def test-results
  (t/run-tests 'aoc.year2015.day01-test
               'aoc.year2015.day02-test))

(let [{:keys [fail error]} test-results]
  (when (pos? (+ fail error))
    (System/exit 1)))
