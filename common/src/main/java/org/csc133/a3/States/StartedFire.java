package org.csc133.a3.States;

import org.csc133.a3.gameobjects.ExtinguishFire;
import org.csc133.a3.gameobjects.Fire;

public class StartedFire extends State{
    private static StartedFire instance = new StartedFire();

    private StartedFire() {}

    public static StartedFire instance() {
        return instance;
    }

    @Override
    public void updateState(Fire fire) {
        // fire.setCurrentState(ExtinguishFire.instance());
    }
}
