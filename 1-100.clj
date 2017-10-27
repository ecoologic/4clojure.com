;; http://www.4clojure.com/problem/1
true

;; http://www.4clojure.com/problem/2
4

;; http://www.4clojure.com/problem/3
"HELLO WORLD"

;; http://www.4clojure.com/problem/4
:a :b :c

;; http://www.4clojure.com/problem/5
'(1 2 3 4)

;; http://www.4clojure.com/problem/6
:a :b :c

;; http://www.4clojure.com/problem/7
[1 2 3 4]

;; http://www.4clojure.com/problem/8
#{:a :b :c :d}

;; http://www.4clojure.com/problem/9
2

;; http://www.4clojure.com/problem/10
20

;; http://www.4clojure.com/problem/11
[:b, 2]

;; http://www.4clojure.com/problem/12
3

;; http://www.4clojure.com/problem/13
[20 30 40]

;; http://www.4clojure.com/problem/14
8

;; http://www.4clojure.com/problem/15
(partial * 2)

;; http://www.4clojure.com/problem/16
#(str "Hello, " % "!")

;; http://www.4clojure.com/problem/17
'(6 7 8)

;; http://www.4clojure.com/problem/18
'(6 7)

;; http://www.4clojure.com/problem/19
(comp first reverse)

;; http://www.4clojure.com/problem/20
(comp second reverse)

;; http://www.4clojure.com/problem/21
(fn [list number]
  (loop [l list n number]
    (if (zero? n)
          (first l)
          (recur (rest l) (dec n)))))

;; http://www.4clojure.com/problem/22
(fn [list]
  (loop [sub_list list current_count 0]
    (if (empty? sub_list)
          current_count
          (recur (rest sub_list) (inc current_count)))
  )
)

