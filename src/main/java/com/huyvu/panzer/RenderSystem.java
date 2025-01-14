package com.huyvu.panzer;

import com.artemis.BaseSystem;
import com.artemis.ComponentMapper;
import com.artemis.annotations.All;
import com.artemis.annotations.Wire;
import com.artemis.systems.IteratingSystem;

import javax.swing.*;
import java.awt.*;

@All(PositionComponent.class)
public class RenderSystem extends IteratingSystem {
    protected ComponentMapper<PositionComponent> positionMapper;

    /*@Wire
    public MainFrame mainFrame;
*/

    @Override
    protected void process(int i) {
        var pos = positionMapper.get(i);
        System.out.println(pos);
    }
}
