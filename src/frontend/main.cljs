(ns ^:figweel-load frontend.main
  (:require ;; [weasel.repl :as repl]
    [components.material-ui]
   )
  )

;;TODO: find way to exclude weasel from prod
;; (when-not (repl/alive?)
;;   (repl/connect "ws://localhost:9001"))

;; (set! *warn-on-infer* true)

(enable-console-print!)

(println "Hello from frontend.main!!!! again!! bla foo ok ok")

(defn main! [& args]
  (println "In main! in frontend.main!! "))

;; (js/console.log "Foo" create-element)
