# Run in dev mode

    clj -A:revolt:dev:cljs:slf4j -p watch,nrepl-piggyback,figwheel,rebel -t clean,sass,test

# Uberjar

    clj -A:revolt:pack:cljs:slf4j: -t clean,info,sass,cljs:compiler.optimizations=advanced,capsule
    java -jar dist/app.jar

# graalvm native-image
     -A:native-image --graalvm-home ~/opt/graalvm


# TODO

- Using a (private?) git repo seems to not go down well with capsule task
;; ERROR | Error while creating a jar file: Some of dependecies have no :mvn/version assigned!
;;Perhaps it's needs a deps.edn?

- Exclude weasel from js prod build somehow
