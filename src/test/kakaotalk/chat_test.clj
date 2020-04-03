(ns kakaotalk.chat-test
  (:require
   [clojure.test :as test :refer [deftest is are testing]]
   [clojure.java.io :as jio]
   [clojure.java.jdbc :as jdbc]
   [kakaotalk.chat :refer :all]
   )
  (:import
   java.io.File
   java.time.LocalDate
   java.time.LocalTime
   ))


(deftest main
  (is (some? (re-matches re-windows-date-separator "--------------- 2019년 8월 31일 토요일 ---------------")))
  (is (try (LocalDate/parse "2019년 8월 31일 토요일" date-formatter) (catch Throwable _ false)))
  (is (try (LocalTime/parse "오후 8:03" time-formatter) (catch Throwable _ false)))


  (is (true? (windows-version? (jio/resource "kakaotalk/example/windows.txt"))))
  (is (false? (windows-version? (jio/resource "kakaotalk/example/mobile.txt"))))
  )


(def  db-spec
  "The database spec, needed for connecting to the H2 DB. Let's use an
  in-memory DB for our purposes here."
  {:classname   "org.h2.Driver"
   ;; use an in-memory db
   :subprotocol "h2:mem"
   ;; set `DB_CLOSE_DELAY`, otherwise it disappears after each query
   :subname     "kakaotalk_example;DB_CLOSE_DELAY=-1"})



(jdbc/execute!
  db-spec
  [(str "RUNSCRIPT FROM '" (.toURI (jio/resource "kakaotalk/chat.h2.sql")) "'")])


(jdbc/execute!
  db-spec
  [(slurp (jio/resource "kakaotalk/chat.h2.sql"))])



(jdbc/query db-spec "SELECT 1")
(jdbc/query db-spec "SHOW SCHEMAS")
(jdbc/query db-spec "SHOW TABLES")
(jdbc/query db-spec "SHOW COLUMNS FROM kakaotalk_chat")
(jdbc/query db-spec "SHOW INDICES FROM kakaotalk_chat")






(File/createTempFile )


(jdbc/insert!
  (str "jdbc:h2:" (System/getProperty "java.io.tmpdir") "chat_example"))


"jdbc:h2:./data/casino/site;AUTO_SERVER=TRUE"
