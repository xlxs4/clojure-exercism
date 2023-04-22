(ns armstrong-numbers)

(defn armstrong? [num]
  (let [digits (map #(Character/getNumericValue %) (str num))
        count (count digits)
        pow-digits (map #(reduce * (repeat count %)) digits)]
    (= num (reduce + pow-digits))))

;;; Notes
;; 1) There are a lot of ways to get the digits out of a number:
;;    https://batsov.com/articles/2022/08/01/clojure-tricks-number-to-digits/
;;    https://stackoverflow.com/questions/29929325/how-to-split-a-number-in-clojure
;;    Take a look at using rseq and mapv when we don't need to use lazy seqs.
;; 2) While not identical, reduce and apply can behave similarly, and that's
;;    the case with the + function. Take a look at this:
;;    https://stackoverflow.com/questions/3153396/clojure-reduce-vs-apply
;; 3) I could have defined some private functions with defn- and chain them
;;    instead of doing that inside the let block. However, this seems
;;    more concise and pretty idiomatic to me.
;; 4) Exponentiation is also (as everything) not straightforward:
;; https://stackoverflow.com/questions/5057047/how-to-do-exponentiation-in-clojure
