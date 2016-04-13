(defn my-filter [predicate seq]
  (reverse
    (reduce #(if (predicate %2) (cons %2 %1) %1)
            '()
            seq)))


(println (my-filter #(> % 3) [1 2 3 4 5]))
(println (my-filter #(not= (mod % 2) 0) [1 2 3 4 5]))