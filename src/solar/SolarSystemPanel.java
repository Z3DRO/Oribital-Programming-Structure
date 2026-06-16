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
            Graphics2D g2 = (Graphics2D) g;
          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int cx = getWidth() / 2;
            int cy = getHeight() / 2;

            drawStars(g2);
            drawOrbits(g2, cx, cy);
            drawSun(g2, cx, cy);
            drawPlanets(g2);
    }
    private void drawStars(Graphics2D g2) {
    g2.setColor(new Color(255, 255, 255, 100));
    for (int i = 0; i < 200; i++) {
        int x = (int)(Math.random() * WIDTH);
        int y = (int)(Math.random() * HEIGHT);
        g2.fillOval(x, y, 2, 2);
    }
}

private void drawOrbits(Graphics2D g2, int cx, int cy) {
    g2.setColor(new Color(255, 255, 255, 30));
    for (Planet p : planets) {
        int r = (int) p.getOrbitRadius();
        g2.drawOval(cx - r, cy - r, r * 2, r * 2);
    }
}

private void drawSun(Graphics2D g2, int cx, int cy) {
    g2.setColor(new Color(255, 200, 50));
    g2.fillOval(cx - 28, cy - 28, 56, 56);
    g2.setColor(new Color(255, 220, 100));
    g2.setFont(new Font("Segoe UI", Font.BOLD, 11));
    g2.drawString("Sun", cx - 11, cy + 42);
}

private void drawPlanets(Graphics2D g2) {
    for (Planet p : planets) {
        int px = p.getX();
        int py = p.getY();
        int r  = (int) p.getSize();

        g2.setColor(p.getColor());
        g2.fillOval(px - r, py - r, r * 2, r * 2);

        g2.setColor(new Color(220, 220, 220, 200));
        g2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        g2.drawString(p.getName(), px + r + 3, py + 4);
    }
}
}
