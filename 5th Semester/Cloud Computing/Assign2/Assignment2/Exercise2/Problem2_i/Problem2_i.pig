all_lines = LOAD '/home/peterpan/Downloads/yago_full_clean.tsv' USING PigStorage(' ') AS  
(subject: chararray, predicate: chararray, object: chararray);
REGISTER /home/peterpan/Downloads/NoSyncStuff/CloudComputing/Assignment2/src/Exercise2/Filters.jar;
result_predicates = FILTER all_lines BY Filters.FiltersPredicate(subject, predicate, object);
/*describe result_predicates;*/
result_livesin = FILTER all_lines BY Filters.FiltersLivesIn(subject, predicate, object);
/*dump result_livesin;*/
final_result = JOIN result_predicates BY subject, result_livesin BY subject;
STORE final_result INTO './final_result';
