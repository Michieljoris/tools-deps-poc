(ns core
  (:gen-class)
  (:require
   [org.httpkit.server :refer [run-server]]
   [ring.middleware.resource :refer [wrap-resource]]
   [ring.middleware.content-type :refer [wrap-content-type]]
   [ring.middleware.not-modified :refer [wrap-not-modified]]
   ;; [ring.middleware.logger :as logger]
   ;; [ring.middleware.file :refer [wrap-file]]
   ;; [digicheck.common.util :as du]

   [taoensso.timbre :as timbre]
   [clj-time.core :as t]
   [clj-time.format :as f]
   ;; [clojure.java.io :as io]
   ))

;; (timbre/set-level! :info)
;; (timbre/info "Hello from core!!!")

(defn time-str
  "Returns a string representation of a datetime in the local time zone."
  [dt]
  (f/unparse
   (f/with-zone (f/formatter "hh:mm aa") (t/default-time-zone))
   dt))

(defn default-handler [request]
  {:status 404
   :headers {"Content-Type" "text/plain"}
   :body "Default handler"})

(def options {:port 3333})

(def handler
  (-> default-handler
      ;;(wrap-file "/home/mj/tmp")
      (wrap-resource "/public")
      (wrap-content-type)
      (wrap-not-modified)
      ;; (logger/wrap-with-logger
      ;;  :info  (fn [x] (println x))
       ;; :debug (fn [x] (/debug x))
       ;; :error (fn [x] (/error x))
       ;; :warn  (fn [x] (/warn x))
       ))

(defn -main []
  (println "hello with server")
  ;; (println "Hello world, the time is" (time-str (t/now)))
  ;; (println (du/includes? [1 2 3] 1))
  (timbre/info "Hello from timbre!!")
  (run-server handler options)
  )


;; (serve!)
;; (defn -main [& args]
;;   (println "Hello World!"))

