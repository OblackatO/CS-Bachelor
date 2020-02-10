all_lines = LOAD '/home/peterpan/Downloads/yago_full_clean.tsv' USING PigStorage(' ') AS 
(subject: chararray, predicate: chararray, object: chararray);
n = FOREACH all_lines GENERATE FLATTEN(TOKENIZE(predicate)) AS word;
filtered_words = FILTER n BY word MATCHES '[<]*\\w+[>]*';
predicate_groups = GROUP filtered_words BY word;
predicate_counts = FOREACH predicate_groups GENERATE group AS word, COUNT(filtered_words) AS count;
ordered_predicate_counts = ORDER predicate_counts BY count DESC;
STORE ordered_predicate_counts INTO './yagopredicatecounts';