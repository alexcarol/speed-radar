/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nya.speedradar.core;

import playn.core.Image;
import playn.core.ImageLayer;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

/**
 * @author moh
 */
public class CarFactory {
  public static Car createCar(int tipus, int w, int h) {
    Image image = assets().getImage("images/car.png");
    ImageLayer layer;
    layer = graphics().createImageLayer(image);
    layer.setWidth(w / 8);
    layer.setHeight(w / 8);

    layer.setTranslation(w / 2 - 5, h - layer.height() * 2);
    return new Car(layer);
  }
}
