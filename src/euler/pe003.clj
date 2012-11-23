(ns euler.pe003)

(defn int? [n]
 (or (integer? n) (== (- n (int n)) 0)))

(defn square-diff-sqrt [c n]
 (Math/sqrt (- (* c c) n)))

(defn from [n]
 (iterate inc n))

(defn ceil-sqrt [n]
 (int (Math/ceil (Math/sqrt n))))

(defn factorize [n]
 (let
  [seed (int (first (filter #(int? (square-diff-sqrt % n))
        (from (ceil-sqrt n)))))
  diff (int (square-diff-sqrt seed n))
  lhs  (- seed diff)
  rhs  (+ seed diff)]
  (if (= lhs 1) [rhs] (sort (concat (factorize lhs) (factorize rhs))))))

(defn pe003 []
 (reduce max (factorize 600851475143)))

