(ns euler.pe018
 (:import (java.io BufferedReader FileReader)))

(defn open-file-line-seq [filename]
 (with-open [rdr (BufferedReader. (FileReader. filename))]
  (doall (line-seq rdr))))

(defn parse-line [line]
 (map #(Integer/parseInt %) (clojure.string/split line #" ")))

(defn triangle []
 (map parse-line (open-file-line-seq "data/pe018.txt")))

(defn bigger [a b]
 (if (< a b) b a))

  (defn bigger-weights [weights]
   (map #(bigger (first %) (second %))
    (partition 2 1 (vec (flatten (list 0 weights 0))))))

  (defn step [weights lines]
   (map + (bigger-weights weights) lines))

  (defn weights [tri]
   (reduce step tri))

  (defn pe018 []
    (reduce bigger (weights (triangle))))


