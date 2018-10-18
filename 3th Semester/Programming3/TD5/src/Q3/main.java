package Q3;

import java.awt.*;

public class main{

    public static void main(String[] args) {
        Clock clock = new Clock("NiceClock");
        ClockPanel clock_panel = new ClockPanel(Color.ORANGE);
        clock.add(clock_panel);
        clock.setVisible(true);
    }
}

