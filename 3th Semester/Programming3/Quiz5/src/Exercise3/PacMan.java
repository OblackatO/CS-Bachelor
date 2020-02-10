package Exercise3;

import javax.swing.*;

public class PacMan {

    public static void main(String[] args) {

        Runnable runny = new Runnable() {
            @Override
            public void run() {
                JFrame    F    =    new    JFrame();
                F.setTitle("PacMan");
                F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel    P    =    new    PacManPanel();

                F.getContentPane().add(P);

                F.setSize(400,400);
                F.setVisible(true);
            }
        };

        SwingUtilities.invokeLater(runny);

    }
}