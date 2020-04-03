(ns kakaotalk.chat
  (:require
   [clojure.java.io :as jio]
   )
  (:import
   java.io.Reader
   java.text.DateFormat
   java.text.DecimalFormat
   java.time.LocalDate
   java.time.LocalTime
   java.time.format.DateTimeFormatter
   java.util.Locale
   ))


(def re-windows-date-separator #"--------------- ([^-]+ ...) ---------------")


(def ^DateTimeFormatter date-formatter (DateTimeFormatter/ofPattern "yyyy년 M월 d일 E요일" Locale/KOREAN))


(def ^DateTimeFormatter time-formatter (DateTimeFormatter/ofPattern "a h:mm" Locale/KOREAN))


(defn windows-version?
  [file]
  (boolean
    (with-open [^Reader r (jio/reader file)]
      (some
        (fn [s]
          (re-matches re-windows-date-separator s))
        (take 6 (line-seq r))))))


:windows
:mobile
:macos
