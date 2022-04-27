package org.csc133.a3.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class buildings extends GameObjectCollection<building>{
    
    private int color;

    public buildings(){
        super();
        this.color = ColorUtil.red(255);
    }

    @Override
    public void draw(Graphics g, Point containerOrigin) {
        for (building building : getGameObjects()) {
            building.draw(g, containerOrigin);
        }
    }
}
