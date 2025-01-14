package com.huyvu.panzer;

import com.artemis.ComponentMapper;
import com.artemis.annotations.All;
import com.artemis.systems.IteratingSystem;

@All(PositionComponent.class)
public class MovementSystem extends IteratingSystem {
    protected ComponentMapper<PositionComponent> positionMapper;
    protected ComponentMapper<VelocityComponent> velocityMapper;

    @Override
    protected void process(int i) {
        var position = positionMapper.get(i);
        var velocity = velocityMapper.get(i);
        position.x += velocity.vx;
        position.y += velocity.vy;
    }
}
