package com.huyvu.panzer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class KeyboardMouseControlHandler implements KeyListener, MouseMotionListener {
    Keyboard kb;
    Mouse mouse;

    KeyboardMouseControlHandler(){
        kb = new Keyboard();
        mouse = new Mouse();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: kb.up = true; break;
            case KeyEvent.VK_S: kb.down = true; break;
            case KeyEvent.VK_A: kb.left = true; break;
            case KeyEvent.VK_D: kb.right = true; break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: kb.up = false; break;
            case KeyEvent.VK_S: kb.down = false; break;
            case KeyEvent.VK_A: kb.left = false; break;
            case KeyEvent.VK_D: kb.right = false; break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        // Update mouse coordinates when the mouse is moved
        this.mouse.posX = e.getX();
        this.mouse.posY = e.getY();


        //repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    public void apply(ControlListenable controlListenable) {
        controlListenable.listen(kb, mouse);
    }
}
