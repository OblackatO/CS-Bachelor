CREATE VIEW result_hasgivenname AS SELECT * FROM yago WHERE predicate == '<hasGivenName>';
CREATE VIEW result_livesin AS SELECT * FROM yago WHERE predicate == '<livesIn>';

SELECT /*+ MAPJOIN(result_livesin)*/ result_hasgivenname.subject, result_hasgivenname.predicate,  result_hasgivenname.object, result_livesin.predicate, result_livesin.object FROM result_livesin JOIN result_hasgivenname ON (result_hasgivenname.subject = result_livesin.subject);