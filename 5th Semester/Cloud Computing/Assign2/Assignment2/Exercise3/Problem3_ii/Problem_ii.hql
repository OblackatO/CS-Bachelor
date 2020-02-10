set hive.auto.convert.sortmerge.join=true;
set hive.optimize.bucketmapjoin = true;
set hive.optimize.bucketmapjoin.sortedmerge = true;

DROP TABLE IF EXISTS yago;
CREATE EXTERNAL TABLE yago
  (
    subject string, 
    predicate string, 
    object string
  )

ROW FORMAT DELIMITED
  FIELDS TERMINATED BY ' '
  LINES TERMINATED BY '\n'
STORED AS TEXTFILE
  LOCATION './mytables/yago';

LOAD DATA LOCAL INPATH '/home/peterpan/Downloads/yago_full_clean.tsv' INTO TABLE yago;

CREATE TABLE yago_partition(
  subject string,
  predicate_kl string, 
  object string
)
PARTITIONED BY (predicate string)
STORED AS SEQUENCEFILE
  LOCATION './mytables/yago_partition';
