package Q1;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class GeoPanel extends JPanel {

    public GeoPanel(){
        this.setBackground(Color.WHITE);
    }

    public    void    paintComponent    (Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(300, 200,100,100);
        g.setColor(Color.RED);
        g.fillRect(200,200,100,100);
        g.setColor(Color.BLACK);
        g.drawRect(300,300,100,100);
        g.setColor(Color.GREEN);
        g.fillRect(200,300,100,100);


        System.out.println("paint(.)");
    }

    public void CreateLines(Graphics g){

    }
}
