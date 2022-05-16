package org.csc133.a3.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public class Fires extends GameObjectCollection<Fire> {

    public Fires() {
        super();
        this.color = ColorUtil.MAGENTA;
    }

    @Override
    public void updateLocalTransforms() {
    }

    // a collection of fire
    //
    @Override
    public void draw(Graphics g, Point2D originParent, Point2D originScreen) {
        for (Fire fires : getGameObjects()) {
            fires.draw(g, originParent, originScreen);
        }
    }

    @Override
    protected void localDraw(Graphics g, Point2D parentOrigin, Point2D screenOrigin) {
        // TODO Auto-generated method stub
        
    }
}
