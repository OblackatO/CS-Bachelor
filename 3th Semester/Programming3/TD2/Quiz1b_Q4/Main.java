package Quiz1b_Q4;

public class Main {
    public static void main(String[] args) {
        ClockFrame clock_frame = new ClockFrame();
        clock_frame.setVisible(true);
        while(true){
            clock_frame.DisplayTime();
        }
    }
}
