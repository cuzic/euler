(ns euler.pe002)

(defn fib-seq []
   ((fn rfib [a b]
     (lazy-seq (cons a (rfib b (+ a b)))))
    0 1))

(defn pe002 []
 (apply + (filter even? (take-while #(< % 4000000) (fib-seq))))
 )

