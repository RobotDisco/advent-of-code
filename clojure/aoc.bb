#!/usr/bin/env bb
;;;; A lot of the code and commentary in this file was built with code
;;;; assistance from TabNine (tabnine.com).

(defn unwritten-star-error
  "Print error message about undefined star function and exit."
  [year day star]
  ;; Temporarily remap standard error to standard out.
  (binding [*out* *err*]
    (println (format "ERROR: We haven't defined a solution for Year %d, Day %d, Star %d.

  Please define a 0-arity function defined as aoc.year%d.day%02d/star%d"
                     year day star year day star))))

(defn load-and-run
  "This function takes three integer arguments: 'year', 'day', and 'star'.

  It constructs a namespace/function name by joining them with hyphens and
  checks if the function exists in the corresponding namespace.  If the function
  exists, it evaluates and returns the result.  If the function does not exist,
  it throws an error."
  [year day star]
  ;; Generate symbols based on the provided year/day/star integer inputs
  (let [namespace-symbol (symbol (str "aoc.year" year ".day" (format "%02d"
                                                                     day)))
        function-name (case star
                        1 'star1
                        2 'star2
                        ;; TODO Should print special message for invalid 3+
                        ;; star choice.
                        nil)
        resolve-fn (try
                     ;; We need to load our classes, which will throw an
                     ;; exception if they haven't been defined.
                     (require namespace-symbol)
                     (ns-resolve namespace-symbol function-name)
                     (catch java.lang.Exception _e nil))]
    (if resolve-fn
      ;; Call function if it exists
      (resolve-fn)
      ;; Error out if function doesn't exist.
      (unwritten-star-error year day star))))

(defn -main [& args]
  (let [[year day star] (map #(Integer/parseInt %) args)
        result (load-and-run year day star)]
    ;; If we get back a result, assume we successfully ran something and return
    ;; with a status code of 0. Otherwise, return a non-zero error code.
    (if result
      (do
        (println result)
        (System/exit 0))
      (System/exit 1))))

;; By putting our entry point into -main, we allow REPL to call out function
;; If Babaskha's "babashka.file" property matches *file*, we know that we've
;; run this file from the shell, so invoke main.
;;
;; This is similar to Python's "if __name__ == "__main__" logic.
(when (= *file* (System/getProperty "babashka.file"))
  (apply -main *command-line-args*))
