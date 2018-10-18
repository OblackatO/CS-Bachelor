package Q2;

import javax.swing.*;

public class MainFrame extends JFrame{

    public MainFrame(){
        this.add(new DotsPanel());
        this.setSize(600,600);
        this.setTitle("Points");

    }

}
