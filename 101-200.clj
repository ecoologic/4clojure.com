;; http://www.4clojure.com/problem/107
(fn [exp]
  #(int (Math/pow % exp)))

;; http://www.4clojure.com/problem/156
(fn [default l]
  (reduce #(conj %1 {%2 default}) {} l))

;; http://www.4clojure.com/problem/134
#(nil? (%1 %2 :no))

;; http://www.4clojure.com/problem/145
'(1 5 9 13 17 21 25 29 33 37)

;; http://www.4clojure.com/problem/161
#{1 2}

;; http://www.4clojure.com/problem/162
1
