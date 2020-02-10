package Q1;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ColorList implements ListSelectionListener{

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                JFrame    F    =    new    JFrame();
                F.setTitle("Swing Color List");
                F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //main panel added to the window
                JPanel    P    =    new    JPanel(new GridLayout(1,2));


                JPanel color_panel = new JPanel();
                ColorPanel names_panel = new ColorPanel(color_panel);
                //names_panel.add(color_panel);

                P.add(new JScrollPane(names_panel));
                P.add(color_panel);

                F.getContentPane().add(P);

                F.setSize(400,400);
                F.setVisible(true);
            }
        });
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
