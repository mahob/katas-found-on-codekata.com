(ns kata06-anagrams-clojure.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (with-open [r (clojure.java.io/reader "stuff.txt")]
   (doseq [line (line-seq r)]
    (println line))))
