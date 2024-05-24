#!/usr/bin/env bb

(defn fnord [year day star]
  (println "We haven't defined a solution for Year"
           year
           ", Day"
           day
           ", Star"
           star
           "yet!"))

(defn -main [& args]
  (let [[year day star] args]
    (fnord year day star)))

(when (= *file* (System/getProperty "babashka.file"))
  (apply -main *command-line-args*))
