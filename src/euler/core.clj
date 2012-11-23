(ns euler.core
 (:gen-class))

(defn -main [arg]
  (do 
   (use (symbol (str "euler." arg)))
   (println (load-string (str "(" arg ")")))))

