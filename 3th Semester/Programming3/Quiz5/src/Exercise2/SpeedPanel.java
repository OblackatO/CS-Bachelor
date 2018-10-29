package Exercise2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BoundedRangeModel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpeedPanel    extends    JPanel    implements    ChangeListener {

    BoundedRangeModel    M;
    Boolean speed_triggered = false;

    public    SpeedPanel(BoundedRangeModel    newM) {
        setBackground(Color.WHITE);
        repaint();
        this.M = newM;
        this.M.addChangeListener(this);
    }

    public    void    paintComponent    (Graphics    G) {
        super.paintComponent(G);
        Graphics2D    G2    =    (Graphics2D)    G;
        G2.setColor(Color.RED);
        G2.fillArc(70,200,230,250,0,30);
        G2.setColor(Color.YELLOW);
        G2.fillArc(70,200,230,250,30,60);
        G2.setColor(Color.GREEN);
        G2.fillArc(70,200,230,250,90,90);
        if(this.speed_triggered){
            G2.setColor(Color.BLACK);
            G2.fillArc(70,200,230,250,this.M.getValue(),5);
        }

        // ADD CODE HERE
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.speed_triggered = true;
        repaint();
    }

    // ADD CODE HERE
}