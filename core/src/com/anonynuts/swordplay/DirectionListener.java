package com.anonynuts.swordplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by LFTUltimate on 27/04/14.
 */
public class DirectionListener extends GestureDetector.GestureAdapter {

	private SlashListener slashListener;

	public DirectionListener(SlashListener slashListener) {
		this.slashListener = slashListener;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		if(Math.abs(velocityX)>Math.abs(velocityY)){
			if(velocityX>0){
				slashListener.slashRight();
			}else{
				slashListener.slashLeft();
			}
		} else{
			if(velocityY>0){
				slashListener.slashDown();
			}else{
				slashListener.slashUp();
			}
		}
		slashListener.endSlash();
		return super.fling(velocityX, velocityY, button);
	}

}
