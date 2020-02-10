package Problem4;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.StringUtils;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MemoryBackedJoin {

    public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {

        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        private boolean caseSensitive = false;
        private Set<String> subjects_of_lives_in = new HashSet<String>();

        //MY CHANGES ARE HERE
        public static ArrayList<String> subjects = new ArrayList<String>();

        @Override
        public void setup(Context context) throws IOException, InterruptedException {
            Configuration conf = context.getConfiguration();
            caseSensitive = conf.getBoolean("wordcount.case.sensitive", false);
            if (conf.getBoolean("wordcount.skip.patterns", false)) {
                URI[] patternsURIs = Job.getInstance(conf).getCacheFiles();
                for (URI patternsURI : patternsURIs) {
                    Path patternsPath = new Path(patternsURI.getPath());
                    String patternsFileName = patternsPath.getName().toString();
                    parseSkipFile(patternsFileName);
                }
            }
        }

        private void parseSkipFile(String fileName) {
            System.out.println("Parse skip file being called !");
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] tokens = line.split(" ");
                    String final_token = "";
                    final_token = tokens[0].replaceAll("<", "");
                    final_token = final_token.replaceAll(">", "");
                    if(!subjects_of_lives_in.contains(final_token)){
                        subjects_of_lives_in.add(final_token.toUpperCase());
                    }
                }
                reader.close();
            } catch (IOException ioe) {
                System.err.println(
                        "Caught exception while parsing the cached file '" + StringUtils.stringifyException(ioe));
            }
        }

        @Override
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            String line = (caseSensitive) ? value.toString() : value.toString().toLowerCase();
            //MY CHANGES ARE HERE
            //get the subject
            String[] tokens = line.split(" ");
            String final_token = "";
            final_token = tokens[0].replaceAll("<", "");
            final_token = final_token.replaceAll(">", "");

            if(subjects_of_lives_in.contains(final_token.toUpperCase())){
                word.set(line);
                context.write(word, one);
            }
        }
    }

    public static class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
        private IntWritable result = new IntWritable();

        public void reduce(Text key, Iterable<IntWritable> values, Context context)
                throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val : values) {
                sum += val.get();
            }
            result.set(sum);
            context.write(key, result);
        }
    }

    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "wordcount2");

        job.setMapperClass(TokenizerMapper.class);
        // job.setCombinerClass(IntSumReducer.class); // enable to use 'local aggregation'
        job.setReducerClass(IntSumReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        for (int i = 0; i < args.length; ++i) {
            if ("-cached_subjects".equals(args[i])) {
                job.getConfiguration().setBoolean("wordcount.skip.patterns", true);
                job.addCacheFile(new Path(args[++i]).toUri());
            } else if ("-casesensitive".equals(args[i])) {
                job.getConfiguration().setBoolean("wordcount.case.sensitive", true);
            }
        }

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