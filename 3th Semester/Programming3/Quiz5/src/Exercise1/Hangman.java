package Exercise1;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Hangman {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame    F    =    new    JFrame();
                F.setTitle("Exercise1.Hangman");
                F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel    P    =    new HangmanPanel();

                F.getContentPane().add(P);

                F.setSize(400,400);
                F.setVisible(true);
            }
        });
    }
}