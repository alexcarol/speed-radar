package com.nya.speedradar.core;


import playn.core.Key;
import playn.core.Keyboard;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

class KeyboardListener implements Keyboard.Listener
{
  private ArrayList<Keyboard.Listener> listeners = new ArrayList<Keyboard.Listener>();

  public boolean add(Keyboard.Listener listener)
  {
    return listeners.add(listener);
  }

  @Override
  public void onKeyDown(Keyboard.Event event) {
    for (int i = 0; i < listeners.size(); ++i) {
      listeners.get(i).onKeyDown(event);
    }
  }

  @Override
  public void onKeyTyped(Keyboard.TypedEvent typedEvent) {
    for (int i = 0; i < listeners.size(); ++i) {
      listeners.get(i).onKeyTyped(typedEvent);
    }
  }

  @Override
  public void onKeyUp(Keyboard.Event event) {
    for (int i = 0; i < listeners.size(); ++i) {
      listeners.get(i).onKeyUp(event);
    }
  }
}