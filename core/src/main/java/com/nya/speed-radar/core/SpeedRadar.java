package com.nya.speedradar.core;

import static playn.core.PlayN.*;

import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;

public class SpeedRadar extends Game.Default {

  private ImageLayer[] bgLayers;
  int h,w;
    
  public SpeedRadar() {
    super(33); // call update every 33ms (30 times per second)
  }

  @Override
  public void init() {
    // create and add background image layer
    h = graphics().height();
    w = graphics().width();
    
    System.out.println(w + "   " + h);
    
    Image bgImage = assets().getImage("images/road.png");
    
    bgLayers = new ImageLayer[3];
    for (int i = 0; i< 3; ++i) {
        bgLayers[i] = graphics().createImageLayer(bgImage);
        bgLayers[i].setHeight(h);
        bgLayers[i].setWidth(w);
        
        bgLayers[i].setTranslation(0, (i-2)*h);
        
        graphics().rootLayer().add(bgLayers[i]);
    }
    
    
    
  }

  @Override
  public void update(int delta) {
      for (int i = 0; i < 3; ++i) {
          bgLayers[i].setTy(bgLayers[i].ty()+ delta/10.0f);
      }
      
      if (bgLayers[2].ty() > h) {
          bgLayers[2].setTranslation(0, bgLayers[0].ty() - h);
          
          for (int i = 0; i < 2; ++i) {
              //ImageLayer aux = bgLayers[2-i];
          }
      }
  }

  @Override
  public void paint(float alpha) {
    // the background automatically paints itself, so no need to do anything here!
  }
}
