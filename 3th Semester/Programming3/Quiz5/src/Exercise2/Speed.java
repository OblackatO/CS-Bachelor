package Exercise2;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Speed {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame    F    =    new    JFrame();
                F.setTitle("Speedmeter");
                F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JSlider    S    =    new    JSlider(0, 180,0);
                JPanel    P    =    new    SpeedPanel(S.getModel());

                F.getContentPane().add(P);
                F.getContentPane().add(S,BorderLayout.SOUTH);

                F.setSize(400,400);
                F.setVisible(true);
            }
        });
    }
}