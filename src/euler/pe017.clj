(ns euler.pe017)

(def digit-to-word 
 {1 "one",
 2 "two",
 3 "three",
 4 "four",
 5 "five",
 6 "six",
 7 "seven",
 8 "eight",
 9 "nine",
 10 "ten",
 11 "eleven",
 12 "twelve",
 13 "thirteen",
 14 "fourteen",
 15 "fifteen",
 16 "sixteen",
 17 "seventeen",
 18 "eighteen",
 19 "nineteen",
 20 "twenty",
 30 "thirty",
 40 "forty",
 50 "fifty",
 60 "sixty",
 70 "seventy",
 80 "eighty",
 90 "ninety",
 })

(defn spell-digits [n]
 (cond 
  (zero? n) '()
  (< n 20)
   (list (digit-to-word n)) 
  (< n 100)
   (let [deca (* (int (/ n 10)) 10)]
    (cons (digit-to-word deca) (spell-digits (- n deca)) ))
  (< n 1000)
   (let [hecto (int (/ n 100))
    twodigits (- n (* hecto 100))
    ]
    (flatten (list (digit-to-word hecto)
              (if (zero? twodigits) "hundred" (list "hundred" "and"))
              (spell-digits (- n (* hecto 100))))))
  (< n 10000)
   (let [kilo (int (/ n 1000))]
    (flatten (list (digit-to-word kilo) "thousand"
              (spell-digits (- n (* kilo 1000))))))
 ))

(defn spell-number [n]
 (clojure.string/join "" (spell-digits n)))

(defn count-letters-of-digit [n]
 (count (spell-number n)))

(defn pe017 []
 (reduce + (map count-letters-of-digit (range 1 1001))))

