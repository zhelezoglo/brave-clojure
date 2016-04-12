(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "1-eye" :size 1}
                             {:name "1-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "1-shoulder" :size 3}
                             {:name "1-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "1-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "1-kidney" :size 1}
                             {:name "1-hand" :size 2}
                             {:name "1-knee" :size 2}
                             {:name "1-thigh" :size 4}
                             {:name "1-lower-leg" :size 3}
                             {:name "1-achilles" :size 1}
                             {:name "1-foot" :size 2}])

(defn matching-part
  [part i]
  {:name (clojure.string/replace (:name part) #"^1-" (str i "-"))
   :size (:size part)})

(defn matching-parts [part i]
  (loop [j i, result #{}]
    (if (< j 2)
      result
      (recur (dec j) (conj result (matching-part part j))))))

;(defn matching-parts [part i]
;  (if (< i 2)
;    #{}
;    (conj (matching-parts part (- i 1)) (matching-part part i))))

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size, and a number matching body parts"
  [asym-body-parts n]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts (set (cons part (matching-parts part n)))))))))

(def result (symmetrize-body-parts asym-hobbit-body-parts 5))
;(println result)

(def prettyResult (map #(str % "\n") result))
(println prettyResult)
