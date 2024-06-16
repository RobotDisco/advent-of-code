(ns aoc.core
  (:require [clojure.edn :as edn]
            [babashka.curl :as http]
            [clojure.java.io :as io]))

(defn load-config
  "Load and parse standard configuration file, returning a structure."
  []
  (-> "config.edn"
      io/file
      slurp
      edn/read-string))


(def config
  "Our program's configuration structure."
  (load-config))

(def session
  "Session id passed to Advent of Code servers as a cookie as authentication."
  (:session config))

(defn data
  "Return the body of our HTTP request, if the call was successful"
  [input]
  (when-let [data (:data input)]
    data))

(defn error
  "Return the error message of our HTTP request, if call was unsuccessful."
  [input]
  (when-let [error (:message input)]
    error))

(defn fetch-input
  "Retrieve input for requested year and day from advent of code servers.

  Implicitly takes in a global session variable."
  [year day]
  (let [url (format "https://adventofcode.com/%d/day/%d/input" year day)
        headers {"Cookie" (format "session=%s" session)}
        response (http/get url {:throw false
                                :headers headers})
        status (:status response)]
    (if (= status 200)
      {:status :success
       :data (:body response)}
      {:status :error
       :message (format "Could not fetch AOC question input. Is your :session value in config.edn correct?")})))
