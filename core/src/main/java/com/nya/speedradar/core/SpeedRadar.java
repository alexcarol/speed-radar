package com.nya.speedradar.core;

import playn.core.Game;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;

import java.util.ArrayList;

import static playn.core.PlayN.*;

public class SpeedRadar extends Game.Default {

  private int h, w;
  private KeyboardListener keyboardListener = new KeyboardListener();
  private GameGUI gameGUI = new GameGUI();
  private ArrayList<GameElement> gameElements = new ArrayList<GameElement>();
  private Background background;
  private Car car;

  public SpeedRadar() {
    super(33); // call update every 33ms (30 times per second)
  }

  @Override
  public void init() {
    // create and add background image layer

    h = graphics().height();
    w = graphics().width();

    System.out.println("height : " + h + " width : " + w);

    car = CarFactory.createCar(1, w, h);

    GroupLayer bichosLayer = graphics().createGroupLayer();
    bichosLayer.add(car.getLayer());
    
    background = new Background(w, h);
    gameElements.add(background);
    gameElements.add(car);
    
    graphics().rootLayer().add(bichosLayer);

    keyboardListener.add(car);
    keyboardListener.add(gameGUI);
    keyboard().setListener(keyboardListener);
  }

  @Override
  public void update(int delta) {
    if (gameGUI.isPaused()) {
      return;
    }

    background.setVelocity(car.getVerticalVelocity());
    
    //updating all game elements
    for (int i = 0; i < gameElements.size(); ++i) {
      gameElements.get(i).update(delta);
    }

    
  }

  @Override
  public void paint(float alpha) {
    // the background automatically paints itself, so no need to do anything here!
  }
}
