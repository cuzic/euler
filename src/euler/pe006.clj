(ns euler.pe006)

(defn sum-of-squares [n]
 (reduce + (map #(* % %) (range 1 n))))

(defn square-of-sum [n]
 (let [sum (reduce + (range 1 n))]
  (* sum sum)))

(defn diff [n]
 (- (square-of-sum n) (sum-of-squares n)))

(defn pe006 []
 (diff 101))
