import java.io.*;
import java.util.concurrent.BlockingQueue;

public class ReaderThread extends Thread {

    String file_name;
    BlockingQueue queue;

    public ReaderThread(String file_name, BlockingQueue queue){
        this.file_name = file_name;
        this.queue = queue;
    }

    @Override
    public void run(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File(this.file_name)));
            String buffer;
            while((buffer = reader.readLine()) != null){
                this.queue.put(buffer);
            }
            this.queue.put("EOF");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}