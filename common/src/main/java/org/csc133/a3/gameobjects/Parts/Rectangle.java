package org.csc133.a3.gameobjects.Parts;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point2D;

import org.csc133.a3.gameobjects.*;

public class Rectangle extends GameObjects {

    @Override
    public void updateLocalTransforms() {
    };

    public Rectangle(int color,
            int width, int height,
            float tx, float ty,
            float sx, float sy,
            float degrees) {
        setColor(color);
        setDimension(new Dimension(width, height));
        translate(tx, ty);
        scale(sx, sy);
        rotate(degrees);

    }

    @Override
    protected void localDraw(Graphics g, Point2D parentOrigin, Point2D screenOrigin) {
        // TODO Auto-generated method stub
        g.setColor(getColor());
        containerTranslate(g, parentOrigin);
        cn1ForwardPrimitiveTranslate(g, getDimension());
        
    }
}