package Quiz1b_Q2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameX extends JFrame implements ActionListener {

    private JLabel counting_label;
    private JButton clicking_button;
    private static int clicks_count = 0;
    private static String label_text = "Click count:";

    public FrameX(){
        //Frames settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setTitle("Click Counter");

        //Creates label and button
        this.counting_label = new JLabel(label_text);
        this.counting_label.setHorizontalAlignment(JLabel.CENTER);
        this.clicking_button = new JButton("Click HERE");
        this.clicking_button.addActionListener(this);

        //Adds labels and button to frame
        add(this.counting_label);
        add(this.clicking_button, BorderLayout.SOUTH);
    };

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.clicking_button){
            this.clicks_count++;
            this.counting_label.setText(this.label_text+Integer.toString(
                                                                    this.clicks_count));
        }
    }
}
