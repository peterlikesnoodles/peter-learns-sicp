; ## Exercise 1.3
;
; Define a procedure that takes three numbers as arguments and returns the sum
; of the squares of the two larger numbers.

(defn smaller
       [x y]
       (if (> x y) y x))
(defn larger
      [x y]
      (if (> x y) x y))
(defn square-sum
      [x y]
      (+ (* x x)
         (* y y)))
(defn square-sum-of-larger-two-from-three
      [x y z]
      (square-sum (larger x y)
                  (larger (smaller x y) z)))
(print
  (square-sum-of-larger-two-from-three 20 30 40))

;(def (min x y)
;    (if (> x y) y x))
;)
;(def (max x y)
;    (if (> x y) x y))
;(def (square-sum x y)
;    (+ (* x x)
;        (* y y)))
;(def (result x y z)
;    (square-sum (max x y)
;        (max (min x y) z)))
