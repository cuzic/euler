(ns euler.pe012)

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

(defn triangle-number [n]
 (/ (* n (+ n 1)) 2))

(defn each-triangle-numbers []
 (map triangle-number (iterate inc 2)))

(defn divisors-count [n]
 (let [prime-factors (factorize n)]
  (reduce * (map #(inc (count %))
             (partition-by identity prime-factors)))))

  (defn trinum-where-divsors-over [n]
   (first (drop-while #(< (second %) 500)
           (map #(list % (divisors-count %))
            (each-triangle-numbers)))))

  (defn pe012 [& args]
   (trinum-where-divsors-over 500))


