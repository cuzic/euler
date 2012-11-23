(ns euler.pe014)

(def memo-length 3000000)
(def memo (make-array Short/TYPE memo-length))
(aset memo 1 (short 1))

(defn collatz
  ([n] (collatz '() (long n) (int 0)))
  ([breadcrumb n i]
   (let
    [n (long n) i (int i)]
    (if (and (< n memo-length) (< 0 (aget memo n)))
     (let [m (aget memo n)]
      (do
       (doseq [a (map #(list %1 %2) breadcrumb (iterate inc 1))]
        (if (< (first a) memo-length)
         (aset memo (first a) (short (+ m (second a))))))
       (+ m i)))
     (let [next (if (even? n) (/ n 2) (inc (* n 3)))]
      (recur (cons n breadcrumb) next (inc i)))))))

(defn collatz-pair [n]
 [n (collatz n)])

(defn bigger [x y]
  (let
   [x1 (nth x 1) y1 (nth y 1)]
   (if (< x1 y1) y x)))

(defn pe014 []
 (first (reduce bigger 
       (map collatz-pair (range 2 1000000)))))

