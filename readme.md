# Run in dev mode

    clj -A:revolt:dev:nrepl:cljs:slf4j -p watch,nrepl-piggyback,figwheel,rebel -t clean,sass,test
    
or

    bin/dev
    

# Uberjar

    clj -A:revolt:pack:cljs:slf4j: -t clean,info,sass,cljs:compiler.optimizations=advanced,capsule
    java -jar dist/app.jar
    
or 
   
    bin/prod
    
# graalvm native-image

      -A:native-image --graalvm-home ~/opt/graalvm


# Run shadow-cljs and revolt together

This will run the backend server and compile scss:

    clj -A:revolt:dev:slf4j -p watch,rebel -t sass
    
The app's backend serves at http://localhost:333/index.html
    
This will compile cljs:
 
    shadow-cljs watch main
    
 And shadow-cljs also serves the app at http://localhost:9001 with a bare ring server.
 
# cljs repl

Connect to the nrepl server from the editor. Then (user/cljs-repl) in when using
revolt only. If also using shadow-cljs then https://shadow-cljs.github.io/docs/UsersGuide.html#_connect_the_javascript_environment

# webpack

See entries under :revolt.task/cljs.foreign-libs in revolt.edn,
webpack.config.js and src/js/index.js. 

    npm install
    npx webpack
 
# TODO

- Using a (private?) git repo seems to not go down well with capsule task
;; ERROR | Error while creating a jar file: Some of dependecies have no :mvn/version assigned!
;;Perhaps it's needs a deps.edn?

- Exclude weasel from js prod build somehow
