package org.csc133.a3.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import org.csc133.a3.Game;
import org.csc133.a3.interfaces.Steerable;

import java.util.Random;

public class Helicopter extends Movable implements Steerable {
    static Point location;
    static River river;
    static com.codename1.ui.geom.Point river_location;
    static Point fire_location;
    private static int heli_radius;
    private final Helipad heli;
    private int fuel;
    private int speed;
    private static double angle;
    private static int endX;
    private static int endY;
    private static int startX;
    private static int startY;
    private static int water_tank;
    private static boolean isColliding;
    private static boolean isCollidingfire;
    private final int boxSize;
    private static Random rand;
    private final int heli_size;
    private Dimension worldSize;

    public Helicopter(Dimension Size) {
        this.worldSize = Size;
        water_tank = 0;
        isColliding = false;
        river = new River(Size);
        heli = new Helipad(worldSize);
        isCollidingfire = false;
        river_location = river.getLocation();
        location = heli.getCenter();
        boxSize = heli.boxSize;
        heli_size = 35;
        heli_radius = heli_size / 2;
        angle = Math.toRadians(90);
        endX = location.getX();
        endY = location.getY() + heli_radius * 3;
        startX = location.getX();
        startY = location.getY();
        rand = new Random();
        fuel = 12000;
    }

    public void moveForward() {
        if (speed < 10) {
            speed++;
        }
    }

    public void brake() {
        if (speed > 0) {
            speed--;
        }
    }

    @Override
    public void steerLeft() {
        angle += Math.toRadians(15);
        endX = (int) (endX + Math.cos(angle));
        endY = (int) (endY - Math.sin(angle));
    }

    // heading math.todegrees getter method
    @Override
    public void steerRight() {
        angle -= Math.toRadians(15);
        endY = (int) (endX - Math.sin(angle));
        endX = (int) (endY + Math.cos(angle));
    }

    public int water_tank() {
        return water_tank;
    }

    public void updateForward() {

        location.setX((int) (location.getX() + Math.cos(angle) * speed));
        startX = location.getX();
        location.setY((int) (location.getY() - Math.sin(angle) * speed));
        startY = location.getY();
        endY = (int) (location.getY() - Math.sin(angle));
        endX = (int) (location.getX() + Math.cos(angle) + heli_radius * 3);
        fuel -= Math.max(startX, startY) * Math.tan(angle);
        setFuel(fuel);
    }

    public int getHeading() {
        return (int) (endX);
    }

    public void isCollison() {
        if (startX > river_location.getX() && startX < (river_location.getX()
                + river.get_river_width())) {
            isColliding = startY > river_location.getY() &&
                    startY < river_location.getY() + river.get_river_height();

        } else {
            isColliding = false;
        }
    }

    public boolean isCollisionFire(Fires fires) {
        for (Fire fire : fires) {
            if (startX > fire.location().getX() && startX < (fire.location().getX() + fire.size())) {
                isCollidingfire = startY > fire.location().getY() && startY < fire.location().getY() + fire.size();
                if (isCollidingfire && fire.size() > 0) {
                    return true;
                }
            }
            isCollidingfire = true;
        }
        return false;
    }

    public int get_speed() {
        return this.speed;
    }

    public void fillTank() {
        if (isColliding && water_tank < 1000) {
            water_tank += 100;
        }
    }

    public int getFuel() {
        return fuel;
    }

    protected void setFuel(float fuel) {
        fuel = fuel;
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        // TODO Auto-generated method stub add container origin
        g.setFont(Game.font);
        g.setColor(ColorUtil.YELLOW);
        g.fillArc((startX - heli_radius) + containerOrigin.getX(),
                (startY - heli_radius) + containerOrigin.getY(),
                heli_size, heli_size, 0, 360);
        g.setColor(ColorUtil.YELLOW);
        g.drawLine(startX + containerOrigin.getX(), startY + containerOrigin.getY(),
                endX + containerOrigin.getX(), endY + containerOrigin.getY());
        g.drawString("Speed: " + speed,
                (startX + 15) + containerOrigin.getX(), (startY + 15) + containerOrigin.getY());

        g.setColor(ColorUtil.YELLOW);
        g.drawString("Water: " + water_tank,
                (heli.getCenter().getX() - boxSize / 2) + containerOrigin.getX(),
                ((heli.getCenter().getY() + 40) + boxSize / 2) + containerOrigin.getY());
    }
}
