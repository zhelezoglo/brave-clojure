(defn mapset [f xs] (map f (set xs)))

(println (mapset inc [1 1 2 2]))