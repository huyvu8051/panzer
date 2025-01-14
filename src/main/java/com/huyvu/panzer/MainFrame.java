package com.huyvu.panzer;

import com.artemis.World;
import com.artemis.injection.FieldResolver;
import com.artemis.utils.reflect.Field;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JPanel implements FieldResolver {

    public MainFrame(KeyControlListener kcl) {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        addKeyListener(kcl);
        setFocusable(true);
    }
    @Override
    public void initialize(World world) {

    }

    @Override
    public Object resolve(Object o, Class<?> aClass, Field field) {

        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
//        g.fillRect((int) entity.position.x, (int) entity.position.y, 50, 50);
    }


}
