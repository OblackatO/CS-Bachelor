package Q4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ColorAction extends AbstractAction {

    JTextArea T;
    Color color;

    public ColorAction(JTextArea A, Color C, String Name){
        super(Name);
        this.T = A;
        this.color = C;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.T.setBackground(this.color);
    }
}
