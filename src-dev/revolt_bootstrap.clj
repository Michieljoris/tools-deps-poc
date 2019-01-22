(ns revolt-bootstrap
  (:require
   [clojure.tools.cli :as cli]
   [revolt.bootstrap :as revolt]
   [revolt.plugins.nrepl-piggyback]))

(defn -main
  [& args]
  (let [params (:options (cli/parse-opts args revolt/cli-options))]
    (revolt/bootstrap params)))
