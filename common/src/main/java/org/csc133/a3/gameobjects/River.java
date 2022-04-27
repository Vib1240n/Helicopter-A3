package org.csc133.a3.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import org.csc133.a3.Game;

public class River extends Fixed{
    Point Location;
    private final int river_width;
    private final int river_height;
    private final Dimension size;

    public River(Dimension size) {
        //pass in size
        this.size = size;
		Location = new Point(size.getHeight() - size.getHeight(), size.getWidth()/7);
		river_height = 150;
		river_width = size.getWidth() - 10;
	}

    /**
     * Getter methods for correct collision checking for helicopter
     */
    public Point getLocation() {
        return Location;
    }

    public int get_river_width() {
        return river_width;
    }

    public int get_river_height() {
        return river_height;
    }
    /*
     * Draw method for river
     */
	@Override
	public void draw(Graphics g, Point containerOrigin) {

		g.setColor(ColorUtil.BLUE);
        g.drawRect(Location.getX() + containerOrigin.getX(), Location.getY() + containerOrigin.getY(), river_width, river_height);
	}
}
