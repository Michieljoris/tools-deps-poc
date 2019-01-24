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

NOTE: checkout shadow-cljs branch. 

Resolving require by shadow-cljs is fundamentally different. It looks for js
index.js files in the same name named node_modules subdir. So (:require [react])
will resolve to node_modules/react/index.js. for a subdir in the npm module dir
you will have to quote the namespace, so: (:require ["material-ui/styles"]).
Since it tries to resolve symbol namespaces (not just string namespaces) to the
node_modules dir this makes it incompatible with regular (closure) resolution
and compilation, using foreign-libs. Which is the real showstopper because
shadow-cljs does not honour the compiler :foreign-libs opt. So it's not possible
to keep both open and postpone the choice. And see which tool works better,
native and figwheel or shadow-cljs.

Since shadow-cljs might not live beyond a few years this would make all code
incompatible in the long run, unless the shadow-cljs resolution method gets
officially adopted. You'd have to add all foreign libs again. Including externs.
Native tooling by cognitect is getting better and better, which will make
shadow-cljs obsolete, but you might end up stuck with uncompilable code. Otoh
using normal compilation I had no trouble adding material-ui and react. Another
thing, I get, even in the simplest app stack overflow errors on reload :-(. You
would have to debug another tool to fix this.

This will run the backend server and compile scss:

    clj -A:revolt:nrepl:dev:slf4j -p watch,rebel -t sass
    
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
