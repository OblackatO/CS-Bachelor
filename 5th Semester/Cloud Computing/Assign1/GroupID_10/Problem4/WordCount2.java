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
import java.util.HashSet;
import java.util.Set;

public class WordCount2 {

    public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {

        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        private boolean caseSensitive = false;
        private Set<String> patternsToSkip = new HashSet<String>();
        public static PrintWriter writer = null;

        //MY CHANGES ARE HERE
        public static String pattern = "livesIn";

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
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String pattern = null;
                while ((pattern = reader.readLine()) != null) {
                    patternsToSkip.add(pattern);
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
            if(writer == null){
                writer = new PrintWriter("set1.txt", "UTF-8");
            }
            for (String pattern : patternsToSkip) {
                line = line.replaceAll(pattern, "");
            }
            //MY CHANGES ARE HERE
            String[] tokens = line.split(" ");
            String final_token = "";
            final_token = tokens[1].replaceAll("<", "");
            final_token = final_token.replaceAll(">", "");
            if(final_token.toUpperCase().equals(TokenizerMapper.pattern.toUpperCase())){
                word.set(final_token);
                context.write(word, one);
                writer.println(line);
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
            if ("-skippatterns".equals(args[i])) {
                job.getConfiguration().setBoolean("wordcount.skip.patterns", true);
                job.addCacheFile(new Path(args[++i]).toUri());
            } else if ("-casesensitive".equals(args[i])) {
                job.getConfiguration().setBoolean("wordcount.case.sensitive", true);
            }
        }

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.waitForCompletion(true);
        TokenizerMapper.writer.close();
        System.exit(0);
    }
}