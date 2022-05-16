package org.csc133.a3.gameobjects;

import org.csc133.a3.States.State;

public class ExtinguishFire extends State{
    private static ExtinguishFire instance = new ExtinguishFire();

    private ExtinguishFire() {}

    public static ExtinguishFire instance() {
        return instance;
    }

    @Override
    public void updateState(Fire fire) {
        
    }
}
