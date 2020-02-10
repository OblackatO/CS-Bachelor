package Q3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton implements ActionListener {

    boolean StarState = false;

    public MyButton(){
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!StarState){
            System.out.print("Not star detected.");
            setText("*");
            StarState = true;
        }else{
            setText("");
        }
    }
}
