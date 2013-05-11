package com.nya.speedradar.core;


import playn.core.Key;
import playn.core.Keyboard;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

class KeyboardListener implements Keyboard.Listener
{
  private Queue<Key> keyQueue = new ConcurrentLinkedQueue<Key>();

  public Key getNextKey() {
    return keyQueue.poll();
  }

  @Override
  public void onKeyDown(Keyboard.Event event) {
    System.out.println("Key pressed : " + event.key());
    keyQueue.add(event.key());
  }

  @Override
  public void onKeyTyped(Keyboard.TypedEvent typedEvent) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void onKeyUp(Keyboard.Event event) {
    //To change body of implemented methods use File | Settings | File Templates.
  }
}