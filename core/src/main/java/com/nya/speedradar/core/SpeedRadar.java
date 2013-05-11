package com.nya.speedradar.core;

import static playn.core.PlayN.*;

import playn.core.*;

import java.util.Queue;

public class SpeedRadar extends Game.Default {

  private KeyboardListener keyboardListener = new KeyboardListener();

  public SpeedRadar() {
    super(33); // call update every 33ms (30 times per second)
  }

  @Override
  public void init() {
    // create and add background image layer

    float h = graphics().height();
    float w = graphics().width();

    System.out.println("height : " + h + " width : " + w);

    Image bgImage = assets().getImage("images/road.png");
    ImageLayer bgLayer = graphics().createImageLayer(bgImage);
    bgLayer.setSize(w, h);

    Image carImage = assets().getImage("images/car.png");
    ImageLayer carLayer = graphics().createImageLayer(carImage);

    carLayer.setWidth(w / 8);
    carLayer.setHeight(w/8);

    carLayer.setTranslation(w/2 - 5, h  - carLayer.height() * 2);

    GroupLayer bichosLayer = graphics().createGroupLayer();
    bichosLayer.add(carLayer);


    graphics().rootLayer().add(bgLayer);
    graphics().rootLayer().add(bichosLayer);

    keyboard().setListener(keyboardListener);
  }

  @Override
  public void update(int delta) {

  }

  @Override
  public void paint(float alpha) {
    // the background automatically paints itself, so no need to do anything here!
  }
}
