(ns euler.pe007)

  (defn int? [n]
   (== n (int n)))

  (defn square-diff-sqrt [c n]
   (Math/sqrt (- (* c c) n)))

  (defn from [n]
   (iterate inc n))

  (defn ceil-sqrt [n]
   (int (Math/ceil (Math/sqrt n))))

  (defn prime? [n]
   (or (some #(= % n) [2 3 5 7 11 13])
    (and (every? #(not (zero? (rem n %))) [2 3 5 7 11 13])
     (let [
      seed (int (first (filter #(int? (square-diff-sqrt % n))
            (from (ceil-sqrt n)))))
      diff (int (square-diff-sqrt seed n))
      lhs  (- seed diff)
      rhs  (+ seed diff)]
      (= lhs 1)))))

  (defn primes []
   (filter #(prime? %) (iterate #(+ 2 %) 1)))

  (defn pe007 []
   (nth (primes) 10000))

