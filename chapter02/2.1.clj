;; (def x (list 1 2))

(defn make-rat
  [n d]
  (list n d))

(defn numer [x] (first x))

(defn denom [x] (second x))

(defn print-rat
  [x]
  (println
    (numer x)
    "/"
    (denom x)))

(defn add-rat
  [x y]
  (make-rat
    (+
      (* (numer x) (denom y))
      (* (numer y) (denom x)))
    (* (denom x) (denom y))))

(defn sub-rat
  [x y]
  (make-rat
    (-
      (*
        (numer x)
        (denom y))
      (*
        (numer y)
        (denom x)))
    (*
      (denom x)
      (denom y))))


(defn mul-rat
  [x y]
  (make-rat
    (*
      (numer x)
      (numer y))
    (*
      (denom x)
      (denom y))))

(defn div-rat
  [x y]
  (make-rat
    (*
      (numer x)
      (denom y))
    (*
      (numer y)
      (denom x))))

(defn equal-rat?
  [x y]
  (if
    (=
      (*
        (numer x)
        (denom y))
      (*
        (denom x)
        (numer y)))
    true false))

(def one-half
  (make-rat 1 2))
(def one-third
  (make-rat 1 3))

(print-rat
  (add-rat one-half one-third))

(print-rat
  (sub-rat one-half one-third))

(print-rat
  (mul-rat one-half one-third))

(print-rat
  (div-rat one-half one-third))

(print-rat
  (equal-rat? one-half one-third))
