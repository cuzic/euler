(ns euler.pe019
 (:import (java.util GregorianCalendar)))

(defn gregorian [yyyy mm dd]
 (java.util.GregorianCalendar. yyyy (dec mm) dd))

(defn calendar-month-inc [date]
 (do 
  (let [d (.clone date)]
   (.add d GregorianCalendar/MONTH 1)
   d)))

(defn calendar-less-than? [a b]
 (= (.compareTo a b) -1))

(defn calendar-sunday? [date]
 (= (.get date GregorianCalendar/DAY_OF_WEEK) GregorianCalendar/SUNDAY))

  (defn twentieth-century []
   (let [begin (gregorian 1901 1 1)
    end   (gregorian 2001 1 1)]
    (take-while #(calendar-less-than? % end) (iterate calendar-month-inc begin))))

  (defn filter-sunday [dates]
   (filter calendar-sunday? (dates)))

  (defn pe019 []
   (count (filter-sunday twentieth-century)))

