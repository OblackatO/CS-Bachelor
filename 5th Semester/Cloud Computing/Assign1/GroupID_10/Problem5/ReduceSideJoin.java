package Problem5;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ReduceSideJoin {

    public static class Yago1 extends Mapper<Object, Text, Text, Text> {

        //MY CHANGES ARE HERE
        public static String pattern1 = "livesIn";
        public static String pattern2 = "hasGivenName";

        @Override
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            //MY CHANGES ARE HERE
            String[] tokens = line.split(" ");
            String final_token = "";
            final_token = tokens[1].replaceAll("<", "");
            final_token = final_token.replaceAll(">", "");
            if(final_token.toUpperCase().equals(Yago1.pattern1.toUpperCase()) || final_token.toUpperCase().equals(Yago1.pattern2.toUpperCase())){
                context.write(new Text(tokens[0]), new Text("("+tokens[1]+"," + tokens[2]+")"));
            }
        }
    }

    public static class ReduceSideJoinReducer extends Reducer<Text, Text, Text, Text> {

        HashMap<Text, Text> ParsedLines = new HashMap<Text, Text>();

        @Override
        public void reduce(Text key, Iterable<Text> values, Context context)
                throws IOException, InterruptedException {

            ArrayList<String> current_key_values = new ArrayList<String>();
            Iterator<Text> it = values.iterator();
            while (it.hasNext()) {
                String next_value = it.next().toString();
                //System.out.println("This is the string"+next_value.toUpperCase());
                current_key_values.add(next_value);
            }
            boolean pattern1 = false;
            boolean pattern2 = false;
            for(String text: current_key_values){
                if(text.toUpperCase().contains("LIVESIN")){
                    pattern1 = true;
                }else if(text.toUpperCase().contains("HASGIVENNAME")){
                    pattern2 = true;
                }
            }
            if (pattern1 && pattern2) {
                context.write(key, new Text(current_key_values.toString()));
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "wordcount2");

        job.setMapperClass(Yago1.class);
        job.setReducerClass(ReduceSideJoinReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        long start = System.currentTimeMillis();
        job.waitForCompletion(true);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Time taken:"+timeElapsed);
        System.exit(0);
    }
}
