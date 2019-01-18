import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Count
{
    public static void main(String[] args)
    {
        String in="";
        int tmp = 0;
        int num;
        String[] tokens;
        int tap = -1;
        boolean suspended = false;
        boolean[] taps = new boolean[10]; //Allow only ten parallel counters
        HashMap<Long, Counter> counters = new HashMap<Long, Counter>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do
        {
            System.out.println("Your options: start [number], stop [thread ID], setmax [thread ID] [new value], setvalue [thread ID] [new value], quit");

            try{
                in = reader.readLine();
                if(in.equals(""))
                {
                    for (Map.Entry<Long, Counter> c : counters.entrySet())
                        c.getValue().suspend();	 //This method should not be used. Can cause deadlocks since a suspended thread has no chance to free resources.
                    //Alternative solution using so-called semaphores --> See later TP
                    //Concerning the deadlock issue of suspend, resume and stop see also: http://java.sun.com/javase/6/docs/technotes/guides/concurrency/threadPrimitiveDeprecation.html
                    suspended = true;
                }
                else
                {
                    tokens = in.split(" ");
                    if(suspended)
                    {
                        for (Map.Entry<Long, Counter> c : counters.entrySet())
                            c.getValue().resume(); //This method should not be used. Can cause deadlocks. See above...
                        suspended = false;
                    }
                    if(tokens[0].equals("start")) //Start new counter
                    {
                        tap = -1;
                        for(int i=0; i<taps.length; i++) //Find a free column for this counter
                        {
                            if(!taps[i])
                            {
                                tap=i;
                                taps[i] = true;
                                break;
                            }
                        }
                        if(tap>-1) //Start the counter
                        {
                            num = Integer.parseInt(tokens[1]);
                            Counter nc = new Counter(num, tap, taps, counters);
                            nc.setDaemon(true);
                            nc.start();
                            counters.put(nc.getId(), nc);

                        }
                        else
                        {
                            System.out.println("All counters used");
                        }
                    }
                    else if(tokens[0].equals("stop")) //Stop a counter
                    {
                        num = Integer.parseInt(tokens[1]);
                        try
                        {

                            counters.get((long)num).Stop(); //Stopping a thread this way instead of calling the stop method of the Thread class, gives a thread the chance to free resources.
                            taps[counters.get((long)num).getTap()] = false;
                            counters.remove((long)num);
                        }
                        catch(ThreadDeath td)
                        {
                        }
                    }
                    else if(tokens[0].equals("setmax")) //Set max of a counter
                    {
                        num = Integer.parseInt(tokens[1]);
                        tmp = Integer.parseInt(tokens[2]);
                        counters.get((long)num).setMax(tmp);
                    }
                    else if(tokens[0].equals("setvalue")) //Set value of a counter
                    {
                        num = Integer.parseInt(tokens[1]);
                        tmp = Integer.parseInt(tokens[2]);
                        counters.get((long)num).setCount(tmp);
                    }
                }

            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        while(!in.startsWith("quit"));

        for (Map.Entry<Long, Counter> c : counters.entrySet())
        {
            c.getValue().Stop();
            try {
                c.getValue().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}