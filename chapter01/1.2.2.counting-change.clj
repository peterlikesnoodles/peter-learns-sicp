;; ## Problem
;; How many different ways can we make change of $1.00, given half-dollars,
;; quarters, dimes, nickels, and pennies.
;; $1.00 = 100 cents;
;; half-dollar = 50 cents;
;; quarter = 25 cents;
;; dime = 10 cents;
;; nickel = 5 cents;
;; penny = 1 cent;

;; ## Solution
;; The number of ways to change amount a using n kinds of coins equals:
;; - the number of ways to change amount a using all but the first kind of coin,
;;   plus
;; - the number of ways to change amount  a - d using all n kinds of coins, where
;;   d is the denomination of the first kind of coin.

;; ## Scheme
;; (define (count-change amount)
;;   (cc amount 5))
;;
;; (define (cc amount kinds-of-coins)
;;   (cond ((= amount 0) 1)
;;     ((or (< amount 0) (= kinds-of-coins 0)) 0)
;;     (else (+
;;       (cc amount (- kinds-of-coins 1))
;;       (cc (- amount (first-denomination kinds-of-coins)) kinds-of-coins)))))
;;
;; (define (first-denomination kinds-of-coins)
;;   (cond ((= kinds-of-coins 1) 1)
;;     ((= kinds-of-coins 2) 5)
;;     ((= kinds-of-coins 3) 10)
;;     ((= kinds-of-coins 4) 25)
;;     ((= kinds-of-coins 5) 50)))
;;

(defn first-denomination
  [kinds-of-coins]
  (cond (= kinds-of-coins 1) 1
        (= kinds-of-coins 2) 5
        (= kinds-of-coins 3) 10
        (= kinds-of-coins 4) 25
        :else 50))

(defn cc
  [amount kinds-of-coins]
  (cond (= amount 0) 1
        (or (< amount 0) (= kinds-of-coins 0)) 0
        :else (+ (cc amount (- kinds-of-coins 1))
                 (cc (- amount
                        (first-denomination kinds-of-coins))
                     kinds-of-coins))))
(defn count-change
  [amount]
  (cc amount 5))

(println
  "Count of ways to change $1.00 into half-dollars, quarters, dimes, nickels and pennies are:"
  (count-change 100))
