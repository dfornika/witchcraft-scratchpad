(ns witchcraft-scratchpad.core
  (:require [clojure.string :as str]
            [lambdaisland.witchcraft :as wc]
            [lambdaisland.witchcraft.palette :as palette]
            [lambdaisland.witchcraft.markup :as markup]))


(defn suit-up!
  []
  (let [me (wc/player #_"dfornika")]
    (wc/add-inventory me :diamond-pickaxe)
    (wc/add-inventory me :diamond-sword)
    (wc/add-inventory me :diamond-axe)
    (wc/add-inventory me :shield)
    (wc/add-inventory me :diamond-helmet)
    (wc/add-inventory me :diamond-chestplate)
    (wc/add-inventory me :diamond-leggings)
    (wc/add-inventory me :diamond-boots)
    (wc/add-inventory me :diamond-pickaxe)))
    

(defn bombs-away!
  []
  (dotimes [n 100]
    (let [target (select-keys (bean (wc/get-target-block me)) [:x :y :z])]
      (wc/spawn target (:primed-tnt wc/entity-types)))))


(defn rain-entity!
  [e]
  (for [x (range 20)
        z (range 20)]
    (let [target (select-keys (bean (wc/get-target-block me)) [:x :y :z])
          loc {:x (+ (:x target) (* x 8)) :y 200 :z (+ (:z target) (* z 8))}]
      (wc/spawn loc (e wc/entity-types)))))


(defn heal!
  []
  (let [me (wc/player #_"dfornika")]
    (wc/set-health me 20)))


(comment

  (def me (wc/player #_"dfornika"))
  (wc/undo!)
  (suit-up!)
  (heal!)
  (wc/fly! me)
  (wc/fly-speed me)
  (wc/set-fly-speed me 0.25)
  
  (rain-entity! :chicken)

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


  (wc/add-inventory me :chest)
  (wc/add-inventory me :torch)
  (wc/add-inventory me :redstone-torch)
  (wc/add-inventory me :stick)
  (wc/add-inventory me :blue-bed)
  (wc/add-inventory me :iron-ingot)
  (wc/add-inventory me :flint)

  
  (wc/send-title me (markup/fAnCy "Hello ELLIS!" [:dark-blue :dark-green]))
  (wc/send-title me "ELLIS!")
  (wc/send-title me ":)")
  
  (let [block (wc/get-target-block me)]
    (wc/set-block block (rand-nth (palette/block-materials))))

  ;;
  (let [block (wc/get-target-block me)]
    (wc/set-block block :redstone-ore))
  

  ;; Spawn entity
  (let [target (select-keys (bean (wc/get-target-block me)) [:x :y :z])]
    (wc/spawn (update target :y #(+ % 10))
              (:minecart-tnt wc/entity-types)))


  ;; Bombs away!
  (dotimes [n 100]
    (let [target (select-keys (bean (wc/get-target-block me)) [:x :y :z])]
      (wc/spawn target (:primed-tnt wc/entity-types))))

  ;; Rain enderman
  (for [x (range 20)
        z (range 20)]
    (let [target (select-keys (bean (wc/get-target-block me)) [:x :y :z])
          loc {:x (+ (:x target) (* x 8)) :y 200 :z (+ (:z target) (* z 8))}]
      (wc/spawn loc (:enderman wc/entity-types))))


  (let [target (select-keys (bean (wc/get-target-block me)) [:x :y :z])
        {:keys [x y z]} target]
    (mapv identity (wc/nearby-entities me x y z)))
 
  (let [target (select-keys (bean (wc/get-target-block me)) [:x :y :z])
        {:keys [x y z]} target
        nearby-entities (wc/nearby-entities me x y z)
        is-enderdragon? #(re-matches #".*enderdragon" (str/lower-case (str (type %))))
        enderdragon (first (filter is-enderdragon? nearby-entities))
        breath-attack-phase org.bukkit.entity.EnderDragon$Phase/BREATH_ATTACK
        hover-phase org.bukkit.entity.EnderDragon$Phase/HOVER]

    (.getPhase enderdragon)
    #_(.setPhase enderdragon hover-phase)
    #_(.setPhase enderdragon breath-attack-phase))
  

  )
