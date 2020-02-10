package Q3;

import javax.swing.*;
import java.awt.*;

public class ToggleFrame extends JFrame{

    public ToggleFrame(){
        this.setTitle("Toggle Grid Exercise");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().setBackground(Color.GREEN);
        this.getContentPane().setLayout(new GridLayout(4,4,5,5));

        for (int i=0 ; i<16 ; i++) {
            this.getContentPane().add(new MyButton());
        }

        this.setSize(400,400);
    }
}
