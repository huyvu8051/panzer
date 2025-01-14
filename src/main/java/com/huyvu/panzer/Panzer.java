package com.huyvu.panzer;

import java.awt.*;

public class Panzer implements ControlListenable, Paintable {
    int posX, posY;
    int turretX, turretY;
    int speed;
    Panzer(){
        posX = 0;
        posY = 0;
        turretX = 0;
        turretY = 0;
        speed = 5;
    }



    public void listen(Keyboard kb, Mouse mouse) {
        if (kb.up) this.posY -= speed;
        if (kb.down) this.posY += speed;
        if (kb.left) this.posX -= speed;
        if (kb.right) this.posX += speed;

        this.turretX = mouse.posX;
        this.turretY = mouse.posY;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(this.posX, this.posY, 50, 50);
        if (this.turretX >= 0 && this.turretY >= 0) {
            g.drawString("Mouse at: (" + this.turretX + ", " + this.turretY + ")", this.turretX, this.turretY);
            g.drawLine(this.posX,this.posY,this.turretX,this.turretY);
        }
    }
}
