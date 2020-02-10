package Exercise3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class PacManPanel    extends    JPanel    implements    MouseMotionListener,ActionListener {

    boolean mouth_closed = false;
    int mouse_positionX = 0;
    int mouse_positionY = 0;

    public    PacManPanel() {
        addMouseMotionListener(this);
        setBackground(Color.CYAN);
        Timer    timer = new Timer(500, this);
        Runnable mouth = new Runnable() {
            @Override
            public void run() {
                timer.start();
            }
        };
        SwingUtilities.invokeLater(mouth);

    }

    public    void    paintComponent    (Graphics    G) {
        super.paintComponent(G);

        Graphics2D    G2    =    (Graphics2D)    G;
        G2.setColor(Color.YELLOW);
        if(!this.mouth_closed){
            G2.fillArc(this.mouse_positionX-50, this.mouse_positionY-70, 100, 150,20,330);
        }else{
            G2.fillArc(this.mouse_positionX-50, this.mouse_positionY-70, 100, 150,0,360);
        }
        this.mouth_closed = !this.mouth_closed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.mouse_positionX = e.getX();
        this.mouse_positionY = e.getY();
        repaint();
    }

}
