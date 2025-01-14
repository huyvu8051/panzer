package com.huyvu.panzer;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game 2D with Multi-threading");


        // Tạo các entity
        Entity player = new Entity(1);
        player.position = new PositionComponent();
        player.velocity = new VelocityComponent();
        player.input = new InputComponent();

        KeyControlListener listener = new KeyControlListener(player);
        RenderSystem renderSystem = new RenderSystem(listener, player);
        frame.add(renderSystem);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);




        // Tạo các hệ thống
        InputSystem inputSystem = new InputSystem();
        MovementSystem movementSystem = new MovementSystem();



        // Vòng lặp game
        ExecutorService executor = Executors.newFixedThreadPool(3);

        var runner = new Runner(inputSystem, movementSystem, renderSystem, player);

        executor.submit(runner);
    }
}
