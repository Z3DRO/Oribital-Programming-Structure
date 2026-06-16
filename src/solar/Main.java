package solar;

import javax.swing.SwingUtilities;

public class Main 
{
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> 
        {
            SolarSystemFrame frame = new SolarSystemFrame();
            frame.setVisible(true);
        });
    }
}