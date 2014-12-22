(ns anagrams.core
  (:gen-class))

(defn build-anagram
  "Builds the anagram of the given word."
  [word]
  (apply str (sort word)))

(defn char-counter 
  "Counts characters in a string."
  [str]
  (loop [counts {}
         s str]
    (if-not (empty? s)
      (let [c (first s)]
        (recur (assoc counts c (inc (get counts c 0)))
               (rest s)))
      counts)))

(defn -main
  "Builds and counts anagrams of the words in the wordlist.txt file."
  [& args]
  (println (clojure.string/split-lines (slurp "../wordlist.txt"))))
;  (with-open [r (clojure.java.io/reader "../wordlist.txt")]
;    (doseq [line (line-seq r)]
;      (println line (build-anagram line)))))
