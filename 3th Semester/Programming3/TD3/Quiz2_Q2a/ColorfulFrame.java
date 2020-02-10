package Quiz_Q2a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ColorfulFrame extends JFrame {

    public final String static_text = "Hello ";

    public ColorfulFrame(){
        this.setTitle("JMenu Exercise");
        this.setSize(650,650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel    B    =    new    JLabel();
        B.setText("Hello Bob !");
        B.setFont(new Font("serif", Font.BOLD, 25));
        B.setOpaque(true);
        B.setHorizontalAlignment(JLabel.CENTER);
        this.add(B);

        JMenuBar menu_bar = this.createJMenuBar();
        JMenu color_menu = this.createJMenu("Color");

        //Creates three menu items for colors
        JMenuItem item1 = new JMenuItem(new AbstractAction("red") {
            @Override
            public void actionPerformed(ActionEvent e) {
                B.setBackground(Color.red);
            }
        });
        item1.setFont(new Font("Serif", Font.HANGING_BASELINE, 15));
        item1.setForeground(Color.red);

        JMenuItem item2 = new JMenuItem(new AbstractAction("blue") {
            @Override
            public void actionPerformed(ActionEvent e) {
                B.setBackground(Color.blue);
            }
        });
        item2.setFont(new Font("Serif", Font.HANGING_BASELINE, 15));
        item2.setForeground(Color.blue);

        JMenuItem item3 = new JMenuItem(new AbstractAction("green") {
            @Override
            public void actionPerformed(ActionEvent e) {
                B.setBackground(Color.green);
            }
        });
        item3.setFont(new Font("Serif", Font.HANGING_BASELINE, 15));
        item3.setForeground(Color.green);
        //adds colors to menu
        color_menu.add(item1);
        color_menu.add(item2);
        color_menu.add(item3);
        menu_bar.add(color_menu);

        //Creates Menu for names
        JMenu names_menu = this.createJMenu("names");
        //creates MenuTimes for the actual names
        JMenuItem name_item1 = new JMenuItem(new AbstractAction("Alice") {
            @Override
            public void actionPerformed(ActionEvent e) {
                B.setText(static_text+"Alice !");
            }
        });
        names_menu.add(name_item1);

        JMenuItem name_item2 = new JMenuItem(new AbstractAction("Bob") {
            @Override
            public void actionPerformed(ActionEvent e) {
                B.setText(static_text+"Bob !");
            }
        });
        names_menu.add(name_item2);

        JMenuItem name_item3 = new JMenuItem(new AbstractAction("Carol") {
            @Override
            public void actionPerformed(ActionEvent e) {
                B.setText(static_text+"Carol !");
            }
        });
        names_menu.add(name_item3);


        menu_bar.add(names_menu);
        this.setJMenuBar(menu_bar);

    }

    public JMenuBar createJMenuBar(){
        JMenuBar M = new JMenuBar();
        return M;
    }

    public JMenu createJMenu(String menu_name){
        JMenu menu = new JMenu(menu_name);
        menu.setFont(new Font("Serif", Font.BOLD, 20));
        return menu;
    }

    public void ChangeFrameColor(Color color){
        this.setBackground(color);
    }

    /*
    public JMenuItem createJMenuItem(String item_name){
        JMenuItem menu_item = new JMenuItem(item_name);
        return menu_item;
    }
    */

}
