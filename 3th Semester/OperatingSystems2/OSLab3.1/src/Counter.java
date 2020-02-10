import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

public class Counter extends Thread {
    private int max;
    private int count = 0;
    private int tap = 0;
    private boolean[] taps;
    private boolean stop = false;
    private HashMap<Long, Counter> counters;

    public Counter(int _max, int _tap, boolean[] _taps, HashMap<Long, Counter> _counters)
    {
        this.counters = _counters;
        this.max = _max;
        this.tap = _tap;
        this.taps = _taps;

    }


    public void run()
    {
        try{
            String out = "";
            while(count < max)
            {
                if(stop)
                {
                    //Stopping a thread this way instead of calling the stop method, gives a thread the chance to free resources.
                    break;
                }
                out = "";
                for(int j=0; j<tap;j++)
                {
                    out += "\t\t";
                }
                out+=this.getId()+": "+count+"/"+max;

                //PrintWriter writer = new PrintWriter(new FileOutputStream(new File("output.txt"), true));
                //writer.println(out);
                //writer.close();
                System.out.println(out);
                try
                {
                    Thread.sleep(500);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                count++;

            }
        }

        catch(ThreadDeath td)
        {

        }
    }


    public void Stop()
    {
        this.stop = true;
    }

    public int getTap()
    {
        return this.tap;
    }

    public void setMax(int max)
    {
        this.max = max;
    }

    public void setCount(int c)
    {
        this.count = c;
    }

}










