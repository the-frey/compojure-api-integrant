 (defproject compojure-api-integrant "0.1.0-SNAPSHOT"
   :description "Some defaults - remember to check the versions of deps, kids!"
   :dependencies [[org.clojure/clojure "1.8.0"]
                  [metosin/compojure-api "1.1.11"]
                  [cheshire "5.5.0"]
                  [ring "1.6.3"]
                  [ring/ring-mock "0.3.0"]
                  [com.novemberain/monger "3.1.0"]
                  [environ "1.1.0"]
                  [spootnik/constance "0.5.3"]
                  [clojure-future-spec "1.9.0-beta4"]
                  [integrant "0.6.2"]
                  [org.clojure/tools.logging "0.4.0"]]
   :ring {:handler compojure-api-integrant.handler/app}
   :uberjar-name "server.jar"
   :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]
                                   [integrant/repl "0.2.0"]]
                   :plugins [[lein-ring "0.12.0"]]
                   :source-paths ["env/dev/clj"]}})
