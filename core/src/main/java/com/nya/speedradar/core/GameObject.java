/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nya.speedradar.core;

import playn.core.ImageLayer;

/**
 * @author moh
 */
public abstract class GameObject implements GameElement {
  protected ImageLayer imgLayer;

  public GameObject(ImageLayer layer) {
    imgLayer = layer;
  }

  public ImageLayer getLayer() {
    return imgLayer;
  }
}
