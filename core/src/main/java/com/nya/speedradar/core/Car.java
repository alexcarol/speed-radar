package com.nya.speedradar.core;

import playn.core.ImageLayer;
import playn.core.Key;
import playn.core.Keyboard;


public class Car extends GameObject implements Keyboard.Listener {

  private final int vxIncrement = 10;

  private int vx = 0;
  
  // Acceleration variables
  private long pixelsTravelled;
  private long lastPixelsTravelled;
  private float verticalVelocity;
  private float minVelocity;
  private float maxVelocity;
  private float verticalAcceleration;
  private float verticalDeceleration;
  private boolean accelerating;
  

  public Car(ImageLayer layer) {
    super(layer);
    
    pixelsTravelled = -304;
    lastPixelsTravelled = -304;
    minVelocity = 80.0f;
    maxVelocity = 800.0f;
    verticalAcceleration = 20.0f;
    verticalDeceleration = 5.0f;
    verticalVelocity = minVelocity;
    accelerating = false;
  }

  private void accelerate(int delta) {
    if (accelerating) {
        verticalVelocity += verticalAcceleration;
        if (verticalVelocity >= maxVelocity) {
            verticalVelocity = maxVelocity;
        }
    }
    else {
        verticalVelocity -= verticalDeceleration;
        if (verticalVelocity <= minVelocity) {
            verticalVelocity = minVelocity;
        }
    }
    
    lastPixelsTravelled = pixelsTravelled;
    pixelsTravelled += verticalVelocity*delta/1000.0f;
  }
  
  public void update(int delta) {
    imgLayer.setTx(imgLayer.tx() + vx);
    
    accelerate(delta);
  }
  
  public long getPixelsTravelled() {
      return pixelsTravelled;
  }
  
  public float getVerticalVelocity() {
      return verticalVelocity;
  }
  
  public long getPixelsTravelledSinceLastUpdate() {
      return pixelsTravelled - lastPixelsTravelled;
  }

  @Override
  public void onKeyDown(Keyboard.Event event) {
    Key key = event.key();

    if (key == Key.LEFT) {
      vx = -vxIncrement;
    } else if (key == Key.RIGHT) {
      vx = vxIncrement;
    } else if (key == Key.UP) {
        accelerating = true;
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
    } else if (key == Key.UP) {
        accelerating = false;
    }
  }
  
}
