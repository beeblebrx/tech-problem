(import [java.lang.Math])
(ns tech-problem.core
  (:gen-class))

(def link-stations '([0, 0, 10] [20, 20, 5] [10, 0, 12]))
(def devices '([0, 0] [100, 100] [15, 10] [18, 18]))

(defn distance
  "Calculates distance between two 2d coordinates"
  [coords1 coords2]
  (let [dx (Math/abs (- (first coords1) (first coords2)))
        dy (Math/abs (- (second coords1) (second coords2)))]
        (Math/sqrt (+ (Math/pow dx 2) (Math/pow dy 2)))
  )
)

(defn power
  "Calculates power between a station and a device at coordinates"
  [station coordinates]
  (let [reach (nth station 2)
        d (distance station coordinates)]
        (Math/pow (max 0 (- reach d)) 2)
  )
)

(defn calculate-links
  "Makes a map for each link-station - device pair with coordinates and power"
  [stations points]
  (for [s stations
        d points]
    {
      :link-station s
      :device d
      :power (power s d)
    }
  )
)

(defn pick-highest-power
  "Picks the link-station with the highest power to device coordinates"
  [device-coordinates all-links]
  (apply max-key :power (filter #(= device-coordinates (:device %)) all-links))
)

(defn print-link
  "Prints the best link-station for device coordinates and power of the link"
  [best-link]
  (let [[devx, devy] (:device best-link)
        [stationx, stationy] (:link-station best-link)
        power (:power best-link)]
    (println
      (condp = (:power best-link)
        0 (str "No link station within reach for point " devx ", " devy)
        (str "Best link station for point " devx "," devy " is " stationx "," stationy " with power " power)
      )
    )
  )
)

(defn -main
  "Calculates the best link station for a device in point (x, y)"
  [& args]
  (doseq [d devices]
    (print-link (pick-highest-power d (calculate-links link-stations devices)))
  )
)
