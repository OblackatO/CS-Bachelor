package Q1;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.HashMap;

public class ColorPanel extends JPanel implements ListSelectionListener {


    final HashMap<String, Color> M    =    new    HashMap<String, Color>();
    JPanel colored_panel = null;
    JList colored_list = null;

    public ColorPanel(JPanel colored_panel){
        this.colored_panel = colored_panel;
        M.put("Black"    ,    new    Color(0,0,0));
        M.put("White"    ,    new    Color(255,255,255));
        M.put("Red"        ,    new    Color(255,0,0));
        M.put("Lime"    ,    new    Color(0,255,0));
        M.put("Blue"    ,    new    Color(0,0,255));
        M.put("Yellow"    ,    new    Color(255,255,0));
        M.put("Cyan"    ,    new    Color(0,255,255));
        M.put("Magenta"    ,    new    Color(255,0,255));
        M.put("Silver"    ,    new    Color(192,192,192));
        M.put("Gray"    ,    new    Color(128,128,128));
        M.put("Maroon"    ,    new    Color(128,0,0));
        M.put("Olive"    ,    new    Color(128,128,0));
        M.put("Green"    ,    new    Color(0,128,0));
        M.put("Purple"    ,    new    Color(128,0,128));
        M.put("Teal"    ,    new    Color(0,128,128));
        M.put("Navy"    ,    new    Color(0,0,128));

        //Creates default list to put the color names there.
        DefaultListModel names = new DefaultListModel();
        for(String color: this.M.keySet()){
            names.addElement(color);
        }

        JList color_list = new JList(names);
        this.colored_list = color_list;
        this.colored_list.addListSelectionListener(this);
        this.add(this.colored_list);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        String color_name = (String) this.colored_list.getSelectedValue();

        for (HashMap.Entry<String, Color> entry : this.M.entrySet()) {
            if(entry.getKey().equals(color_name)){
                this.colored_panel.setBackground(entry.getValue());
            }
        }
    }

}
