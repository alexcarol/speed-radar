package com.nya.speedradar.core;

import playn.core.ImageLayer;
import playn.core.Key;
import playn.core.Keyboard;


public class Car extends GameObject {

  private final int vxIncrement = 10;

  private int vx = 0;

  public Car(ImageLayer layer) {
    super(layer);
  }

  public void update(int delta) {
    imgLayer.setTx(imgLayer.tx() + vx);
  }

  @Override
  public void onKeyDown(Keyboard.Event event) {
    Key key = event.key();

    if (key == Key.LEFT) {
      vx = -vxIncrement;
    } else if (key == Key.RIGHT) {
      vx = vxIncrement;
    }
  }

  @Override
  public void onKeyTyped(Keyboard.TypedEvent typedEvent) {

  }

  @Override
  public void onKeyUp(Keyboard.Event event) {
    Key key = event.key();

    if (key == Key.LEFT && vx < 0) {
      vx = 0;
    } else if (key == Key.RIGHT && vx > 0) {
      vx = 0;
    }
  }
}
