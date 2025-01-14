package com.huyvu.panzer;

import com.artemis.Entity;
import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.artemis.WorldConfigurationBuilder;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game 2D with Multi-threading");
        // 1. Register any plugins, setup the world.

        var kcListener = new KeyControlListener();
        var mainFrame = new MainFrame(kcListener);
        frame.add(mainFrame);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        WorldConfiguration setup = new WorldConfigurationBuilder()
                .with(new MovementSystem(),
                        new RenderSystem()
                        )
                .register(mainFrame)
                .build();

        var world = new World(setup);

        // Tạo các entity
        int entityId = world.create();

        var posComp = world.edit(entityId).create(PositionComponent.class);
        posComp.x = 100;
        posComp.y = 200;

        var velComp = world.edit(entityId).create(VelocityComponent.class);
        velComp.vx = 10;
        velComp.vy = 10;

        world.setDelta(0.5f);
        world.process();

        var timer = new Timer(16, e -> mainFrame.repaint());
        timer.start();


        /* */


        // Vòng lặp game
        ExecutorService executor = Executors.newFixedThreadPool(3);

    }
}
