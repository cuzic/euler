(ns euler.pe009)

(defn pythagorean? [a b c]
 (= (+ (* a a) (* b b)) (* c c)))

  (defn pythagorean-filter [n]
   (filter #(apply pythagorean? %)
    (for [a (range 1 (/ n 3)) b (range a n) ] [a b (- n a b)] )))

  (defn multiply-1000 []
   (reduce * (first (pythagorean-filter 1000))))

  (defn pe009 []
   (multiply-1000)
  )

