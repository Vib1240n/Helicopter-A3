package org.csc133.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.UITimer;
import org.csc133.a3.commands.*;
import org.csc133.a3.views.ControlCluster;
import org.csc133.a3.views.GlassCockpit;
import org.csc133.a3.views.Mapview;

import static com.codename1.ui.CN.SIZE_SMALL;

public class Game extends Form implements Runnable {
    public static Font font = Font.createSystemFont(Font.FACE_SYSTEM,
            Font.STYLE_PLAIN, SIZE_SMALL);
    private final GameWorld world;
    Mapview mapview;
    ControlCluster clusterView;
    GlassCockpit cockpitView;
    UITimer timer;
    private int tick;
    //private customContainer heloHolder;

    public Game() {
        world = new GameWorld();
        mapview = new Mapview(world);
        clusterView = new ControlCluster(world);
        cockpitView = new GlassCockpit(world);
        //heloHolder = new customContainer();
        tick = 0;
        timer = new UITimer(this);
        this.setLayout(new BorderLayout());
        this.getStyle().setBgColor(ColorUtil.BLACK);
        this.add(BorderLayout.NORTH, cockpitView);
        this.add(BorderLayout.CENTER, mapview);
        //this.add(BorderLayout.CENTER, heloHolder);
        this.add(BorderLayout.SOUTH, clusterView);
        timer.schedule(100, true, this);
        addKeyListener('Q', new exit(world));
        addKeyListener(-93, new TurnLeftCommand(world));
        addKeyListener(-94, new TurnRightCommand(world));
        addKeyListener(-91, new Accelerate(world));
        addKeyListener(-92, new Brake(world));
        addKeyListener('d', new Drink(world));
        addKeyListener('f', new Fight(world));
        this.show();
        //heloHolder.init();

    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void run() {
        int return_tick = Tick();
        // world.updateTick(return_tick);
        cockpitView.update();
        repaint();
    }

    // Counts number of total ticks
    public int Tick() {
        tick++;
        return tick;
    }
}
