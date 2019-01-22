# Run in dev mode

    clj -A:dev:slf4j -p watch,nrepl-piggyback,figwheel,rebel -t clean,sass,test

# Uberjar

    clj -A:uberjar
    java -jar target/tools-deps-tryout-0.1.0-standalone.jar 

# graalvm native-image
     -A:native-image --graalvm-home ~/opt/graalvm
