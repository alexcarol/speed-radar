package com.nya.speedradar.core;

import playn.core.Key;
import playn.core.Keyboard;

public class GameGUI implements Keyboard.Listener {

  private boolean paused = false;

  @Override
  public void onKeyDown(Keyboard.Event event) {
    Key key = event.key();

    paused = key.equals(Key.P);
  }

  @Override
  public void onKeyTyped(Keyboard.TypedEvent typedEvent) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void onKeyUp(Keyboard.Event event) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  public boolean isPaused() {
    return paused;
  }
}
