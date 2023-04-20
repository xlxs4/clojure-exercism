(ns sublist)

(defn sublist?
  [l1 l2]
  (some #{l1} (partition (count l1) 1 l2)))

(defn classify
  [l1 l2]
  (cond
    (= l1 l2) :equal
    (sublist? l1 l2) :sublist
    (sublist? l2 l1) :superlist
    :default :unequal))

;;; Notes
;; 1) I prefer abstracting with sublist? instead of throwing everything inside classify.
;; 2) Note that instead of using = as a predicate we can use a set.
;;    Specifically, from https://clojuredocs.org/clojure.core/some:
;;    "One common idiom is to use a set as pred, for example
;;    this will return :fred if :fred is in the sequence, otherwise nil:
;;    (some #{:fred} coll)"
;; 3) partition is really handy for this.
;; 4) In cond, :else is not special. In fact, any keyword, and any non-nil or true will work.
;;    Knowing that, :default is preferred since :else implies truthiness in evaluation
;;    rather than a default value, which is what it really is.
