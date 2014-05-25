package com.anonynuts.swordplay;

import com.badlogic.gdx.Game;

/**
 * Main game startup class.
 */
public class SwordGame extends Game{

	@Override
	public void create() {
		setScreen(new MainMenu(this));
	}
}
