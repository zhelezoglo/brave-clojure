(defn my-map [f seq]
  (reverse (reduce #(into %1 [(f %2)]) '() seq)))


(println (my-map inc '(1 2 3 4 5)))