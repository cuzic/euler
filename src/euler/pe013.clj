(ns euler.pe013
 (:import (java.io BufferedReader FileReader)))

(defn open-file-line-seq [file-name]
 (with-open [rdr (BufferedReader. (FileReader. "data/pe013.txt"))]
  (doall (line-seq rdr))))

  (defn pe013 []
   (subs (str (reduce + (map #(Long/parseLong (subs % 0 13))
                         (open-file-line-seq "data.txt")))) 0 10))


