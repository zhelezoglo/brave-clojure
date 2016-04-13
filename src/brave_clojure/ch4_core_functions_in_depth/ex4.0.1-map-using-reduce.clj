(defn my-map [f seq]
  (reverse (reduce #(cons (f %2) %1) '() seq)))


(println (my-map inc '(1 2 3 4 5)))