package Exercise4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class SnakePanel    extends    JPanel    implements    MouseMotionListener,ActionListener {

    ArrayList<Point>    A    =    new    ArrayList<Point>();

    public    SnakePanel() {
        addMouseMotionListener(this);
        setBackground(Color.WHITE);

        //Timer    timer = new Timer(50, this);
        //timer.start();
    }

    public    void    paintComponent    (Graphics    G) {
        super.paintComponent(G);

        Graphics2D    G2    =    (Graphics2D)    G;
        G2.setColor(Color.BLUE);
        for(Point p: this.A){
            G2.fillOval(p.x,p.y,20,25);
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {

        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        Point point = new Point(e.getX(),e.getY());
        this.A.add(point);
        repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

    }

}