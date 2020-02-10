package Q1;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.text.DecimalFormat;

public class Controller implements DocumentListener {
    JTextField euros;
    JTextField bitcoins;
    double bitcoin_value = 0.00017600;
    DecimalFormat df = new DecimalFormat("#.####");

    public Controller   (JTextField T1,JTextField T2) {
        this.euros      =   T1;
        this.bitcoins   =   T2;
        /*Puts a property in the Document of each text field to easily identify them
        when Documentlistener is called*/
        this.euros.getDocument().putProperty("owner", this.euros);
        this.bitcoins.getDocument().putProperty("owner", this.bitcoins);
    }

    private String ConvertEurToBit(String euros){
        Double euros_double = Double.parseDouble(euros);
        return df.format(euros_double * this.bitcoin_value);
    }

    private String ConvertBitToEur(String bitcoins){
        Double bit_double = Double.parseDouble(bitcoins);
        return df.format(bit_double / this.bitcoin_value);
    }

    private void RemoveDocumentListener(JTextField text_field){
        text_field.getDocument().removeDocumentListener(this);
    }

    private void UpdateStateOfTextFields(JTextField text_field){
        if (text_field == euros) {
            RemoveDocumentListener(bitcoins);
            if(!euros.getText().isEmpty()){
                bitcoins.setText(ConvertEurToBit(euros.getText()));
            }else{
                bitcoins.setText("");
            }
            AddDocumentListener(bitcoins);
        }else{
            RemoveDocumentListener(euros);
            if(!bitcoins.getText().isEmpty()){
                euros.setText(ConvertBitToEur(bitcoins.getText()));
            }else{
                euros.setText("");
            }
            AddDocumentListener(euros);
        }
    }

    private void AddDocumentListener(JTextField text_field){
        text_field.getDocument().addDocumentListener(this);
    }

    //Methods to override with DocumentListener
    @Override
    public void insertUpdate(DocumentEvent e) {

        Runnable doupdate = new Runnable() {
            @Override
            public void run() {
                JTextField text_field = (JTextField) e.getDocument().getProperty("owner");
                UpdateStateOfTextFields(text_field);
            }
        };
        SwingUtilities.invokeLater(doupdate);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        Runnable doupdate = new Runnable() {
            @Override
            public void run() {
                JTextField text_field = (JTextField) e.getDocument().getProperty("owner");
                UpdateStateOfTextFields(text_field);
            }
        };
        SwingUtilities.invokeLater(doupdate);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}