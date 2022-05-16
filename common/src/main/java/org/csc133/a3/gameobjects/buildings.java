package org.csc133.a3.gameobjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public class buildings extends GameObjectCollection<building> {

    public buildings() {
        super();
        this.color = ColorUtil.rgb(255, 0, 0);
    }

    @Override
    public void updateLocalTransforms() {

    }

    @Override
    protected void localDraw(Graphics g, Point2D parentOrigin,
            Point2D screenOrigin) {

    }

    @Override
    public void draw(Graphics g, Point2D originParent, Point2D originScreen) {
        for (building building : getGameObjects()) {
            building.draw(g, originParent, originScreen);
        }
    }
}
