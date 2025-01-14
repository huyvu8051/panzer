package com.huyvu.panzer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class GameExample extends JPanel implements Runnable  {
    List<Paintable> paintables;
    List<ControlListenable> controlListenables;
    private final ExecutorService executorService;
    KeyboardMouseControlHandler keyboardMouseControlHandler;
    Panzer panzer;

    // Constructor
    public GameExample() {
        keyboardMouseControlHandler = new KeyboardMouseControlHandler();
        paintables = new ArrayList<>();
        controlListenables = new ArrayList<>();
        panzer = new Panzer();

        paintables.add(panzer);
        controlListenables.add(panzer);

        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        addKeyListener(keyboardMouseControlHandler);
        addMouseMotionListener(keyboardMouseControlHandler);
        setFocusable(true);
        executorService = Executors.newFixedThreadPool(2);
        executorService.submit(this); // Chạy game loop trong luồng riêng
    }

    // Vẽ hình vuông
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Paintable paintable : paintables) {
            paintable.paint(g);
        }
    }

    @Override
    public void run() {
        while (true) {

            for (var controlListenable : controlListenables) {
                keyboardMouseControlHandler.apply(controlListenable);
            }

            repaint();
//
            try {
                Thread.sleep(16); // Khoảng 60 FPS
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Main method để chạy game
    public static void main(String[] args) {
        JFrame frame = new JFrame("Multi-threading");
        GameExample game = new GameExample();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
