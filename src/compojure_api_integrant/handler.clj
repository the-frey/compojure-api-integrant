(ns compojure-api-integrant.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [ring.adapter.jetty :as jetty]
            [integrant.core :as ig]
            [compojure-api-integrant.db.schema :as schema]))

(defn app [{:keys [db] :as opts}]
  (api
    {:swagger
     {:ui "/"
      :spec "/swagger.json"
      :data {:info {:title "Compojure-api-integrant"
                    :description "Compojure Api example"}
             :tags [{:name "api", :description "some apis"}]}}}

    (context "/api" []
      :tags ["api"]

      (GET "/plus" []
        :return {:result Long}
        :query-params [x :- Long, y :- Long]
        :summary "adds two numbers together"
        (ok {:result (+ x y)}))

      (POST "/echo" []
        :return schema/Pizza
        :body [pizza schema/Pizza]
        :summary "echoes a Pizza"
        (ok pizza)))))

(defmethod ig/init-key :handler/app [_ {:keys [db] :as opts}]
  (app opts))
