package com.huyvu.panzer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class GameScreen extends ApplicationAdapter {
    private SpriteBatch batch;
    private Sprite box;
    private float boxX;

    @Override
    public void create () {
        batch = new SpriteBatch();
        Texture boxTexture = new Texture("box.png"); // Ensure you have a 'box.png' texture
        box = new Sprite(boxTexture);
        box.setPosition(0, 300);  // Set initial position of the box
        boxX = 0;
    }

    @Override
    public void render () {
        // Clear the screen with a black background
        GL20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        GL20.glClearColor(0, 0, 0, 1);  // Clear to black

        batch.begin();
        box.setPosition(boxX, box.getY());  // Move box
        box.draw(batch);  // Draw box

        batch.end();

        // Move the box across the screen
        boxX += 2;
        if (boxX > 800) {
            boxX = 0;  // Reset position when box reaches the edge
        }
    }


    @Override
    public void dispose() {
        batch.dispose();
        box.getTexture().dispose();
    }
}