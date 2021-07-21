#### POC WITH APACHE GRIFFIN FOR DATA QUALITY CHECK
------------------------------------------------

##### Infra

* Data source -> Mongo DB
* Output -> External Hive Table queried through Trino
* Griffin -> Matches mongo data agains output table by querying using presto jdbc driver.
             Sink for griffin result is hdfs
* Griffin job will be submitted to spark running in docker container.
