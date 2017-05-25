package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

/**
 * Created by Vineeth on 5/25/17.
 */

public class Square extends Actor{
    Sprite squareImage = new Sprite(new Texture(Gdx.files.internal("square/square.png")));

    public Square (){
        setBounds(getX(),getY(),squareImage.getWidth(),squareImage.getHeight());
        setTouchable(Touchable.enabled);
        addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (event.getTarget() instanceof Square){
                    MoveToAction moveToAction = new MoveToAction();
                    moveToAction.setPosition(500f,500f);
                    moveToAction.setDuration(3f);

                    ScaleToAction scaleToAction = new ScaleToAction();
                    scaleToAction.setScale(2f);
                    scaleToAction.setDuration(1f);
                    SequenceAction sequenceAction = new SequenceAction();
                    sequenceAction.addAction(moveToAction);
                    sequenceAction.addAction(scaleToAction);
                    sequenceAction.addAction(Actions.removeActor());
                    addAction(sequenceAction);
                }
                return true;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        squareImage.draw(batch);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        squareImage.setPosition(getX(),getY());
        squareImage.setScale(getScaleX(),getScaleY());
    }


}


