(ns anagrams.core
  (:gen-class))

(defn build-anagram
  "Builds the anagram of the given word."
  [word]
  (apply str (sort word)))

(defn file-lines
  "Splits all lines of with thegiven filename"
  [filename]
  (clojure.string/split-lines (slurp filename)))

(defn anagrams-from-file
  ""
  [filename]
  (loop [anagrams {}
         wordlist (file-lines filename)]
    (if-not (empty? wordlist)
      (let [word (first wordlist)]
        (let [anagram (build-anagram word)]
          (recur (assoc anagrams anagram (sort (conj (get anagrams anagram []) word)))
                 (rest wordlist))))
    anagrams)))

(defn -main
  "Builds and counts anagrams of the words in the wordlist.txt file."
  [& args]
  (println (anagrams-from-file "test/resources/medium-wordlist.txt")))