package org.csc133.a3.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;

public class Helipad extends Fixed {
	public Point centerLocation;
	private final int padSize;
	private final int radius;
	protected int boxSize;
	protected int fuel;
	Point location;
	private Dimension worldSize;

	/*
	 * Helipad constructor
	 */
	public Helipad(Dimension worldSize) {
		boxSize = 200;
		padSize = 150;
		radius = padSize / 2;
		// location = new Point((worldSize.getHeight() / 2) - 25,
		// 		(worldSize.getWidth()/ 2) + 500);
		location = new Point(worldSize.getWidth() / 2 - boxSize / 2,
				(int) (worldSize.getHeight() - (boxSize * 1.5)));
		centerLocation = new Point(location.getX() + boxSize / 2,
				location.getY() + boxSize / 2);
		fuel = 12000;
	}

	public Point getCenter() {
		return centerLocation;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	@Override
	public void draw(Graphics g, Point containerOrigin) {
		g.setColor(ColorUtil.GRAY);
		g.drawRect(location.getX() + containerOrigin.getX(),
				location.getY() + containerOrigin.getY(), 200, 200);

		/*
		 * Fuel label drawing
		 */
		g.setColor(ColorUtil.YELLOW);
		g.drawString("Fuel: " + (int) fuel,
				(centerLocation.getX() - boxSize / 2) + containerOrigin.getX(),
				((centerLocation.getY() + 5) + boxSize / 2) + containerOrigin.getY());
		/*
		 * Helipad inner circle design
		 */
		g.setColor(ColorUtil.GRAY);
		g.drawArc((centerLocation.getX() - radius) + containerOrigin.getX(),
				(centerLocation.getY() - radius) + containerOrigin.getY(), padSize,
				padSize, 0, 360);
	}
}
