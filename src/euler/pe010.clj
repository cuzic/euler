(ns euler.pe010)

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


  (defn make-sieve [n]
   (let [m     (* n n)
    sieve (make-array Boolean/TYPE m)]
    (aset sieve 0 true)
    (aset sieve 1 true)
    (letfn [(each-prime [n]
            (if (= n 2) [n]
             (let [sieve (make-sieve (+ 1 (int (Math/sqrt n))))]
              (filter #(false? (aget sieve %)) (range 0 n)))))]
     (doseq [i (each-prime n)]
      (doseq [j (range (* i i) m i)]
       (aset sieve j true)))
     sieve)))

  (defn sum-prime [limit]
   (let [n     (+ 1 (int (Math/sqrt limit)))
    sieve (make-sieve n)]
    (apply + (filter #(not (aget sieve %)) (range 0 limit)))))

  (defn pe010 []
   (sum-prime 2000000))

