package com.nya.speedradar.core;

import playn.core.Game;
import playn.core.GroupLayer;

import java.util.ArrayList;
import java.util.Iterator;

import static playn.core.PlayN.*;

public class SpeedRadar extends Game.Default {

  private int h, w;
  private KeyboardListener keyboardListener = new KeyboardListener();
  private GameGUI gameGUI = new GameGUI();
  private ArrayList<GameElement> gameElements = new ArrayList<GameElement>();
  private Background background;
  private Car car;
  private Iterator<Pole> poleIterator;
  Pole nextPole;

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
    
    background = new Background(w, h, car);
    gameElements.add(background);
    gameElements.add(car);
    
    graphics().rootLayer().add(bichosLayer);

    keyboardListener.add(car);
    keyboardListener.add(gameGUI);
    keyboard().setListener(keyboardListener);
    
    poleIterator = background.getRadarList().getPoleIterator();
    nextPole = poleIterator.next();
  }

  @Override
  public void update(int delta) {
      
    if (gameGUI.isPaused()) {
      return;
    }
    
    //updating all game elements
    for (GameElement element : gameElements) {
      element.update(delta);
    }
    
    // Check if car traversing pole
     
    while (-nextPole.positionY <= car.getPixelsTravelled()) {
        if (nextPole.radar) {
            System.out.println("HAY RADAR!! GAME OVR!");
        }
        
        if (poleIterator.hasNext()) {
            nextPole = poleIterator.next();
        } else {
            
        }
    }
  }

  @Override
  public void paint(float alpha) {
    // the background automatically paints itself, so no need to do anything here!
  }
}
