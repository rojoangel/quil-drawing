(ns drawing.lines
  (:require [quil.core :as q]))

(defn setup[]
  (q/frame-rate 30)
  (q/color-mode :rgb))
  
(defn draw []
  (q/stroke 255 (/ (q/mouse-x) 2) 0)
  (q/line 0 0 (q/mouse-x) (q/mouse-y))
  (q/stroke (/ (q/mouse-x ) 2) 255 0)
  (q/line 200 0 (q/mouse-x) (q/mouse-y))
  (q/stroke 0 0 255)
  (q/line 0 200 (q/mouse-x) (q/mouse-y))
  (q/stroke 255 255 255)
  (q/line 200 200 (q/mouse-x) (q/mouse-y)))

(q/defsketch hello-lines
  :title "You can see lines"
  :size [500 500]
  :setup setup
  :draw draw
  :features [:keep-on-top])
