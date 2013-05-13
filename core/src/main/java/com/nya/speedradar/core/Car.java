package com.nya.speedradar.core;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Key;
import playn.core.Keyboard;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

public class Car implements Keyboard.Listener, GameElement {

  private final int vxIncrement = 10;

  private int vx = 0;

  private ImageLayer layer;

  public Car(String imagePath, int width, int height) {
    Image image = assets().getImage(imagePath);
    layer = graphics().createImageLayer(image);
    layer.setWidth(width/8);
    layer.setHeight(width/8);

    layer.setTranslation(width/2 - 5, height  - layer.height() * 2);
  }

  public ImageLayer getLayer() {
    return layer;
  }

  public void update(int delta)
  {
    layer.setTx(layer.tx() + vx);
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

    if (key == Key.LEFT) {
      vx = 0;
    } else if (key == Key.RIGHT) {
      vx = 0;
    }
  }
}
