package com.anonynuts.swordplay;

import com.badlogic.gdx.Gdx;

/**
 * Listener to execution action based on gesture.
 */
public class SlashListener {

	private CutType cutType;

	public SlashListener() {
		this.cutType = CutType.REST;
	}

	public void slashLeft() {
		cutType = cutType.TONDO;
		Gdx.app.debug(SlashListener.class.getName(), cutType.display());
	}

	public void slashRight() {
		cutType = cutType.RIVERSO_TONDO;
		Gdx.app.debug(SlashListener.class.getName(), cutType.display());
	}

	public void slashUp() {
		cutType = cutType.MONTANTE;
		Gdx.app.debug(SlashListener.class.getName(), cutType.display());
	}

	public void slashDown() {
		cutType = cutType.FEDENTE;
		Gdx.app.debug(SlashListener.class.getName(), cutType.display());
	}

	public String getCutTypeDisplay() {
		return cutType.display();
	}

	public boolean isCorrectCut(CutType currentCut) {
		return this.cutType == currentCut;
	}

}
