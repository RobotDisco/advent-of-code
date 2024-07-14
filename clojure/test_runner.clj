#!/usr/bin/env bb

;;;; test_runner.clj -- babashka test runner from https://book.babashka.org
;;;; modified to dynamically load files similar to https://gist.github.com/thiagokokada/fee513a7b8578c87c05469267c48e612

(require '[babashka.classpath :as cp]
         '[babashka.fs :as fs]
         '[clojure.string :as string]
         '[clojure.test :as t])

;; search src/ and test/ directories for clojure file when requiring namespaces
(cp/add-classpath "src:test")

(defn file->ns
  "Take a file `file` and turn it into a namespace symbol."
  [file]
  ;; Take the expression `file` and find it to the name $
  (as-> file $
    ;; Spit file into sequence of each filepath component
    (fs/components $)
    ;; Drop first component, probably "src/" or "test/"
    (drop 1 $)
    ;; Turn list into a vector, stringifying everything
    (mapv str $)
    ;; Combine vector into string, each item separated by .
    ;; This is basically a namespace form
    (string/join "." $)
    ;; Clojure uses underscores in files but hyphens in namespaces
    (string/replace $ #"_" "-")
    ;;; Remove the ".clj" file extension, that's not in the namespace
    (string/replace $ #".clj$" "")
    ;; Convert into a symbok
    (symbol $)))

(def namespaces
  (->> (fs/glob "src" "**/*.clj")
       (mapv file->ns)))

(apply require namespaces)

(def test-results
  (apply t/run-tests namespaces))

(let [{:keys [fail error]} test-results]
  (when (pos? (+ fail error))
    (System/exit 1)))
