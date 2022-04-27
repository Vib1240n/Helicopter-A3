package org.csc133.a3.gameobjects;


import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class building extends Fixed {
    private int building_height;
    private int building_width;
	private int building_value;
    private int TotalNumFires;
    private Point location;
    Fire fire;

    public building(Point location, int height, int width, int value){
        this.building_height = height;
        this.building_width = width;
		this.building_value = value;
        this.location = location;
        this.TotalNumFires = 0;
    }

    public int height(){
        return this.building_height;
    }
    public int width(){
        return this.building_width;
    }
    public void setFireInBuilding(Fire f){ 
        this.fire = f;
        if(building_width != 0 && building_height != 0){
            Point new_location = new Point( new Random().nextInt(building_width) +location.getX(), new Random().nextInt(building_height) + location.getY());
            f.Startfire(new_location);
            this.TotalNumFires +=1;
        }
    }

    public void setNewValue(){

    }

    @Override
    public void draw(Graphics g, Point containerOrigin){
		g.setColor(ColorUtil.rgb(255,0,0));
		g.drawString("V: " + this.building_value,
				location.getX() + building_width,
				location.getY() + (int)(building_height / 1.2));

        g.setColor(ColorUtil.rgb(255, 0, 0));
        g.drawRect(location.getX() + containerOrigin.getX(), location.getY() 
                + containerOrigin.getY(), building_width, building_height);
    }

    public int getValue() {
        return this.building_value;
    }

}
