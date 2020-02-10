package Q4;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

public class MainFrame extends JFrame {

    JMenuBar menubar;
    JMenu menu;
    JTextArea TA;
    String[] colors = {"RED", "GREEN", "BLUE"};

    public MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setTitle("Texteditor Exercise");

        this.TA = new JTextArea();
        this.TA.setFont(new Font("Serif",Font.BOLD,14));
        this.getContentPane().add(this.TA);

        CreateUpBar();
        this.setJMenuBar(this.menubar);
        this.add(CreateBottonBar(), BorderLayout.SOUTH);
    }

    private Color StringtoColor(String color_name){
        Color color;
        try {
            Field field = Class.forName("java.awt.Color").getField(color_name);
            color = (Color) field.get(null);
        } catch (Exception e) {
            color = null; // Not defined
        }
        return color;
    }

    private JToolBar CreateBottonBar(){
        JToolBar bar = new JToolBar();
        for(int i=0; i<this.colors.length; i++) {
            JButton button = new JButton(this.colors[i]);
            button.addActionListener(new ColorAction(this.TA,
                                                    StringtoColor(this.colors[i]),
                                                    this.colors[i]));
            bar.add(button);
        }

        return bar;
    }

    private void CreateUpBar(){
        this.menubar = new JMenuBar();
        this.menu = new JMenu();
        this.menubar.add(this.menu);

        //Create File Menu and its Items
        JMenu menu1 = new JMenu("File");
        JMenuItem menu1_item1 = new JMenuItem("Exit");
        menu1_item1.addActionListener(new ExitAction());
        JMenuItem menu1_item2 = new JMenuItem("Clear");
        menu1_item2.addActionListener(new ClearAction(this.TA));
        //Adds both items to the menu
        menu1.add(menu1_item1);
        menu1.add(menu1_item2);

        //Create Color Menu and its Items
        JMenu menu2 = new JMenu("Color");
        for(int i=0; i<this.colors.length; i++){
            JMenuItem color_item = new JMenuItem(this.colors[i]);
            color_item.addActionListener(new ColorAction(this.TA,
                    this.StringtoColor(this.colors[i]),
                    this.colors[i]));
            menu2.add(color_item);
        }

        this.menubar.add(menu1);
        this.menubar.add(menu2);
    }

}
