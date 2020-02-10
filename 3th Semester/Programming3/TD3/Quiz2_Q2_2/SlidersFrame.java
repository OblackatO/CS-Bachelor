package Quiz_Q2_2;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SlidersFrame extends JFrame {

    public JSlider[] jsliders_array;
    public String[] colors = {"red", "green", "blue"};


    public SlidersFrame(){
        //Init vars
        this.jsliders_array = new JSlider[3];
        this.setTitle("Color Sliders Exercise");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ADD TOP PANEL
        JPanel    P1    =    new JPanel();

        //Panel with sliders
        JPanel    P2    =    new JPanel();
        P2.setLayout(new GridLayout(3,1,100,5));
        ChangeListener L    = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                P1.setBackground(new Color(jsliders_array[0].getValue(),
                                           jsliders_array[1].getValue(),
                                           jsliders_array[2].getValue()
                                ));
            }
        };

        for(int i=0; i<3; i++){
            JSlider slider = new JSlider(0,225,0);
            slider.addChangeListener(L);
            slider.setMajorTickSpacing(50);
            //slider.setMinorTickSpacing(1);
            slider.setPaintTicks(true);
            slider.setPaintLabels(true);
            TitledBorder title_border = createTitledBorder(this.colors[i]);
            slider.setBorder(title_border);
            this.jsliders_array[i] = slider;
            P2.add(slider);
        }

        this.getContentPane().add(P1);
        this.getContentPane().add(P2, BorderLayout.SOUTH);
        this.setSize(650,650);

    }

    public TitledBorder createTitledBorder(String title_text){
        Border blackline = BorderFactory.createLineBorder(Color.black);
        TitledBorder title_border = BorderFactory.createTitledBorder(blackline,title_text);
        return title_border;
    }


}
