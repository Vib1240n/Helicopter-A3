package org.csc133.a3.views;

import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

import org.csc133.a3.GameWorld;
import org.csc133.a3.gameobjects.GameObjects;

public class Mapview extends Container {

	private float Left, Right, Bottom, Top;
	private final GameWorld gw;

	public Mapview(GameWorld gw) {
		this.gw = gw;
	}

	@Deprecated
	public void Transform(Graphics g){
		Transform gXform = Transform.makeIdentity();
		g.getTransform(gXform);
		gXform.translate(getX(), getY());
		gXform.translate(0, getHeight());
		gXform.scale(1f, -1f);
		gXform.translate(-getX(), -getY());
		g.setTransform(gXform);
	}

	private Transform buildWorldToForm(float widht, float height, float Left, float Right){
		Transform Xform = Transform.makeIdentity();
		Xform.scale(1/widht, 1/height);
		Xform.translate(-Left, -Right);
		return Xform;
	}

	private Transform builddisplayToForm(float displayWidth, float displayHeight){
		Transform Xform = Transform.makeIdentity();
		Xform.scale(0, displayHeight);
		Xform.translate(displayWidth, -displayHeight);
		return Xform;
	}

	private void setup(Graphics g){
		Transform world, display, VTM;
		if(gw.isZoomed()){
			Left = (float)(-this.getWidth()/20);
			Bottom = (float)(-this.getHeight()/20);
			Right = (float)(-this.getWidth() * 1.05);
			Top = (float)(-this.getHeight() * 1.05);
		}else{
			Left = 0;
			Bottom = Left;
			Right = this.getWidth();
			Top = this.getHeight();
		}

		float Height = Top - Bottom;
		float Width = Right - Left;

		world = buildWorldToForm(Width, Height, Left, Bottom);
		display = builddisplayToForm(this.getWidth(), this.getHeight());
		VTM = display.copy();
		VTM.concatenate(world);
		
		Transform  Xform = Transform.makeIdentity();
		g.getTransform(Xform);
		Xform.translate(getAbsoluteX(), getAbsoluteY());
		Xform.concatenate(VTM);
		Xform.translate(-getAbsoluteX(), getAbsoluteY());
		g.setTransform(Xform);
	}

	private Transform getVTM () {
		Transform world, display, VTM;
		if (gw.isZoomed()) {
			Left = (float) (-this.getWidth() / 20);
			Bottom = (float) (-this.getHeight() / 20);
			Right = (float) (-this.getWidth() * 1.05);
			Top = (float) (-this.getHeight() * 1.05);
		} else {
			Left = 0;
			Bottom = Left;
			Right = this.getWidth();
			Top = this.getHeight();
		}

		float Height = Top - Bottom;
		float Width = Right - Left;

		world = buildWorldToForm(Width, Height, Left, Bottom);
		display = builddisplayToForm(this.getWidth(), this.getHeight());
		VTM = display.copy();
		VTM.concatenate(world);

		Transform Xform = Transform.makeIdentity();
		Xform.translate(getAbsoluteX(), getAbsoluteY());
		Xform.concatenate(VTM);
		Xform.translate(-getAbsoluteX(), getAbsoluteY());

		return VTM;
	}

	private Transform getInverseVTM(){
		Transform inverse = Transform.makeIdentity();
		try{
			getVTM().getInverse(inverse);
		}catch(Transform.NotInvertibleException e){
			e.printStackTrace();
		}
		return inverse;
	}

	private Point2D transform2D(Transform transform, Point2D p){
		float[] inside = new float[2];
		float[] outside = new float[2];

		inside[0] = (float)p.getX();
		inside[1] = (float)p.getY();

		transform.transformPoint(inside, outside);
		return new Point2D(outside[0], outside[1]);
	}

	@Override
	public void pressed(int x, int y){
		x = x - getAbsoluteX();
		y = y - getAbsoluteY();

		Point2D p = new Point2D(x, y);

		this.gw.Fire(p);
		this.gw.setCurve(transform2D(getInverseVTM(), new Point2D(x,y)));
	}

	public void Notify(){

	}

	@Override
	public void laidOut() {
		gw.setDimension(new Dimension(this.getWidth(), this.getHeight()));
		gw.init();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (GameObjects go : gw.getGameObjectCollection()) {
			go.draw(g, new Point(this.getX(), this.getY()));
		}
	}

}
