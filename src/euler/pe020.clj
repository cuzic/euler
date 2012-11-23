(ns euler.pe020)

(defn big [n]
 (BigInteger. (str n)))

(defn factorial [n]
 (reduce * (range (big 1) (inc (big n)))))

(defn sum-of-digits [n]
 (reduce + (map #(Integer/parseInt (str %)) (str n))))

(defn pe020 []
 (sum-of-digits (factorial 100)))

