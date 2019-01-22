# Run in dev mode

    clj -A:revolt:dev:cljs:slf4j -p watch,nrepl-piggyback,figwheel,rebel -t clean,sass,test

# Uberjar

    clj -A:revolt:pack:cljs:slf4j: -t clean,info,sass,cljs:compiler.optimizations=advanced,capsule
    java -jar dist/app.jar

# graalvm native-image
     -A:native-image --graalvm-home ~/opt/graalvm
