package org.csc133.a3.gameobjects;

public class StartedFire extends State{
    private static StartedFire instance = new StartedFire();

    private StartedFire() {}

    public static StartedFire instance() {
        return instance;
    }

    @Override
    public void updateState(Fire fire) {
        fire.setCurrentState(ExtinguishFire.instance());
    }
}
