(ns euler.pe001)

(defn pe001 []
   (apply +
    (filter #(or (= (mod % 5) 0) (=( mod % 3) 0))
     (range 1 1000))))

