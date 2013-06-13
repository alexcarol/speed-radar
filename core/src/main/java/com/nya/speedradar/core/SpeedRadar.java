package com.nya.speedradar.core;

import playn.core.Game;

public class SpeedRadar extends Game.Default {

  StateMachine<SpeedRadar> screenManager;

  public SpeedRadar() {
    super(33); // call update every 33ms (30 times per second)
  }

  @Override
  public void init() {
    screenManager = new StateMachine<SpeedRadar>(this, new IntroState());
  }

  @Override
  public void update(int delta) {
      screenManager.Update(delta); // Already checks for state changes
  }

  @Override
  public void paint(float alpha) {
    // the background automatically paints itself, so no need to do anything here!
  }
}
