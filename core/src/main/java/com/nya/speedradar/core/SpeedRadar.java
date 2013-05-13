package com.nya.speedradar.core;

import static playn.core.PlayN.*;

import playn.core.*;

import java.util.ArrayList;
import java.util.Queue;

public class SpeedRadar extends Game.Default {
    
  private ImageLayer[] bgLayers;
  private int h, w;
  private KeyboardListener keyboardListener = new KeyboardListener();

  private ArrayList<GameElement> gameElements = new ArrayList<GameElement>();

  public SpeedRadar() {
    super(33); // call update every 33ms (30 times per second)
  }

  @Override
  public void init() {
    // create and add background image layer

    h = graphics().height();
    w = graphics().width();

    System.out.println("height : " + h + " width : " + w);

    Image bgImage = assets().getImage("images/road.png");
    bgLayers = new ImageLayer[3];
    for (int i = 0; i < 3; ++i) {
        bgLayers[i] = graphics().createImageLayer(bgImage);
        bgLayers[i].setHeight(h);
        bgLayers[i].setWidth(w);
        
        bgLayers[i].setTranslation(0, (i-2)*h);
    }

    Car car = new Car("images/car.png", w, h);

    GroupLayer bichosLayer = graphics().createGroupLayer();
    bichosLayer.add(car.getLayer());

    gameElements.add(car);

    for (int i = 0; i < 3; ++i) graphics().rootLayer().add(bgLayers[i]);
    graphics().rootLayer().add(bichosLayer);

    keyboard().setListener(keyboardListener);
    keyboard().setListener(car);
  }

  @Override
  public void update(int delta) {
    for (int i = 0; i < gameElements.size(); ++i) {
      gameElements.get(i).update(delta);
    }

    for (int i = 0; i < 3; ++i) {
        bgLayers[i].setTy(bgLayers[i].ty()+ delta/10.0f);
    }

    if (bgLayers[2].ty() > h) {
        bgLayers[2].setTranslation(0, bgLayers[0].ty() - h);

        for (int i = 2; i > 0; --i) {
            ImageLayer aux = bgLayers[i];
            bgLayers[i] = bgLayers[i-1];
            bgLayers[i-1] = aux;
        }
    }
  }

  @Override
  public void paint(float alpha) {
    // the background automatically paints itself, so no need to do anything here!
  }
}
