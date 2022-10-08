(ns witchcraft-scratchpad.core
  (:require [lambdaisland.witchcraft :as wc]
            [lambdaisland.witchcraft.palette :as palette]
            [lambdaisland.witchcraft.markup :as markup]))



(comment
  (wc/fly! me)
  (wc/undo!)
  (.getSeed (wc/world "world"))
  (wc/block [0 0 0])

  (wc/set-time 1000)
  (wc/time)
  (wc/set-game-rule :do-daylight-cycle false)

  (def me (wc/player #_"dfornika"))

  (wc/send-title me (markup/fAnCy "Hello ELLIS!" [:dark-blue :dark-green]))
  (wc/send-title me "Hello ELLIS!")
  
  (let [block (wc/get-target-block me)]
    (wc/set-block block (rand-nth (palette/block-materials))))

  (let [block (wc/get-target-block me)]
    (wc/set-block block (rand-nth (palette/block-materials))))

  (let [block (wc/get-target-block me)]
    (wc/spawn (update (bean (wc/get-target-block me)) :y #(- % 100)) (:enderman wc/entity-types)))

  
  (wc/loc me)
  (wc/active-item me)

  (wc/send-title me (pr-str (wc/locv me)))

  )
