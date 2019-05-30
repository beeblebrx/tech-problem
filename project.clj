(defproject tech-problem "1.0.0"
  :description "I was asked to solve a little problem..."
  :url "http://example.com/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot tech-problem.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
