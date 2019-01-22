(ns user
  (:require  [weasel.repl.websocket]
             [cider.piggieback]
             [core :as core]))

(def foo 123)

(def weasel-repl-env (weasel.repl.websocket/repl-env :ip "0.0.0.0" :port 9001))

(defn cljs-repl []
  (cider.piggieback/cljs-repl weasel-repl-env))

(core/serve!)
