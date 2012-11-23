(ns euler.pe004)

(defn palindrome? [n]
 (let [s (seq (str n))]
  (= s (reverse s))))

(defn palindrome [n]
 (let [products
  (for [a (range 100 n)
   b (range 100 a)]
   (* a b))]
  (filter palindrome? products)))

(defn pe004 [& args]
 (reduce max (palindrome 999)))

