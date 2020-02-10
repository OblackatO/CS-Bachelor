package Quiz1b_Q4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockFrame extends JFrame{

    private JLabel time_label;

    public ClockFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setTitle("Clock");
        this.time_label = new JLabel();
        this.time_label.setSize(100,125);
        this.time_label.setFont(new Font("Serif", Font.BOLD, 45));
        add(this.time_label, BorderLayout.BEFORE_LINE_BEGINS);
    }

    public void DisplayTime(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        this.time_label.setText(sdf.format(cal.getTime()));
    }
}
