import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class WriterThread extends Thread {

    String file_name;
    BlockingQueue queue;

    public WriterThread(String file_name, BlockingQueue queue){
        this.file_name = file_name;
        this.queue = queue;

    }

    @Override
    public void run(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(new File(this.file_name), true));
            String buffer = "";
            while((buffer = (String) this.queue.take()) != "EOF"){
                writer.println(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }
    }

}