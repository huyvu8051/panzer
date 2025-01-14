package com.huyvu.panzer;

import javax.swing.*;
import java.awt.*;

public class RenderSystem extends JPanel {
    private final Entity entity;

    public RenderSystem(KeyControlListener kcl, Entity entity) {
        this.entity = entity;
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        addKeyListener(kcl);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect((int) entity.position.x, (int) entity.position.y, 50, 50);
    }
}