;; http://www.4clojure.com/problem/23
(fn [list]
  (loop [result '() sub_list list]
    (if (empty? sub_list)
          result
          (recur (concat [(first sub_list)] result) (rest sub_list))
)))

;; http://www.4clojure.com/problem/24
#(reduce + %)

;; http://www.4clojure.com/problem/25
(fn [list]
  (reverse (loop [result [] sub_list list]
    (if (empty? sub_list)
          result
          (if (odd? (first sub_list))
            (recur (cons (first sub_list) result) (rest sub_list))
            (recur result (rest sub_list)))
))))

;; http://www.4clojure.com/problem/26
#(first (split-at % '(1 1 2 3 5 8 13 21)))

;; http://www.4clojure.com/problem/27
(fn [word] (loop [list (seq word)]
  (let [fi (first list)]
  (let [la (last list)]
  (if (= fi la)
    (if (> 2 (count list)) true (recur (rest (butlast list))))
    false
)))))

;; http://www.4clojure.com/problem/28
(fn [list]
  (loop [l list
         result '()]
    (let [fi (first l)]
    (let [re (rest l)]
    (if (empty? l)
      (reverse result)
      (if (sequential? fi)
        (recur (concat fi re) result)
        (recur re (concat [fi] result))
  ))))))

;; http://www.4clojure.com/problem/29
#(apply str (re-seq #"[A-Z]*" %))

;; http://www.4clojure.com/problem/30
(fn [list] (loop [l list prev nil result '()]
  (let [fi (first l)]
  (let [re (rest l)]
  (if (empty? l)
    (reverse result)
    (if (= prev fi)
      (recur re fi result)
      (recur re fi (cons fi result))
))))))

;; http://www.4clojure.com/problem/31
(fn [list] "31 Pack a Sequence"
  (loop [l list
         group  ()
         result ()]
    (let [fi      (first l)
          groupFi (first group)
          newResult (cons group result)]
    (if (empty? l)
      (rest (reverse newResult))
      (if (= fi groupFi)
        (recur (rest l) (conj group fi) result)
        (recur (rest l) (conj () fi) newResult)
)))))

;; http://www.4clojure.com/problem/32
(fn [list]
  (loop [l list
         result ()]
    (if (empty? l)
      result
      (recur (rest l) (concat result [(first l)] [(first l)]))
)))

;; http://www.4clojure.com/problem/33
(fn [list num]
  (loop [l list
         n num
         result '()]
    (let [fi (first l)
          newResult (concat result [fi])]
    (if (empty? l)
      result
      (if (= 1 n)
        (recur (rest l) num newResult)
        (recur l (dec n) newResult)
)))))

;; http://www.4clojure.com/problem/34
(fn [start end] (loop [n start result '()]
        (if (< n end)
            (recur (inc n) (cons n result))
        (reverse result)
)))

;; http://www.4clojure.com/problem/35
7

;; http://www.4clojure.com/problem/36
[x 7 y 3 z 1]

;; http://www.4clojure.com/problem/37
"ABC"

;; http://www.4clojure.com/problem/38
(fn [& list] (loop [l list result (first list)]
  (if (or (empty? l) (nil? l))
    result
    (if (> (first l) result)
      (recur (rest l) (first l))
        (recur (rest l) result)
))))

;; http://www.4clojure.com/problem/39
(fn [keys values] (loop [ks keys vs values result '()]
  (if (or (empty? ks) (empty? vs))
    (reverse result)
    (recur (rest ks)
           (rest vs)
           (concat [(first vs)] [(first ks)] result)))))

;; http://www.4clojure.com/problem/40
(fn [separator list] (loop [l list result '()]
  (if (empty? l)
    (rest (reverse result))
    (recur (rest l) (concat [(first l)] [separator] result)))))

;; http://www.4clojure.com/problem/41
(fn [list nth]
  (loop [l list
         i 1
         result '()]
    (if (empty? l)
      (reverse result)
      (recur
        (rest l)
        (inc i)
        (if (zero? (mod i nth))
          result
          (cons (first l) result))))))

;; http://www.4clojure.com/problem/42
(fn [number]
  (loop [n number
         result 1]
    (if (zero? n)
      result
      (recur
        (dec n)
        (* result n)))))

;; http://www.4clojure.com/problem/43
(fn [list groupQty]
  (let [listFirst (first list)
        groupSize (/ (count list) groupQty)
        groupFirsts (take groupQty list)]
  (loop [starts groupFirsts
         result ()]
    (if (empty? starts)
      (reverse result)
      (let [fi (first starts)
            re (rest starts)
            groupEnd (+ fi (* groupSize groupQty))
            group (range fi groupEnd groupQty)]
          (recur re (cons group result)))))
    ))

;; http://www.4clojure.com/problem/44
(fn [num list]
  (let [size   (count list)
        n      (mod (if (pos? num) num (+ size num)) size)
        parts  (split-at n list)
        before (first parts)
        after  (last parts)]
  (concat after before)
))

;; http://www.4clojure.com/problem/45
'(1 4 7 10 13)

;; http://www.4clojure.com/problem/46
(fn [method] #(method %2 %1))

;; http://www.4clojure.com/problem/47
4

;; http://www.4clojure.com/problem/48
6

;; http://www.4clojure.com/problem/49
(fn [num l]
  (let [reverseNum (- (count l) num)]
  (list (take num l)
        (reverse (take reverseNum (reverse l))))
))

;; http://www.4clojure.com/problem/50
#(vals (group-by class %))

;; http://www.4clojure.com/problem/51
[1 2 3 4 5]

;; http://www.4clojure.com/problem/52
[c e]

;; http://www.4clojure.com/problem/53
(fn [list]
  (loop [l list
         results ()
         group [(first l)]]
    (let [this (first l)
          min (inc (first group))]
      (if (empty? l)
        (reverse (last (sort-by count (filter #(> (count %) 1) (cons group results)))))
        (if (>= this min)
          (recur (rest l) results (cons this group))
          (recur (rest l) (cons group results) [this])
)))))

;; http://www.4clojure.com/problem/54
(fn [num list]
  (loop [l list
         results ()
         group ()]
    (let [this (first l)
          re (rest l)]
      (if (= (count group) num)
        (recur re (concat results [group]) [this])
        (if (empty? l)
          results
          (recur re results (concat group [this]))
)))))

;; http://www.4clojure.com/problem/55
(fn [list]
  (loop [l list
         result {}]
    (if (empty? l)
      result
      (let [fi (first l)
            occ (inc (or (result fi) 0))]
        (recur (rest l) (conj result {fi occ}))
))))

;; http://www.4clojure.com/problem/56
(fn [list]
  (loop [l list
         result ()]
    (let [fi (first l)]
      (if (empty? l)
        (reverse result)
        (recur (rest l)
               (if (some #(= fi %) result)
                 result
                 (cons fi result)
))))))

;; http://www.4clojure.com/problem/57
'(5 4 3 2 1)

;; http://www.4clojure.com/problem/58
;; TODO

;; http://www.4clojure.com/problem/59
(fn [& fns]
  (fn [& params]
    (loop [fs fns
           result ()]
      (if (empty? fs)
        (reverse result)
        (recur (rest fs)
               (cons (apply (first fs) params) result))
))))

;; http://www.4clojure.com/problem/60
;; TODO


;; http://www.4clojure.com/problem/61
(fn [keys values]
  (loop [ks keys
         vs values
         result {}]
    (if (or (empty? ks) (empty? vs))
      result
      (recur (rest ks) (rest vs) (conj result {(first ks) (first vs)})))))

;; http://www.4clojure.com/problem/62
;; TODO

;; http://www.4clojure.com/problem/63
(fn [f list]
  (loop [l list
         result {}]
    (if (empty? l)
      result
      (let [value (first l)
            key (f value)
            values (or (result key) [])
            newValues (conj values value)
            newResult (conj result {key newValues})]
        (recur (rest l) newResult)
))))

;; http://www.4clojure.com/problem/64
+

;; http://www.4clojure.com/problem/65
;; TODO

;; http://www.4clojure.com/problem/66
(fn [num1 num2]
  (let [big   (max num1 num2)
        small (min num1 num2)]
    (loop [num small]
      (let [bigMod   (mod big   num)
            smallMod (mod small num)]
        (if (= 0 bigMod smallMod)
          num
          (recur (dec num))
)))))

;; http://www.4clojure.com/problem/67
(fn [size]
    (loop [n 2
           results ()]
      (if (= size (count results))
        (reverse results)
        (let [isPrime (empty? (filter
                                #(integer? (/ n %))
                                (range 2 n)))]
          (recur (inc n)
                 (if isPrime
                   (cons n results)
                   results
    ))))))

;; http://www.4clojure.com/problem/68
[7 6 5 4 3]

;; http://www.4clojure.com/problem/69
;; TODO

;; http://www.4clojure.com/problem/70
(fn [sentence]
  (let [words (re-seq #"\w+" sentence)]
    (sort-by clojure.string/lower-case words)
))

;; http://www.4clojure.com/problem/71
last

;; http://www.4clojure.com/problem/72
apply +

;; http://www.4clojure.com/problem/73
(fn [board]
  (let [boardSize         (count board)
        transposedBoard   (apply mapv vector board)
        lineWinner        (fn [line]
                            (let [player (first line)]
                              (and (not= player :e)
                                   (= boardSize (count (filter #(= % player) line)))
                                   player)))
        rowWinner         #(lineWinner (board %))
        columnWinner      #(lineWinner (transposedBoard %))
        transversalWinner #(lineWinner (if (= 0 %)
                                         [((board 0) 0) ((board 1) 1) ((board 2) 2)]
                                         [((board 2) 0) ((board 1) 1) ((board 0) 2)]))]
    (some #(or
             (rowWinner         %)
             (columnWinner      %)
             (transversalWinner %))
          (range boardSize))
))

;; http://www.4clojure.com/problem/74


;; http://www.4clojure.com/problem/75


;; http://www.4clojure.com/problem/76


;; http://www.4clojure.com/problem/77


;; http://www.4clojure.com/problem/78


;; http://www.4clojure.com/problem/79


;; http://www.4clojure.com/problem/80


;; http://www.4clojure.com/problem/81
(fn [a b]
  (set (filter #(contains? a %) b)))

;; http://www.4clojure.com/problem/82


;; http://www.4clojure.com/problem/83
(fn [& args]
  (true?
    (and (some true? args)
         (not (every? true? args))
)))

;; http://www.4clojure.com/problem/84


;; http://www.4clojure.com/problem/85


;; http://www.4clojure.com/problem/86


;; http://www.4clojure.com/problem/87


;; http://www.4clojure.com/problem/88


;; http://www.4clojure.com/problem/89


;; http://www.4clojure.com/problem/90


;; http://www.4clojure.com/problem/91


;; http://www.4clojure.com/problem/92


;; http://www.4clojure.com/problem/93


;; http://www.4clojure.com/problem/94


;; http://www.4clojure.com/problem/95


;; http://www.4clojure.com/problem/96


;; http://www.4clojure.com/problem/97


;; http://www.4clojure.com/problem/98


;; http://www.4clojure.com/problem/99


;; http://www.4clojure.com/problem/100
