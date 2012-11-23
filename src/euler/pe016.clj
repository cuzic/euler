(ns euler.pe016)

  (defn power-of-two [n]
   (nth (iterate (memoize (partial * 2)) BigInteger/ONE) n))

  (defn digits [n]
   (map #(Character/getNumericValue %) (str n)))

  (defn pe016 []
   (reduce + (digits (power-of-two 1000))))

