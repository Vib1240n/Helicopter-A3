package org.csc133.a3.gameobjects;

import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point2D;



public abstract class GameObjects{
    
    protected int color;
    protected Dimension dimension;
    protected Dimension worldSize;
    protected Transform myTranslation, myRotation, myScale;

    public GameObjects(){
        myTranslation = Transform.makeIdentity();
        myRotation = Transform.makeIdentity();
        myScale = Transform.makeIdentity();
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = new Dimension(dimension.getWidth(),
                dimension.getHeight());
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Point2D getLocation() {
        return new Point2D(myTranslation.getTranslateX(),
                myTranslation.getTranslateY());
    }

    public int getWidth() {
        return dimension.getWidth();
    }

    public int getHeight() {
        return dimension.getHeight();
    }

    public void rotate(double degrees) {
        myRotation.rotate((float) Math.toRadians(degrees), 0, 0);
    }

    public void scale(double sx, double sy) {
        myScale.scale((float) sx, (float) sy);
    }

    public void translate(double tx, double ty) {
        myTranslation.translate((float) tx, (float) ty);
    }

    private Transform gOrigXform;

    protected Transform preLTTransform(Graphics g, Point2D originScreen) {
        Transform gXform = Transform.makeIdentity();
        g.getTransform(gXform);
        gOrigXform = gXform.copy();
        gXform.translate((float)originScreen.getX(), (float)originScreen.getY());
        return gXform;
    }

    public abstract void updateLocalTransforms();

    protected void localTransforms(Transform gxForm) {
        gxForm.translate(myTranslation.getTranslateX(),
                myTranslation.getTranslateY());
        gxForm.concatenate(myRotation);
        gxForm.scale(myScale.getScaleX(), myScale.getScaleY());
    }

    protected void postLTTransform(Graphics g, Point2D originScreen,
            Transform gXform) {
        gXform.translate((float)-originScreen.getX(), (float)-originScreen.getY());
        g.setTransform(gXform);
    }

    protected void restoreOriginalTransform(Graphics g) {
        g.setTransform(gOrigXform);
    }

    protected void containerTranslate(Graphics g, Point2D parentOrigin) {
        Transform gxForm = Transform.makeIdentity();
        g.getTransform(gxForm);
        gxForm.translate((float)parentOrigin.getX(), (float)parentOrigin.getY());
        g.setTransform(gxForm);
    }

    protected void cn1ForwardPrimitiveTranslate(Graphics g,
            Dimension pDimension) {
        Transform gxForm = Transform.makeIdentity();
        g.getTransform(gxForm);
        gxForm.translate(-pDimension.getWidth() / 2,
                -pDimension.getHeight() / 2);
        g.getTransform(gxForm);
    }

    protected void cn1ReversePrimitiveTranslate(Graphics g,
            Dimension pDimension) {
        Transform gxForm = Transform.makeIdentity();
        g.getTransform(gxForm);
        gxForm.translate(pDimension.getWidth() / 2,
                pDimension.getHeight() / 2);
        g.getTransform(gxForm);
    }

    protected abstract void localDraw(Graphics g, Point2D parentOrigin,
            Point2D screenOrigin);

    public void draw(Graphics g, Point2D parentOrigin, Point2D screenOrigin) {
        Transform gXform = preLTTransform(g, screenOrigin);
        localTransforms(gXform);
        postLTTransform(g, screenOrigin, gXform);
        localDraw(g, parentOrigin, screenOrigin);
        restoreOriginalTransform(g);
    }

    public void updateTransform() {
    }
}