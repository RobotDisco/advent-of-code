#!/usr/bin/env bb

(defn -main [& args]
  (println "Hello World!") args)

(when (= *file* (System/getProperty "babashka.file"))
  (apply -main *command-line-args*))
