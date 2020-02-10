import org.apache.avro.generic.GenericData;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.ArrayList;
import java.util.Map;

public class NestedLoopJoinMod {

    // Static column family and qualifiers (same for both tables)
    static byte[] COLUMNs = Bytes.toBytes("triple");
    static byte[] QUALIFIER = Bytes.toBytes("subject");
    static byte[] QUALIFIER2 = Bytes.toBytes("object");

    public static void main(String args[]) throws Exception {

        // Create a default HBase configuration & connection
        Configuration config = HBaseConfiguration.create();
        Connection connection = ConnectionFactory.createConnection(config);

        // Table 1 initialization
        Table table1 = connection.getTable(TableName.valueOf("yago_hasgiven_name"));

        // Table 2 initialization
        Table table2 = connection.getTable(TableName.valueOf("yago_lives"));

        // Initialize a scan over the entire first table
        Scan scan = new Scan();
        scan.addColumn(COLUMNs, QUALIFIER);
        scan.addColumn(COLUMNs, QUALIFIER2);// set the column we are interested in
        scan.setTimeRange(0, Long.MAX_VALUE); // retrieve the versions of a cell at all timestamps
        scan.setMaxVersions(Integer.MAX_VALUE); // retrieve all versions of a cell


        // Start the actual scanner
        ResultScanner scanner = table1.getScanner(scan);
        ResultScanner scanner2 = table2.getScanner(scan);

        // Now join the two tables based on their row keys

        // Iterate over all result rows from the first table
        for (Result result1 : scanner) {
            //GETS subject for current row in table1
            byte[] familyMap = result1.getValue(Bytes.toBytes("triple"), Bytes.toBytes("subject"));

            //Closes previous scanner and inits new one in table2
            scanner2.close();
            scanner2 = table2.getScanner(scan);
            for (Result result2 : scanner2) {
                //GETS subject for current row in table2
                byte[] familyMap2 = result2.getValue(Bytes.toBytes("triple"), Bytes.toBytes("subject"));

                //CHECKS for matches on both subjects
                if(Bytes.toString(familyMap).equals(Bytes.toString(familyMap2))){
                    String final_subject = Bytes.toString(familyMap);
                    String object_table1 = Bytes.toString(
                            result1.getValue(Bytes.toBytes("triple"), Bytes.toBytes("object"))
                    );
                    String object_table2 = Bytes.toString(
                            result2.getValue(Bytes.toBytes("triple"), Bytes.toBytes("object"))
                    );
                    //Outputs the results
                    System.out.println("\nMatch found for:");
                    System.out.println(final_subject+" <hasGivenName> "+ object_table1 + " <livesIn> "+ object_table2);
                }

            }

        }

    }
}