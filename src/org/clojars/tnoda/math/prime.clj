(ns org.clojars.tnoda.math.prime)

(def ^:dynamic *sieve-size* 1000000)

(def ^:dynamic *prime-array* nil)

(defn sieve*
  "Returns an array of primes below *sieve-size*."
  []
  (let [n (long *sieve-size*)
        not-prime (doto (boolean-array n)
                    (aset 0 true)
                    (aset 1 true))
        primes (long-array n)]
    (loop [p 0, i 2]
      (if (< i n)
        (if (aget not-prime i)
          (recur p (inc i))
          (do
            (aset primes p i)
            (loop [j (* 2 i)]
              (when (< j n)
                (aset not-prime j true)
                (recur (+ j i))))
            (recur (inc p) (inc i))))
        (let [ps (long-array p)]
          (System/arraycopy primes 0 ps 0 p)
          ps)))))

(defn sieve
  "Returns a seq of primes below *sieve-size*."
  []
  (seq (sieve*)))

(defn prime-factors*
  "Experimental - returns a seq of the prime factors of x in an
  ascending order."
  [^long x]
  (let [ps (or *prime-array* (sieve*))
        fs (long-array 30)]
    (loop [n x, i 0, j 0]
      (let [p (aget ^longs ps i)]
        (if (< x (* p p))
          (if (< 1 n)
            (do
              (aset fs j n)
              (recur 0 i (inc j)))
            (take j fs))
          (if (zero? (rem n p))
            (do
              (aset fs j p)
              (recur (quot n p) i (inc j)))
            (recur n (inc i) j)))))))

(defn prime-factors
  [^long x]
  "Experimental - returns a map of the prime factors of x, whose
  key/value pairs express x in powers. x equals the product of the
  key to the value."
  (->> (prime-factors* x)
       frequencies))
