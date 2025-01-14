package com.huyvu.panzer;

public class MovementSystem {
    public void update(Entity player, float deltaTime) {
        // Cập nhật vị trí dựa trên vận tốc và thời gian delta
        player.position.x += player.velocity.vx * deltaTime;
        player.position.y += player.velocity.vy * deltaTime;
    }
}
