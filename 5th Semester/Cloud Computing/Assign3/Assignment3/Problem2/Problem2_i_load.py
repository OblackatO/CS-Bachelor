from pymongo import MongoClient
from datetime import datetime

client = MongoClient('localhost', 27017)
db = client.test_database
collection = db.test

"""
Need to load row id into the tables as well, as id
"""
full_data =  open("/home/peterpan/Downloads/yago2.tsv", 'r')  #UPDATE YOUR yago2.tsv file path here.
all_lines = full_data.readlines()
total = len(all_lines)
current_line = 0
start = datetime.now()
for x in all_lines:
    x_splitted = x.split("\t")
    print(x_splitted)
    if "<hasGivenName>" in x_splitted or "<livesIn>" in x_splitted:
        to_add = {"subject":x_splitted[1].strip(),
                    "predicate":x_splitted[2].strip(),
                    "object":x_splitted[3].strip()  
                    }
        collection.insert_one(to_add).inserted_id
        #print(str(id_i))
        current_line += 1
        if total_pourcentage_printed != 100:
            print("POURCENTAGE: {} %".format((current_line*100)/total))
            total_pourcentage_printed += 1
        else:
            total_pourcentage_printed -= 1
end = datetime.now()
print("Time taken: {}".format(end-start))
