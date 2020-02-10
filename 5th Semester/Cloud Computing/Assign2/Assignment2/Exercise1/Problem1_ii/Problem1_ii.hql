DROP TABLE IF EXISTS yagodata;
CREATE EXTERNAL TABLE yagodata
  (
    subject string, 
    predicate string, 
    object string
  )
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ' '
LINES TERMINATED BY '\n'
STORED AS TEXTFILE
LOCATION './mytables/yagodata';

LOAD DATA LOCAL INPATH '/home/peterpan/Downloads/yago_full_clean.tsv' INTO TABLE yagodata;

SELECT predicate, count(*) AS c
FROM yagodata
GROUP BY predicate
HAVING c > 1
ORDER BY c DESC