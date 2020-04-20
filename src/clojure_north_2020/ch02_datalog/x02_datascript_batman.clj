(ns clojure-north-2020.ch02-datalog.x02-datascript-batman
  (:require [datascript.core :as d]
            [clojure-north-2020.ch01-data.x01-data :refer [data]]
            [clojure-north-2020.ch02-datalog.x01-schemas :as schemas]))

;; ## A Simple Example
;; Here we describe a single entity, Batman.
;;
;; Evaluate this form in the REPL. How many entities are created?
;;
;; Note that this db is a value - it has not state.
(d/db-with
  (d/empty-db schemas/datascript-schema)
  data)

;; A stateful connection backed by an atom.
(defonce conn (d/create-conn schemas/datascript-schema))
(d/transact conn data)
(d/transact conn [{:name "Joker"
                   :alignment "Chaotic Evil"}
                  {:name "Penguin"
                   :alignment "Neutral Evil"}])

