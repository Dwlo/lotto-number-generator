(defproject clj-lotto "0.1.0-SNAPSHOT"
  :description "A Clojure application intended for generation of lotto's numbers."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure     "1.7.0"]
                 [compojure               "1.1.8"]
                 [ring/ring-json          "0.3.1"]
                 [ring/ring-core          "1.4.0"]
                 [refactor-nrepl          "1.1.0"]
                 [lein-ring               "0.9.6"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [com.draines/postal      "1.11.3"]]
  :plugins      [[lein-ring               "0.8.11"]]
  :ring         {:handler clj-lotto.handler/app
                 :init    clj-lotto.handler/init
                 :destroy clj-lotto.handler/destroy})
