(ns user
  (:require [integrant.repl :refer [clear go halt init reset reset-all prep]]
            [integrant.core :as ig]
            [environ.core :as env]
            [compojure-api-integrant.core]))

(integrant.repl/set-prep! (constantly (ig/read-string (slurp "config.edn"))))
