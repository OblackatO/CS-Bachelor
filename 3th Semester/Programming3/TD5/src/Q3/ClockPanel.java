package Q3;

import javax.swing.*;
import java.awt.*;

public class ClockPanel extends JPanel {

    private Color clock_color;

    public ClockPanel(Color color){
        this.clock_color = color;
        this.setBackground(this.clock_color);
        this.repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawOval(50,10,500,500);
        g.drawLine(100,200);
        /*
        for(int i=0; i<12; i++){
            g.drawLine();
        }
        */

    }
}
