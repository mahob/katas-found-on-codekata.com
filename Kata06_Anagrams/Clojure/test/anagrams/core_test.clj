(ns anagrams.core-test
  (:require [clojure.test :refer :all]
            [anagrams.core :refer :all]))

(deftest build-anagram-test
  (testing "anagrams.core build-anagram"
           (is (= (build-anagram "hello") "ehllo"))))

(deftest file-lines-test
  (testing "anagrams.core file-lines"
           (is (= (file-lines "test/resources/small-wordlist.txt") ["lady" "gaga"] ))))

(deftest anagrams-from-file-test
  (testing "basic anagram counting"
    (is (= (anagrams-from-file "test/resources/medium-wordlist.txt") {"abz" ["baz"], "abr" ["bar" "rab"], "foo" ["foo" "ofo" "oof"]}))))