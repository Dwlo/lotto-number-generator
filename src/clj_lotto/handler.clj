(ns clj-lotto.handler
  (:require [clj-lotto.core       :as c]
            [compojure
             [core                :refer :all]
             [handler             :as handler]
             [route               :as route]]
            [ring.adapter.jetty   :as jt]
            [ring.middleware.json :as json-mdlw]
            [ring.util.response   :refer [resource-response response]]))

(defn init []
  (println "*** ============================ ***")
  (println " **     CLJ-LOTTO IS STARTING    **")
  (println "  * ============================ *"))

(defn destroy []
  (println "*** ============================ ***")
  (println " **     CLJ-LOTTO IS STOPING!    **")
  (println "  * ============================ *"))

(defroutes app-routes
  (GET "/" [] (response {:nessage "Welcom to the clj-lotto website"
                         :version 1}))
  (GET "/euro-millions" [] (response (c/get-euro-million-card)))
  (GET "/lotto"         [] (response (c/get-lotto-card)))
  (route/not-found "Not Found"))

(def app (json-mdlw/wrap-json-response (handler/site app-routes) {:pretty true}))
