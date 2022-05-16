package org.csc133.a3.States;

import org.csc133.a3.gameobjects.Fire;

public class UnstartedFire extends State {
    private static UnstartedFire instance = new UnstartedFire();

    private UnstartedFire() {}

    public static UnstartedFire instance() {
        return instance;
    }

    // Business logic and state transition
    @Override
    public void updateState(Fire fire) {
        // fire.setCurrentState(StartedFire.instance());
    }
}
