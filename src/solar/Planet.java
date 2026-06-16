package solar;

import java.awt.Color;

public class Planet 
{
    private String name;
    private double orbitRadius;
    private double size;
    private double speed;
    private double angle;
    private Color color;
    private int x, y;

    public Planet(String name, double orbitRadius, double size, double speed, double startAngle, Color color) 
    {
        this.name = name;
        this.orbitRadius = orbitRadius;
        this.size = size;
        this.speed = speed;
        this.angle = startAngle;
        this.color = color;
    }

    public void update() 
    {
        angle += speed;
        if (angle > 2 * Math.PI) angle -= 2 * Math.PI;
    }

    public void calculatePosition(int centerX, int centerY) 
    {
        x = (int) (centerX + orbitRadius * Math.cos(angle));
        y = (int) (centerY + orbitRadius * Math.sin(angle));
    }

    public String getName()        { return name; }
    public double getOrbitRadius() { return orbitRadius; }
    public double getSize()        { return size; }
    public Color getColor()        { return color; }
    public int getX()              { return x; }
    public int getY()              { return y; }
}