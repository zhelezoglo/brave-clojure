(defn dec-maker [x] #(- % x))

(def dec9 (dec-maker 9))
(println (dec9 10))

;(def dec9 (dec-maker 9))
;(dec9 10)
; => 1