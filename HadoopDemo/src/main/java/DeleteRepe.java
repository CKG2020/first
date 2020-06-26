
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
public class DeleteRepe {
//    public static class MyMapper extends Mapper<Object,Text,Text,Text>{
//        public static String text;
//        public void map(Object key,Text value,Context context) throws IOException,InterruptedException{
//            text=value.toString();
//            context.write(new Text(text), new Text(""));
//        }
//    }
//    public static class MyReducer extends Reducer<Text,Text,Text,Text>{
//        public void reduce(Text key,Text values,Context context) throws IOException,InterruptedException{
//            context.write(key, new Text("\n"));
//        }
//    }
//    public static void main(String[] args) throws Exception{
//        Configuration conf=new Configuration();
//        String[] otherArgs=new GenericOptionsParser(conf,args).getRemainingArgs();
//        if(otherArgs.length!=2)
//        {
//            System.err.println("Usage:wordcount <in> <out>");
//            System.exit(2);
//        }
//        Job job=new Job(conf,"Delete Repetition");
//        job.setJarByClass(DeleteRepe.class);
//        job.setMapperClass(MyMapper.class);
//        job.setCombinerClass(MyReducer.class);
//        job.setReducerClass(MyReducer.class);
//        job.setOutputKeyClass(Text.class);
//        job.setOutputValueClass(Text.class);
//
//
//
//        FileInputFormat.addInputPath(job,new Path(otherArgs[0]));
//        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
//        System.exit(job.waitForCompletion(true)?0:1);
//    }


    public static class Map extends Mapper<Object, Text, Text, Text> {
        private static Text text = new Text();

        @Override
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            text = value;
            context.write(text, new Text(""));
        }
    }

    public static class Reduce extends Reducer<Text, Text, Text, Text> {
        @Override
        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            context.write(key, new Text(""));
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://172.17.205.61:9000");
        String[] otherArgs = new String[]{"input", "output"};
        if (otherArgs.length != 2) {
            System.err.println("Usage: Merge and duplicate removal <in> <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "Merge");
        job.setJarByClass(DeleteRepe.class);
        job.setMapperClass(Map.class);
        job.setReducerClass(Reduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}

