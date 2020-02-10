//Problem 1 -- i
//used to create files:
cat yago2.tsv | grep "<livesIn>" > yago2_livesin.tsv
cat yago2.tsv | grep "<hasGivenName>" > yago2_hasgiven_name.tsv

// Used to create tables
create 'yago_hasgiven_name', 'triple'
create 'yago_lives', 'triple'

//note on the command: if one adds spaces to columns it will not run
hbase org.apache.hadoop.hbase.mapreduce.ImportTsv  -Dimporttsv.columns=HBASE_ROW_KEY,triple:subject,triple:predicate,triple:object yago_lives yago2_livesin.tsv

hbase org.apache.hadoop.hbase.mapreduce.ImportTsv -Dimporttsv.columns=HBASE_ROW_KEY,triple:subject,triple:predicate,triple:object yago_hasgiven_name yago2_hasgiven_name.tsv

#####################################################################################
//Problem 1 -- ii 
//crete files
cat yago2.tsv | grep "<isCitizenOf>" > yago2_isCitizenOf.tsv
cat yago2.tsv | grep "<hasFamilyName>" > yago2_hasFamilyName.tsv

//create tables
create 'yago_isCitizenOf', 'subject', 'predicate', 'object'
create 'yago_hasFamilyName', 'subject', 'predicate', 'object'

//note on the command: if one adds spaces to columns it will not run
hbase org.apache.hadoop.hbase.mapreduce.ImportTsv  -Dimporttsv.columns=HBASE_ROW_KEY,triple:subject,triple:predicate,triple:object yago_isCitizenOf yago2_isCitizenOf.tsv

hbase org.apache.hadoop.hbase.mapreduce.ImportTsv -Dimporttsv.columns=HBASE_ROW_KEY,triple:subject,triple:predicate,triple:object yago_hasFamilyName yago2_hasFamilyName.tsv

###########################################################################################
Problem 2 -- i
//Put mongo up and running
sudo service mongod start
or
sudo systemctl start mongod

//Load yago2.tsv data into mongo documents with the following python script:
python3 Problem2_i_load.py
Do not forget to install pymongo: pip install pymongo OR pip3 install pymongo
Do not forget to change to update the yago2 path in the line: 
"full_data =  open("/path/to/yago2.tsv", 'r')"

//Finally, open a mongo db terminal
mongo

//type
use test_database

//Run the following command:
db.test.aggregate([
  {
    $lookup:
      {
        from: "test",
        let: { subject1: "$subject", predicate1: "$predicate" },
        pipeline: [ 
     { $match: { $expr: {$eq:["$subject", "$$subject1"]} } },
     { $project: {subject:0,_id:0}}
   ],
        as: "join_results"
      }
  }
 ]).pretty()

Takes around 1:20sec to run 
