(ns anagrams.core-test
  (:require [clojure.test :refer :all]
            [anagrams.core :refer :all]))

(deftest build-anagram-test
  (testing "anagrams.core build-anagram"
     (is (= (build-anagram "hello") "ehllo"))))

(deftest add-anagram-test
  (testing "anagrams.core add-anagram"
     (is (= (add-anagram "ehllo") 1))))
