package com.huyvu.panzer;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;


public class DesktopLauncher {
    public static void main (String[] arg) {
        var config = new Lwjgl3ApplicationConfiguration();
        config.setWindowedMode(800, 600);

        new Lwjgl3Application(new GameScreen(), config);
    }
}