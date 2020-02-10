
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NestedLoopJoinMod2 {

    // Static column family and qualifiers (same for both tables)
    static byte[] COLUMNs = Bytes.toBytes("triple");
    static byte[] QUALIFIER = Bytes.toBytes("subject");
    static byte[] QUALIFIER2 = Bytes.toBytes("object");

    public static void main(String args[]) throws Exception {

        // Create a default HBase configuration & connection
        Configuration config = HBaseConfiguration.create();
        Connection connection = ConnectionFactory.createConnection(config);

        // Table 1 initialization
        Table table1 = connection.getTable(TableName.valueOf("yago_isCitizenOf"));
        // Table 2 initialization
        Table table2 = connection.getTable(TableName.valueOf("yago_hasFamilyName"));

        // Initialize a scan over the entire first table
        Scan scan = new Scan();
        scan.addColumn(COLUMNs, QUALIFIER);
        scan.addColumn(COLUMNs, QUALIFIER2);// set the column we are interested in
        scan.setTimeRange(0, Long.MAX_VALUE); // retrieve the versions of a cell at all timestamps
        scan.setMaxVersions(Integer.MAX_VALUE); // retrieve all versions of a cell


        // Start the actual scanner
        ResultScanner scanner = table1.getScanner(scan);
        ResultScanner scanner2 = table2.getScanner(scan);


        //map to keep track of the number of lives subjects
        Map<String, Integer> subjects_count = new HashMap<String, Integer>();
        ArrayList<String> Already_seen = new ArrayList<String>();

        // Iterate over all result rows from the first table
        for (Result result1 : scanner) {
            //byte[] familyMap = result1.value();
            byte[] familyMap = result1.getValue(Bytes.toBytes("triple"), Bytes.toBytes("subject")); // getFamilyMap(Bytes.toBytes("merchantNo"));
            String subject_converted = Bytes.toString(familyMap);
            if(subjects_count.containsKey(subject_converted) == false){
                subjects_count.put(subject_converted, 1);
            }else {
                subjects_count.put(subject_converted, subjects_count.get(subject_converted) + 1);
                if (subjects_count.get(subject_converted) > 2) {
                    if(Already_seen.contains(subject_converted)){
                        //This condition was added to avoid printing the familyname of a subject
                        //that has more than 2 citizeanof, more than once.
                        continue;
                    }else{
                        Already_seen.add(subject_converted);
                    }
                    scanner2.close();
                    scanner2 = table2.getScanner(scan);
                    for (Result result2 : scanner2) {
                        byte[] familyMap2 = result2.getValue(Bytes.toBytes("triple"), Bytes.toBytes("subject")); // getFamilyMap(Bytes.toBytes("merchantNo"));
                        String familymap2_converted = Bytes.toString(familyMap2);
                        if(familymap2_converted.equals(subject_converted)){
                            System.out.println("\nDetected more than 2 citizeanof for:"+subject_converted);
                            byte[] familyMap2_familyname = result2.getValue(Bytes.toBytes("triple"), Bytes.toBytes("object")); // getFamilyMap(Bytes.toBytes("merchantNo"));
                            String familyMap2_familyname_converted = Bytes.toString(familyMap2_familyname);
                            System.out.println(subject_converted+" <hasFamilyName> "+familyMap2_familyname_converted);
                        }
                    }
                }
            }
        }
    }
}