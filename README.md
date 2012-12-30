# math.prime

A Clojure library that implements the sieve of Eratosthenes.

+ https://clojars.org/org.clojars.tnoda/tnoda.math.prime
+ https://github.com/tnoda/tnoda.math.prime


## Dependency Information

Leiningen dependency information:

    [org.clojars.tnoda/tnoda.math.prime "0.2.1"]


## Example

    user> (use 'tnoda.math.prime)
    nil
    
    user> (time (sieve))
    "Elapsed time: 30.89 msecs"
    (2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 ...)
    
    user> (count (sieve))
    78498
    
    user> (binding [*sieve-size* 1000000] (count (sieve)))
    78498
    
    user> (binding [*sieve-size* 10000000] (count (sieve)))
    664579


## License

Copyright © 2012 Takahiro Noda

Distributed under the Eclipse Public License, the same as Clojure.
