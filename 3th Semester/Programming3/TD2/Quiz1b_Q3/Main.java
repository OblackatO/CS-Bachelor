package Quiz1b_Q3;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                JFrame  F = new JFrame("NumPad");
                F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                F.setSize(400, 300);
                F.setVisible(true);
                F.getContentPane().setLayout(new BorderLayout());

                JTextField  T   =   new JTextField();
                //T.setSize();
                F.getContentPane().add(T,BorderLayout.NORTH);

                JPanel  P = new JPanel();
                F.getContentPane().add(P,BorderLayout.CENTER);

                P.setBackground(Color.GREEN);

                /*adding 12 buttons with 400/3 width
                and 300/4 height.*/
                for(int i=1; i<13; i++){
                    JButton button_test = new JButton();
                    button_test.setBackground(Color.WHITE);
                    if(i == 10){
                        button_test.setText(".");
                    }else if(i == 11){
                        button_test.setText(Integer.toString(0));
                    }else if(i == 12){
                        button_test.setText("DEL");
                    }else{
                        button_test.setText(Integer.toString(i));
                    }

                    if(!( i == 12)){
                        button_test.addActionListener(e->
                            T.setText(T.getText()+button_test.getText())
                        );
                    }else {
                        button_test.addActionListener(e ->
                            T.setText("")
                        );
                    }
                    button_test.setPreferredSize(new Dimension(130,70));
                    P.add(button_test);
                }
            } });
    }
}