(ns euler.pe015)

(defn big [n]
 (BigInteger. (str n)))

(defn bigrange [begin end]
 (range (big begin) (big (inc end))))

  (defn combination [n r]
   (let [diff (- n r)
    bigger (if (> diff r) diff r)
    smaller (if (< diff r) diff r)
    ]
    (/ (reduce * (bigrange (inc bigger) n))
     (reduce * (bigrange 1 smaller)))))

  (defn pe015 []
   (combination 40 20))

