package Q3;

import javax.swing.*;
import java.awt.*;

public class Clock extends JFrame {

    private String name;

    public Clock(String name){
        this.name = name;
        this.setTitle(this.name);
        this.setSize(new Dimension(600,600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
