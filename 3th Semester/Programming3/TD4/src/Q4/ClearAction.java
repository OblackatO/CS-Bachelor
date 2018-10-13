package Q4;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ClearAction extends AbstractAction {

    JTextArea T;

    public ClearAction(JTextArea A) {
        super("Clear");
        this.T = A;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        T.setText("");
    }
}
