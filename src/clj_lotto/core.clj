(ns clj-lotto.core)

(defn generate-number
  "Generates a random lotto number between 1 and max (max inclusive)"
  [max-value]
  (+ 1 (rand-int max-value)))

(defn constantly-less-than
  "Generates a stream (lazy sequence) of numbers between 1 and max (max inclusive)"
  [max-value]
  (repeatedly #(generate-number max-value)))

(defn generate-unique-values
  [size max-val]
  (->> (repeatedly #(take size (constantly-less-than max-val)))
       (some #(when (apply distinct? %) %) )))

(defn get-card
  [lotto-definition]
  (let [ball-numbers-size    (:size     (:ball-numbers lotto-definition))
        ball-numbers-max-val (:max-val  (:ball-numbers lotto-definition))
        lucky-stars-size     (:size     (:lucky-stars  lotto-definition))
        lucky-stars-max-val  (:max-val  (:lucky-stars  lotto-definition))]
    {:ball-numbers (generate-unique-values ball-numbers-size ball-numbers-max-val)
     :lucky-stars  (generate-unique-values lucky-stars-size lucky-stars-max-val)}))


(defn print-card
 [card]
 (let [{:keys [ball-numbers lucky-stars]} card]
   (->> (concat ball-numbers ["-"] lucky-stars)
        (reduce #(str %1 " " %2))
        (println))))

(defn get-euro-million-card
  []
  (let [euro-millions-def {:ball-numbers {:size    5
                                          :max-val 50}
                           :lucky-stars  {:size    2
                                          :max-val 11}}]
    (get-card euro-millions-def)))

(defn get-lotto-card
  []
  (let [lotto-def {:ball-numbers {:size    5
                                  :max-val 49}
                   :lucky-stars  {:size    1
                                  :max-val 10}}]
       (get-card lotto-def)))
