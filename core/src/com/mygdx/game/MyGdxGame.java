package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TextureAtlas textureAtlas;
	TextureRegion textureRegion;
	Sprite sprite;
	Animation<TextureRegion> stillAnimation;
	Animation movingAnimation;
	float timeForStill = 0.0f;
	int x = 0;
	int y = 0;


	@Override
	public void create () {
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("SpriteSheet/girlrunning.atlas"));
		stillAnimation = new Animation(1/10f,textureAtlas.getRegions());
		//This will display 10 frames in one second
		//1/20 will display 20 frames in one second

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		timeForStill += Gdx.graphics.getDeltaTime();
		//Keeps track of the amount of total time that has passed
		batch.draw(stillAnimation.getKeyFrame(timeForStill,true),x+Gdx.graphics.getDeltaTime(),y+Gdx.graphics.getDeltaTime());
		//this is automatically change the frames based on the time that has passed

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
