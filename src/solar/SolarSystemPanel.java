package solar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class SolarSystemPanel extends JPanel implements ActionListener 
{

    private static final int WIDTH  = 900;
    private static final int HEIGHT = 700;

    private Timer timer;
    private List<Planet> planets;

    public SolarSystemPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(new Color(5, 5, 20));
        initPlanets();
        timer = new Timer(16, this);
        timer.start();
    }

    private void initPlanets() 
    {
        planets = new ArrayList<>();
        planets.add(new Planet("Mercury", 80,  5,  0.047, 0.0,          new Color(169, 169, 169)));
        planets.add(new Planet("Venus",   120, 9,  0.018, 1.0,          new Color(230, 190, 100)));
        planets.add(new Planet("Earth",   170, 10, 0.011, 2.0,          new Color(70,  130, 200)));
        planets.add(new Planet("Mars",    225, 7,  0.006, 3.0,          new Color(188, 74,  60)));
        planets.add(new Planet("Jupiter", 305, 20, 0.003, 1.5,          new Color(210, 170, 120)));
        planets.add(new Planet("Saturn",  395, 16, 0.002, 4.0,          new Color(210, 195, 140)));
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        int cx = getWidth() / 2;
        int cy = getHeight() / 2;
        for (Planet p : planets) {
            p.update();
            p.calculatePosition(cx, cy);
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        // Kriti draws everything here
    }
}