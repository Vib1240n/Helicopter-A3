package org.csc133.a3.gameobjects;


public abstract class Fixed extends GameObjects{
    public Fixed(){
		super();
	}

	public boolean isCollidingWith(Helicopter helicopter) {
		return false;
	}

}
