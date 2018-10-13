package Q1;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                ConverterFrame converterframe = new ConverterFrame();
                JTextField t1 = converterframe.gett1();
                JTextField t2 = converterframe.gett2();
                Controller controller = new Controller(t1,t2);
                t1.getDocument().addDocumentListener(controller);
                t2.getDocument().addDocumentListener(controller);
                converterframe.setVisible(true);
            }
        });
    }

}