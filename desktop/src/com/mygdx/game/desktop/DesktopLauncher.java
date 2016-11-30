package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.SmartGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 483;
		config.height = 720;
		new LwjglApplication(new SmartGame(), config);
	}
}

// coucou
// bonjour je suis Alexis
// Bonjour Alexis, je suis Enzo ! 