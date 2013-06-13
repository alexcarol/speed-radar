package com.nya.speedradar.core;

import java.awt.Color;
import playn.core.Font;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Key;
import playn.core.Keyboard;
import playn.core.Layer;
import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import static playn.core.PlayN.keyboard;

public class IntroState extends State<SpeedRadar> implements Keyboard.Listener{

    int h, w;
    int msElapsed;
    
    Layer pressStartLayer;
    private boolean startPressed;

    @Override
    public void Enter(SpeedRadar owner) {
        h = graphics().height();
        w = graphics().width();

        // Create title layer
        Image titleImg = assets().getImage("images/title1.png");
        ImageLayer titleLayer = graphics().createImageLayer(titleImg);
        titleLayer.setWidth(w * 0.8f);
        titleLayer.setHeight(h / 4);
        titleLayer.setTranslation(w * 0.1f, h * 0.2f);
        graphics().rootLayer().add(titleLayer);

        // Create "PRESS START" text layer
        int fontSize = 22; // TODO: Fix magic number
        String text = "PRESS START";
        pressStartLayer = Util.createMessageText(text, fontSize, 0xFFFFFFFF);
        pressStartLayer.setTranslation(w*0.35f, h*0.6f);
        graphics().rootLayer().add(pressStartLayer);

        // Init vars and listeners
        msElapsed = 0;
        startPressed = false;
        keyboard().setListener(this);
    }

    @Override
    public void Update(SpeedRadar owner, int delta) {
        msElapsed += delta;
        if (msElapsed >= 1000) {
            pressStartLayer.setVisible(!pressStartLayer.visible());
            msElapsed = 0;
        }
    }

    @Override
    public void Exit(SpeedRadar owner) {
        // Clear graphics
        graphics().rootLayer().clear();
    }

    @Override
    public void GoNextState(StateMachine<SpeedRadar> fsm) {
        if (startPressed) {
            fsm.ChangeState(new GameState());
        }
    }

    @Override
    public void onKeyDown(Keyboard.Event event) {
        if (event.key() == Key.ENTER) {
            startPressed = true;
        }
    }

    @Override
    public void onKeyTyped(Keyboard.TypedEvent event) {
        
    }

    @Override
    public void onKeyUp(Keyboard.Event event) {
        
    }
}
