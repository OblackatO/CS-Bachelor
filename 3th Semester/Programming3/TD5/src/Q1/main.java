package Q1;

import java.awt.*;

public class main {

    public static void main(String[] args){
        GeoFrame frame = new GeoFrame();
        GeoPanel panel = new GeoPanel();

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
