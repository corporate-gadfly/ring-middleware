(defproject org.openvoxproject/ring-middleware "2.1.5-SNAPSHOT"

  ;; Generally, try to keep version pins in :managed-dependencies and the libraries
  ;; this project actually uses in :dependencies, inheriting the version from
  ;; :managed-dependencies. This prevents endless version conflicts due to deps of deps.
  ;; Renovate should keep the versions largely in sync between projects.
  :managed-dependencies [[org.clojure/clojure "1.12.4"]
                         [org.clojure/tools.logging "1.3.1"]
                         [org.clojure/tools.macro "0.2.2"]

                         [cheshire "5.13.0"]
                         [commons-codec "1.21.0"]
                         [compojure "1.7.2"]
                         [org.bouncycastle/bcpkix-jdk18on "1.83"]
                         [org.openvoxproject/http-client "2.2.5"]
                         [org.openvoxproject/kitchensink "3.5.5" :classifier "test" :scope "test"]
                         [org.openvoxproject/trapperkeeper "4.3.2" :classifier "test" :scope "test"]
                         [org.openvoxproject/trapperkeeper-webserver-jetty10 "1.1.4"]
                         [org.slf4j/slf4j-api "2.0.17"]
                         [ring/ring-codec "1.3.0"]
                         [ring/ring-core "1.14.2"]]

  :dependencies [[cheshire]
                 [org.openvoxproject/http-client]]

  :min-lein-version "2.9.1"

  :license {:name "Apache-2.0"
            :url "https://www.apache.org/licenses/LICENSE-2.0.txt"}

  ;; Abort when version ranges or version conflicts are detected in
  ;; dependencies. Also supports :warn to simply emit warnings.
  ;; requires lein 2.2.0+.
  :pedantic? :abort

  :plugins [[org.openvoxproject/i18n "1.0.3"]]

  :deploy-repositories [["releases" {:url "https://clojars.org/repo"
                                     :username :env/CLOJARS_USERNAME
                                     :password :env/CLOJARS_PASSWORD
                                     :sign-releases false}]]

  :profiles {:dev {:dependencies [[compojure]
                                  [org.bouncycastle/bcpkix-jdk18on]
                                  [org.openvoxproject/kitchensink :classifier "test" :scope "test"]
                                  [org.openvoxproject/trapperkeeper :classifier "test" :scope "test"]
                                  [org.openvoxproject/trapperkeeper-webserver-jetty10]]}})
