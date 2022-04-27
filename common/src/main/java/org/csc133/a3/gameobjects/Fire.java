package org.csc133.a3.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;

import java.util.Random;

public class Fire extends Fixed {

	Point Location;
	private static Helicopter heli;
	private static int fire_size;
	private State currentState;
	private Dimension size;

	public Fire(){
	}
	
	public Fire(Dimension size, int fire_size) {
		this.size = size;
		Fire.fire_size = fire_size;
		currentState = UnstartedFire.instance();

	}

	public void Startfire(Point Location){
		this.Location = Location;
		this.currentState.updateState(this);
	}

	

	public State getState(){
		return currentState;
	}
	public Point location() {
		return Location;
	}

	public int size() {
		return fire_size;
	}

	public int getArea(){
		return (int)(Math.PI * (fire_size/2 * fire_size/2));
	}

	public void grow_fire() {
		if (fire_size < 470) {
			fire_size += new Random().nextInt(2);
		}
	}

	public void setCurrentState(State state){
		this.currentState = state;
	}

	public void extinguishFire() {
		fire_size -= heli.water_tank() /5;
	}

	@Override
	public void draw(Graphics g, Point containerOrigin) {
		if(this.currentState == StartedFire.instance() && fire_size> 0){
			g.setColor(ColorUtil.MAGENTA);
			g.fillArc(Location.getX() + containerOrigin.getX(), Location.getY() + containerOrigin.getY(), fire_size, fire_size, 0,
					360);

			g.setColor(ColorUtil.YELLOW);
			g.drawString("x: " + Location.getX() + ", " + "y: " + Location.getY(),
					Location.getX() + containerOrigin.getX(), Location.getY() + containerOrigin.getY());
		}
		
	}
}
