package Q2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DotsPanel extends JPanel implements MouseListener, ActionListener {

    private ArrayList<Point> points = new ArrayList<Point>();


    public DotsPanel(){
        setBackground(Color.WHITE);
        addMouseListener(this);
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        if(this.points != null){
            for(int i=0; i< this.points.size(); i++){
                System.out.print("Filling point.\n");
                Point p = this.points.get(i);
                g.fillOval(p.x,p.y,7,7);
            }
        }
    }

    private void removePoints(){
        /*Tried to remove each point from ArrayList, instead of
        setting it to null, but it was not fast enough.*/
       this.points = null;
       repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.removePoints();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.points == null){
            this.points = new ArrayList<Point>();
        }
        points.add(e.getPoint());
        repaint();
    }

    //Rest of the methods do not need to be implemented
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
