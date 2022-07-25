;; Exercise 1.11
;; A function f is defined by the rule that f(n)=n if n<3 and f(n)=f(n-1)+2f(n-2)+3f(n-3)
;; if n >= 3. Write a procedure that computes f by means of a recursive process.
;; Write a procedure that computes f by means of an iterative process.

(defn f
  [n]
  (cond (< n 3) n
    :else (+ (f (- n 1))
             (* 2 (f (- n 2)))
             (* 3 (f (- n 3))))))

(println
  "recursive process for f(n)=f(n-1)+2f(n-2)+3f(n-3)")

(println "f(1)" (f 1))
(println "f(2)" (f 2))
(println "f(3)" (f 3))
(println "f(4)" (f 4))
(println "f(5)" (f 5))

;; TODO: how to use local var?
(defn f-iter
  [n]
  (def first 1)
  (def second 2)
  (def third 3)
  (cond (< n 3) n))

