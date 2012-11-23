(ns euler.pe005)

  (defn int? [n]
   (or (integer? n) (== (- n (int n)) 0)))

  (defn square-diff-sqrt [c n]
   (Math/sqrt (- (* c c) n)))

  (defn ceil-sqrt [n]
   (int (Math/ceil (Math/sqrt n))))

  (defn from [n]
   (iterate inc n))

  (defn prime? [n]
   (let
    [seed (int (first (filter #(int? (square-diff-sqrt % n))
          (from (ceil-sqrt n)))))
    diff (int (square-diff-sqrt seed n))
    lhs  (- seed diff)
    rhs  (+ seed diff)]
    (= lhs 1)))

  (defn primes [n]
   (filter #(prime? %) (range 3 n 2)))

  (defn evenly-divisible? [candidate n]
   (every? #(zero? (rem candidate %)) (range 2 n)))

  (defn minimum-candidate [n]
   (* 3 (reduce * (vec (primes n)))))

  (defn solve [n]
   (first (filter #(evenly-divisible? % n) (iterate #(* % 2) (minimum-candidate n)))))

  (defn pe005 []
   (solve 20))

