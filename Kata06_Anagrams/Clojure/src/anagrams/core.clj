(ns anagrams.core
  (:gen-class))

(defn build-anagram
  "Builds the anagram of the given word."
  [word]
  (apply str (sort word)))

(defn add-anagram
  "Adds an anagram to the table of anagrams."
  [anagram]
  (1))

(defn -main
  "Builds and counts anagrams of the words in the wordlist.txt file."
  [& args]
  (with-open [r (clojure.java.io/reader "../wordlist.txt")]
    (doseq [line (line-seq r)]
      (println line (build-anagram line)))))
