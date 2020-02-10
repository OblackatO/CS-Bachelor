

public class Counter implements Runnable {

    //Maximum number the Counter is going to count to.
    private int number = 0;
    private int current_number = 0;

    //Used to printing purposes-
    int thread_nb = 0;
    public static int total_threads = 0;

    public Counter(int number){
        this.set_number(number);
        Counter.total_threads++;
        this.thread_nb = Counter.total_threads;
    }

    public void set_number(int number){
        this.number = number;
    }

    public int get_number(){
        return this.number;
    }

    public void set_current_number(int value){
        if(value > this.get_number()){
            System.out.println("Value is too big.");
            return;
        }
        this.current_number = value;
    }

    public int get_current_number(int value){
        return this.current_number;
    }

    @Override
    public void run() {
        int offset_value = 10*this.thread_nb;
        for(; this.current_number < this.number; this.current_number++){
            //Prints x times " " for the printing requirements of
            //the exercise.
            for(int j=0; j<offset_value; j++){
                System.out.print(" ");
            }

            System.out.println(Thread.currentThread().getId()+
                                ":"+this.current_number+
                                "/"+this.number);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.print("Thread was interrupted");
                e.printStackTrace();
            }
        }

        Counter.total_threads--;
    }
}
