(ns euler.pe021)

  (defn factorize-odd [n]
   (letfn [
    (int? [n]
     (== n (int n)))
    (square-diff-sqrt [c n]
     (Math/sqrt (- (* c c) n)))
    (from [n]
     (iterate inc n))
    (ceil-sqrt [n]
     (int (Math/ceil (Math/sqrt n))))]
    (let
     [seed (int (first (filter #(int? (square-diff-sqrt % n))
           (from (ceil-sqrt n)))))
     diff (int (square-diff-sqrt seed n))
     lhs  (- seed diff)
     rhs  (+ seed diff)]
     (if (= lhs 1) [rhs]
      (sort (concat (factorize-odd lhs) (factorize-odd rhs)))))))

  (defn factorize [n]
   (cond
    (even? n) (concat [2] (factorize (/ n 2)))
    (= n 1)   []
    :else     (factorize-odd n)))

 (defn combination
  ([num-list] (combination [] num-list))
  ([prefix num-list]
    (if (= (count num-list) 1)
      (for [a (first num-list)]
       (conj prefix a))
     (apply concat
      (for [a (first num-list)]
       (combination (conj prefix a) (rest num-list)))))))

 (defn identity-partition [l]
  (partition-by identity l))

 (defn factors [n]
  (map #(list (first %) (count %))
   (identity-partition (factorize n))))

 (defn factor-pow [prime r]
  (take (inc r) (iterate (partial * prime) 1)))

 (defn factor-pows [n]
  (map #(factor-pow (first %) (second %)) (factors n)))

 (defn factor-combis [n]
  (combination (factor-pows n)))

 (defn divisors [n]
   (pop (mapv #(reduce * %) (factor-combis n))))

 (defn sum-of-divisors- [n]
  (if (= n 1) 1
   (reduce + (divisors n))))

 (def sum-of-divisors (memoize sum-of-divisors-))

 (defn amicable? [n]
  (let [sum-div (sum-of-divisors n)]
    (and (= n (sum-of-divisors sum-div))
      (not= n sum-div))))

 (defn pe021 []
  (reduce +
    (filter amicable? 
     (range 6 10000))))

