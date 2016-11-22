(ns drawing.snowflake
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(def x-params [10 200 390])

(defn setup []
  (q/smooth)
  {:flake (q/load-image "images/white_flake.png")
   :y-params [{:y 10 :speed 1} {:y 150 :speed 4} {:y 50 :speed 2}]})

(defn update-y [{y :y speed :speed :as m}]
    (if (>= y (q/height))
      (assoc m :y 0)
      (update-in m [:y] + speed)))

(defn update [state]
  (let [y-params (:y-params state)]
    (assoc state :y-params (map update-y y-params))))

(defn draw [{flake :flake y-params :y-params}]
  (q/background-float 0 0 255)
  (dotimes [n 3]
     (q/image flake (nth x-params n) (:y (nth y-params n)))))

(q/defsketch snowflake
  :title "Snowflake"
  :size [500 500]
  :setup setup
  :update update
  :draw draw
  :features [:keep-on-top]
  :middleware [m/fun-mode])
