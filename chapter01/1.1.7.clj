;; Square Roots by Newton's Method
;; Guess    Quotient    Average
;; 1        2/1         (2+1)/2=1.5
;; 1.5      2/1.5=1.33  (1.33+1.5)/2=1.4167

(defn sicp-average
  [x y]
  (/ (+ x y) 2))

(println "average of 2 and 3:" (float (sicp-average 2 3)))

(defn good-enough
  [guess target precision]
  (and
    (< (- guess target) precision)
    (> (- guess target) (- 0 precision))))

(println "3-4 within 1.5?" (good-enough 3 4 1.5))
(println "3-5 within 1.5?" (good-enough 3 5 1.5))

(defn good-enough-thousandth
  [guess target]
  (good-enough guess target 0.001))

(println "3-4 within 0.001?" (good-enough-thousandth 3 4))
(println "3-3.0001 within 0.001?" (good-enough-thousandth 3 3.0001))

(defn square-root-newton-with-guess
  [guess x]
  (if (good-enough-thousandth (* guess guess) x)
    guess
    (square-root-newton-with-guess
      (sicp-average
        guess
        (/ x guess))
      x)))

(defn square-root-newton
  [x]
  (square-root-newton-with-guess 1 x))

(println "square root of 4:" (float(square-root-newton 4)))
(println "square root of 5:" (float(square-root-newton 5)))
(println "square root of 6:" (float(square-root-newton 6)))
