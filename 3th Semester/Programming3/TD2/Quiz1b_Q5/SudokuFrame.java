package Quiz1b_Q5;

import javax.swing.*;
import java.awt.*;

class SudokuFrame extends JFrame{

    //JButton verify_button;

    public SudokuFrame(){
        this.setSize(500,500);
        this.setTitle("Sudoku Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JPanel button_panel = new JPanel();
        //this.verify_button = new JButton("Verify");
        //button_panel.add(this.verify_button);
        //this.add(button_panel, BorderLayout.CENTER);
        this.setLayout(new GridLayout(3,3,5,5));
        for(int i=0; i<9; i++){
            this.add(createpanel());
        }
    }

    public JPanel createpanel(){
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(3,3,2,2);
        panel.setLayout(grid);
        for(int j=0; j<9; j++){
            JTextField text_field = new JTextField();
            text_field.setPreferredSize(new Dimension(5,5));
            text_field.setFont(new Font("Serif", Font.BOLD, 45));
            panel.add(text_field);
        }

        return panel;
    }

}