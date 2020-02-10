package Q2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountryFrame extends JFrame implements ActionListener {

    final    String[] Countries    =    new String[]{"Afghanistan","Albania","Algeria","Andorra","Angola","Antigua & Deps","Argentina","Armenia",
            "Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize",
            "Benin","Bhutan","Bolivia","Bosnia Herzegovina","Botswana","Brazil","Brunei","Bulgaria","Burkina","Burundi",
            "Cambodia","Cameroon","Canada","Cape Verde","Central African Rep","Chad","Chile","China","Colombia","Comoros",
            "Congo","Congo {Democratic Rep}","Costa Rica","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti",
            "Dominica","Dominican Republic","East Timor","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea",
            "Estonia","Ethiopia","Fiji","Finland","France","Gabon","Gambia","Georgia","Germany","Ghana","Greece","Grenada",
            "Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Honduras","Hungary","Iceland","India","Indonesia","Iran",
            "Iraq","Ireland","Israel","Italy","Ivory Coast","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kiribati",
            "Korea North","Korea South","Kosovo","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya",
            "Liechtenstein","Lithuania","Luxembourg","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta",
            "Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro",
            "Morocco","Mozambique","Myanmar","Namibia","Nauru","Nepal","Netherlands","New Zealand","Nicaragua","Niger",
            "Nigeria","Norway","Oman","Pakistan","Palau","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland",
            "Portugal","Qatar","Romania","Russian Federation","Rwanda","St Kitts & Nevis","St Lucia",
            "Saint Vincent & the Grenadines","Samoa","San Marino","Sao Tome & Principe","Saudi Arabia","Senegal","Serbia",
            "Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa",
            "South Sudan","Spain","Sri Lanka","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan",
            "Tajikistan","Tanzania","Thailand","Togo","Tonga","Trinidad & Tobago","Tunisia","Turkey","Turkmenistan","Tuvalu",
            "Uganda","Ukraine","United Arab Emirates","United Kingdom","United States","Uruguay","Uzbekistan","Vanuatu",
            "Vatican City","Venezuela","Vietnam","Yemen","Zambia","Zimbabwe"};

    JList left_list = null;
    JList right_list = null;

    JButton    B1    =    new    JButton    (">>>");
    JButton    B2    =    new    JButton    ("<<<");
    JButton    B3    =    new    JButton    ("ALL >>>");
    JButton    B4    =    new    JButton    ("<<< ALL");

    DefaultListModel<String> left_model = null;
    DefaultListModel<String> right_model = null;

    public CountryFrame(){
        this.setTitle("List Exchange");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel    P    =    new    JPanel(new GridLayout(1,3));

        this.left_model =    new    DefaultListModel<String>();
        this.right_model =    new    DefaultListModel<String>();
        this.left_list    =    new    JList(this.left_model);
        this.right_list    =    new    JList(this.right_model);

        for (String S : Countries) {
            this.left_model.addElement(S);
        }

        this.B1.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.B2.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.B3.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.B4.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.B1.addActionListener(this);
        this.B2.addActionListener(this);
        this.B3.addActionListener(this);
        this.B4.addActionListener(this);

        JPanel    ButtonPanel    =    new    JPanel();
        ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.PAGE_AXIS));
        ButtonPanel.add(Box.createVerticalGlue());
        ButtonPanel.add(this.B1, BorderLayout.CENTER);
        ButtonPanel.add(this.B2, BorderLayout.CENTER);
        ButtonPanel.add(this.B3, BorderLayout.CENTER);
        ButtonPanel.add(this.B4, BorderLayout.CENTER);
        ButtonPanel.add(Box.createVerticalGlue());

        P.add(new JScrollPane(this.left_list));
        P.add(ButtonPanel);
        P.add(new JScrollPane(this.right_list));

        this.getContentPane().add(P);
        this.setSize(400,400);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.print("ActionPerformed was called.");
        if(e.getSource() == this.B1){
            for(Object country: this.left_list.getSelectedValuesList()){
                String country_str = (String) country;
                this.right_model.addElement(country_str);
                this.left_model.removeElement(country_str);
            }
        }else if(e.getSource() == this.B2){
            for(Object country: this.right_list.getSelectedValuesList()){
                String country_str = (String) country;
                this.left_model.addElement(country_str);
                this.right_model.removeElement(country_str);
            }
        }else if(e.getSource() == this.B3){
            for(Object country: this.left_model.toArray()){
                String country_str = (String) country;
                this.right_model.addElement(country_str);
                this.left_model.removeElement(country_str);
            }
        }else if(e.getSource() == this.B4){
            for(Object country: this.right_model.toArray()){
                String country_str = (String) country;
                this.left_model.addElement(country_str);
                this.right_model.removeElement(country_str);
            }
        }
    }
}
