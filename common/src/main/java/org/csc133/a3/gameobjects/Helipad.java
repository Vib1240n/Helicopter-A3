package org.csc133.a3.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

public class Helipad extends Fixed {
	public Point centerLocation;
	protected int boxSize;
	protected int fuel;
	Point location;
	private Dimension worldSize;

	/*
	 * Helipad constructor
	 */
	public Helipad (Dimension worldSize) {
		this.worldSize = worldSize;
		setColor(ColorUtil.GRAY);
		this.dimension = new Dimension(200, 200);
		translate(0, -worldSize.getHeight() / 3);
		translate(worldSize.getWidth() / 2, worldSize.getHeight() / 2);
	}

	public boolean isCollidingWith(Helicopter helicopter) {
		return super.isCollidingWith(helicopter);
	}

	@Override
	public void updateLocalTransforms() {
	}

	@Override
	protected void localDraw(Graphics g, Point2D parentOrigin,
			Point2D screenOrigin) {
		g.setColor(getColor());
		containerTranslate(g, parentOrigin);
		cn1ForwardPrimitiveTranslate(g, getDimension());
		g.drawRect(-getWidth() / 2, -getHeight() / 2,
				getWidth(), getHeight(), 5);
		g.drawArc(-(int) (getWidth() * .9) / 2, -(int) (getWidth() * .9) / 2,
				(int) (getWidth() * .9), (int) (getHeight() * .9),
				0, 360);
	}
}
