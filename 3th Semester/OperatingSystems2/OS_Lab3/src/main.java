import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class main {

    public static void main(String [] args){

        //2048 bytes for the maximum of the queue
        BlockingQueue queue = new ArrayBlockingQueue<String>(2048);

        //Create readers
        ReaderThread reader0 = new ReaderThread("test_file.txt", queue);
        ReaderThread reader1 = new ReaderThread("test_file1.txt", queue);
        ReaderThread reader2 = new ReaderThread("test_file2.txt", queue);

        //Create Writers that have the SAME output file.
        WriterThread writer0 = new WriterThread("output.txt", queue);
        WriterThread writer1 = new WriterThread("output.txt", queue);
        WriterThread writer2 = new WriterThread("output.txt", queue);


        reader0.start();
        writer0.start();

        reader1.start();
        writer1.start();

        reader2.start();
        writer2.start();

    }



}
