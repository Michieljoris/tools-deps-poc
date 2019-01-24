(ns ^:figweel-load frontend.main
  (:require
   [weasel.repl :as repl]
   [react :as react]
   [react-dom :as react-dom]
   [frontend.components.material-ui :as ui]
   ))

;;TODO: find way to exclude weasel from prod
(when-not (repl/alive?)
  (repl/connect "ws://localhost:9001"))

(set! *warn-on-infer* true)

(enable-console-print!)

(defn main! [& args]
  (println "In main! in frontend.main!! "))

(def mount (js/document.getElementById "container"))

(def el (ui/mui-theme-provider
         {:mui-theme (ui/get-mui-theme)}
         (ui/raised-button {:label "Hello world"})))

(react-dom/render el mount)
