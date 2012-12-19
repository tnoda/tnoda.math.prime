(ns .org.clojars.tnoda.math.prime-test
  (:use clojure.test
        org.clojars.tnoda.math.prime))

(deftest test-math-prime
  (testing "sieve"
    (is (= [2 3 5 7 11 13]
           (take 6 (sieve)))))
  (testing "prime-factors"
    (is (= {2 2 3 2}
           (prime-factors 36)))))
