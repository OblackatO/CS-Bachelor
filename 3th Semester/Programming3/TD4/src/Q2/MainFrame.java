package Q2;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

public class MainFrame extends JFrame{


    public MainFrame(){
        this.setTitle("SameModel Exercise");
        this.setSize(new Dimension(600,600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new GridLayout(6,1));

        Document main_doc = new JTextField().getDocument();
        for(int i=0; i<3; i++){
            JTextField textfield = new JTextField();
            textfield.setDocument(main_doc);
            this.getContentPane().add(textfield);
        }

        BoundedRangeModel main_model = new JSlider().getModel();
        for(int i=0; i<3; i++){
            JSlider slider = new JSlider();
            slider.setModel(main_model);
            this.getContentPane().add(slider);
        }
    }
}
