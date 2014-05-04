package com.anonynuts.swordplay;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;

import java.util.Random;

public class Swordplay extends ApplicationAdapter {

	CutType[] cutTypes = new CutType[]{CutType.TONDO, CutType.RIVERSO_TONDO, CutType.FEDENTE, CutType.MONTANTE};
	CutType currentCutType;

	SpriteBatch batch;
	BitmapFont font;
	DirectionListener directionListener;
	SlashListener slashListener;
	GestureDetector gestureDetector;

	Random random;
	String hitMessage;
	int width;
	int height;

	@Override
	public void create () {
		random = new Random();
		hitMessage = "";
		int newCutIndex = random.nextInt(cutTypes.length);
		currentCutType = cutTypes[newCutIndex];

		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		slashListener = new SlashListener();
		directionListener = new DirectionListener(slashListener);
		gestureDetector = new GestureDetector(directionListener);

		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		Gdx.input.setInputProcessor(gestureDetector);
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
		super.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.app.log("Slasher", slashListener.getCutTypeDisplay());

		batch.begin();
		font.draw(batch, currentCutType.display(), 200, 400);

		if (Gdx.input.justTouched()) {
			if (slashListener.isCorrectCut(currentCutType)) {
				hitMessage = "DIRECT HIT!!!";
				int newCutIndex = random.nextInt(cutTypes.length);
				currentCutType = cutTypes[newCutIndex];
			} else {
				hitMessage = "MISS!";
			}
		}

		font.draw(batch, hitMessage, 200, 200);

		batch.end();
	}
}
