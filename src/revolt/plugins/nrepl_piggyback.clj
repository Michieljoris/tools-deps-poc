(ns ^{:clojure.tools.namespace.repl/load false} revolt.plugins.nrepl-piggyback
  (:require [cider.nrepl]
            [io.aviso.ansi]
            [nrepl.server :as server]
            [clojure.tools.logging :as log]
            [refactor-nrepl.middleware :as refactor.nrepl]
            [cider.piggieback :as pback]
            [revolt.plugin :refer [Plugin create-plugin]]))

(defn init-plugin
  "Initializes nREPL plugin."

  [config]
  (reify Plugin
    (activate [this ctx]
      (log/debug "Starting nREPL server (with piggyback, cider and refactor middleware)")

      (let [handler (apply server/default-handler
                           (conj (map #'cider.nrepl/resolve-or-fail cider.nrepl/cider-middleware)
                                 #'refactor.nrepl/wrap-refactor
                                 #'pback/wrap-cljs-repl))
            server (server/start-server
                    :port (:port config)
                    :handler handler)]

        (spit ".nrepl-port" (:port server))
        (println (io.aviso.ansi/yellow (str "nREPL client can be connected to port " (:port server))))
        server))

    (deactivate [this ret]
      (when ret
        (log/debug "closing nrepl")
        (nrepl.server/stop-server ret)))))

(defmethod create-plugin :revolt.plugin/nrepl-piggyback [_ config]
  (init-plugin config))
