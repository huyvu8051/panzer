package com.huyvu.panzer;

public class InputSystem {
    public void update(Entity player) {
        if (player.input.moveUp) {
            player.velocity.vy = 1;
        } else if (player.input.moveDown) {
            player.velocity.vy = -1;
        } else {
            player.velocity.vy = 0;
        }

        if (player.input.moveLeft) {
            player.velocity.vx = -1;
        } else if (player.input.moveRight) {
            player.velocity.vx = 1;
        } else {
            player.velocity.vx = 0;
        }
    }
}
