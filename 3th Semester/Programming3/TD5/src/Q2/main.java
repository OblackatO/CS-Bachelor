package Q2;


import javax.swing.*;
import java.awt.*;

public class main {

    public static void main(String[] args){
        MainFrame main_frame = new MainFrame();

        DotsPanel panel = new DotsPanel();
        main_frame.add(panel);

        JButton button = new JButton("Clear");
        button.addActionListener(panel);
        main_frame.add(button, BorderLayout.SOUTH);

        main_frame.setVisible(true);

    }
}
