(import [java.lang.Math])
(ns tech-problem.core-test
  (:require [clojure.test :refer :all]
            [tech-problem.core :refer :all]))

(deftest calculate-links-test
  (testing "should return an empty list when no link-stations or devices exist"
    (is (empty? (calculate-links '() '())))
  )
  (testing "should return an empty list when there are devices but no link-statios"
    (is (empty? (calculate-links '() '([1, 1]))))
  )
  (testing "should return an empty list when there are link-stations but no devices"
    (is (empty? (calculate-links '([0, 0, 1]) '())))
  )
  (testing "calculate-links should make four maps with two and two elements in link-stations and devices"
    (is (= (count (calculate-links '([0, 0, 10] [20, 20, 5]) '([0, 0] [100, 100]))) 4))
  )
)

(deftest power-test
  (testing "should be able to calculate signal power"
    (is (== 100 (power [0, 0, 10] [0, 0])))
  )

  (testing "should return 0 when device is out of reach"
    (is (== 0 (power [0, 0, 1] [10, 10])))
  )
)

(deftest distance-test
  (testing "should return 0 as distance if coordinates are equal"
    (is (== 0 (distance [0, 0] [0, 0])))
  )

  (testing "should return sqrt(2) when dx and dy are 1 and neither point is origin"
    (is (== (Math/sqrt 2) (distance [1, 1] [2, 2]))))
)

(deftest pick-highest-power-test
  (testing "should return the map that has highest :power to the given device coordinates"
    (is (= {:link-station [2, 2, 2] :device [1, 1] :power 3}
      (pick-highest-power [1, 1]
        '({:link-station [0, 0, 1] :device [1, 1] :power 1}
          {:link-station [2, 2, 2] :device [1, 1] :power 3}
          {:link-station [1, 1, 3] :device [2, 2] :power 6})))
    )
  )
)