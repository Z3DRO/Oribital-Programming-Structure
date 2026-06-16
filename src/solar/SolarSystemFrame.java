package solar;

import javax.swing.*;

public class SolarSystemFrame extends JFrame {

    public SolarSystemFrame() {
        setTitle("Solar System Simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        SolarSystemPanel panel = new SolarSystemPanel();
        add(panel);

        pack();
        setLocationRelativeTo(null);
    }
}