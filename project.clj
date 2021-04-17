(defproject lazy-api-consumption-example "0.1.0-SNAPSHOT"
  :description "Example on how to consume a HTTP API in a lazy manner"
  :url "https://github.com/carlduevel/lazy-api-consumption-example"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [cheshire "5.10.0"]
                 [clj-http "3.12.0"]]
  :main ^:skip-aot lazy-api-consumption.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
