package com.anonynuts.swordplay;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

/**
 * Main Menu
 */
public class MainMenu extends DefaultScreen {

	Skin startSkin;
	TextButton startButton;
	TextButton.TextButtonStyle startButtonStyle;

	Stage titleStage;
	SpriteBatch titleBatch;

	public MainMenu(Game game) {
		super(game);
	}

	@Override
	public void show() {
		titleBatch = new SpriteBatch();
		titleStage = new Stage();
		Gdx.input.setInputProcessor(titleStage);

		startSkin = new Skin();
		Pixmap pixmap = new Pixmap(100, 100, Pixmap.Format.RGBA8888);
		pixmap.setColor(Color.GREEN);
		pixmap.fill();

		startSkin.add("white", new Texture(pixmap));

		BitmapFont bfont=new BitmapFont();
		bfont.scale(1);
		startSkin.add("default", bfont);

		startButtonStyle = new TextButton.TextButtonStyle();

		startButtonStyle.up = startSkin.newDrawable("white", Color.DARK_GRAY);
		startButtonStyle.down = startSkin.newDrawable("white", Color.DARK_GRAY);
		startButtonStyle.checked = startSkin.newDrawable("white", Color.BLUE);
		startButtonStyle.over = startSkin.newDrawable("white", Color.LIGHT_GRAY);

		startButtonStyle.font = startSkin.getFont("default");

		startSkin.add("default", startButtonStyle);

		final TextButton startButton = new TextButton("PLAY",startButtonStyle);
		startButton.setPosition(200, 200);
		startButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(new SlashPracticeScreen(game));
			}
		});
		titleStage.addActor(startButton);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		titleStage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		titleStage.draw();
		Table.drawDebug(titleStage);
	}
}
