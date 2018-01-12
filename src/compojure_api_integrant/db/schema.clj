(ns compojure-api-integrant.db.schema
  (:require [schema.core :as s])

  (:import [org.bson.types ObjectId]))

(s/defschema Pizza
  {:name s/Str
   (s/optional-key :description) s/Str
   :size (s/enum :L :M :S)
   :origin {:country (s/enum :FI :PO)
            :city s/Str}})
