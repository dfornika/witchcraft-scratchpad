(ns witchcraft-scratchpad.core
  (:require [lambdaisland.witchcraft :as wc]
            [lambdaisland.witchcraft.palette :as palette]
            [lambdaisland.witchcraft.markup :as markup]))



(comment
  (wc/undo!)
  
  (def me (wc/player #_"dfornika"))
  (wc/fly! me)
  (wc/fly-speed me)
  (wc/set-fly-speed me 0.25)
  (wc/set-health me 20)

  (wc/set-time 1000)
  (wc/time)
  (wc/set-game-rule :do-daylight-cycle false)

  (wc/add-inventory me :diamond-pickaxe)
  (wc/add-inventory me :diamond-sword)
  (wc/add-inventory me :diamond-axe)
  (wc/add-inventory me :shield)
  (wc/add-inventory me :diamond-helmet)
  (wc/add-inventory me :diamond-chestplate)
  (wc/add-inventory me :diamond-leggings)
  (wc/add-inventory me :diamond-boots)
  (wc/add-inventory me :diamond-pickaxe)
  
  (wc/add-inventory me :torch)
  (wc/add-inventory me :redstone-torch)
  (wc/add-inventory me :stick)

  
  (wc/send-title me (markup/fAnCy "Hello ELLIS!" [:dark-blue :dark-green]))
  (wc/send-title me "ELLIS!")
  (wc/send-title me ":)")
  
  (let [block (wc/get-target-block me)]
    (wc/set-block block (rand-nth (palette/block-materials))))

  (let [block (wc/get-target-block me)]
    (wc/set-block block :redstone-ore))
  

  (let [block (wc/get-target-block me)]
    (wc/spawn (update (bean (wc/get-target-block me)) :y #(+ % 100)) (:enderman wc/entity-types)))

  
  (dotimes [n 100]
    (let [target (select-keys (bean (wc/get-target-block me)) [:x :y :z])]
      (wc/spawn target (:primed-tnt wc/entity-types))))
  

  
  (wc/loc me)
  (wc/active-item me)

  (wc/send-title me (pr-str (wc/locv me)))

  )
