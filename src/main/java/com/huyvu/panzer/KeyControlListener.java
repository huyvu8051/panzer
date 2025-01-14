package com.huyvu.panzer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControlListener implements KeyListener {
    @Override
    public void keyPressed(KeyEvent e) {
       /* switch (e.getKeyCode()) {
            case KeyEvent.VK_W: entity.input.moveUp = true; break;
            case KeyEvent.VK_S: entity.input.moveDown = true; break;
            case KeyEvent.VK_A: entity.input.moveLeft = true; break;
            case KeyEvent.VK_D: entity.input.moveRight = true; break;
        }*/
    }

    @Override
    public void keyReleased(KeyEvent e) {
       /* switch (e.getKeyCode()) {
            case KeyEvent.VK_W: entity.input.moveUp = false; break;
            case KeyEvent.VK_S: entity.input.moveDown = false; break;
            case KeyEvent.VK_A: entity.input.moveLeft = false; break;
            case KeyEvent.VK_D: entity.input.moveRight = false; break;
        }*/
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
