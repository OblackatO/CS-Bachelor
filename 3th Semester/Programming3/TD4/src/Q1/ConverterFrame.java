package Q1;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ConverterFrame extends JFrame {

    private JTextField t1 = new JTextField(20);
    private JTextField t2 = new JTextField(20);

    public ConverterFrame(){
        this.setSize(600,600);
        this.setTitle("Euro -- BitCoin converter");
        //this.setPreferredSize(new Dimension(600,600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(2,1));

        this.t1   =   new JTextField(20);
        this.t2   =   new JTextField(20);


        this.t1.setBorder(CreateTitleBorder("euros"));
        this.t2.setBorder(CreateTitleBorder("bitcoin"));
        this.getContentPane().add(this.t1);
        this.getContentPane().add(this.t2);
    }

    private static TitledBorder CreateTitleBorder(String title){
        Border blackline = BorderFactory.createLineBorder(Color.black,3);
        TitledBorder titledborder = new TitledBorder(blackline, title);
        titledborder.setTitleFont(new Font("serif", Font.BOLD, 20));
        titledborder.setTitlePosition(TitledBorder.CENTER);
        return titledborder;
    }

    public JTextField gett1(){return this.t1;}
    public JTextField gett2(){return this.t2;}
}
