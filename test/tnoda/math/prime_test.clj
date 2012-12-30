(ns tnoda.math.prime-test
  (:use clojure.test
        tnoda.math.prime))

(deftest test-math-prime
  (testing "sieve"
    (is (= [2 3 5 7 11 13]
           (take 6 (sieve)))))
  (testing "prime-factorization"
    (is (= [2 2 3 3]
           (prime-factorization 36))))
  (testing "prime-factors"
    (is (= {2 2 3 2}
           (prime-factors 36)))))
