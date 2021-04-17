(ns lazy-api-consumption.core
  (:gen-class)
  (:require [clj-http.client :as http]
            [clojure.string :as str]))

(defn- fetch-lazy-jobs-seq!
  ([]
   (fetch-lazy-jobs-seq! 0))
  ([page]
   (let [jobs-url     (fn [page](format "https://jobs.github.com/positions.json?page=%d" page))
         {body :body} (http/get (jobs-url page) {:as :json})]
     (if (seq body)
       (lazy-cat body (fetch-lazy-jobs-seq! (inc page)))
       body))))



(defn -main []
  (println "Locations with clojure jobs:")
  (doseq [location (->> (fetch-lazy-jobs-seq!)
                         (filter #(str/includes? (:description %)"Clojure"))
                         (map :location)
                         (set))]
    (println location)
    ))
