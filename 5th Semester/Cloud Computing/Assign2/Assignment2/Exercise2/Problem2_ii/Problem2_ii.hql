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


CREATE VIEW result_livesin AS SELECT * FROM yagodata WHERE predicate == '<livesIn>' AND object LIKE '%,%';
CREATE VIEW result_hasgivenname AS SELECT subject AS subject_name, predicate AS predicate_name, object AS object_name FROM yagodata WHERE predicate == '<hasGivenName>';

CREATE VIEW final_table AS SELECT result_hasgivenname.subject_name, result_hasgivenname.predicate_name, result_hasgivenname.object_name, result_livesin.predicate, result_livesin.object 
FROM result_livesin JOIN result_hasgivenname ON (result_hasgivenname.subject_name = result_livesin.subject);

SELECT * FROM final_table;