(ns anagrams.core-test
  (:require [clojure.test :refer :all]
            [anagrams.core :refer :all]))

(deftest build-anagram-test
  (testing "anagrams.core build-anagram"
     (is (= (build-anagram "hello") "ehllo"))))

;(deftest add-anagram-test
;  (testing "anagrams.core add-anagram"
 ;    (is (= (add-anagram "ehllo") 1))))

;(deftest anagram-counter-test
;  (testing "basic anagram conting"
;    (is (= (anagram-counter "ab\nba") {"ab" ["ab" "ba"]}))))

(deftest char-counter-test
  (testing "counting chars"
           (is (= (char-counter "bab") {\a 1, \b 2}))))