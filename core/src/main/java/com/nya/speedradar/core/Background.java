
package com.nya.speedradar.core;

import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;
import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;


public class Background implements GameElement {
    private ImageLayer[] bgLayers;
    private int h, w;
    private Image bgImage;
    
    private float velocity;

  private RadarList radarList;
  private GroupLayer polesLayer;

    public Background(int screenWidth, int screenHeight) {
        w = screenWidth;
        h = screenHeight;
        
        bgImage = assets().getImage("images/road.png");
        bgLayers = new ImageLayer[3];
        for (int i = 0; i < 3; ++i) {
            bgLayers[i] = graphics().createImageLayer(bgImage);
            bgLayers[i].setHeight(h);
            bgLayers[i].setWidth(w);
            bgLayers[i].setTranslation(0, (i - 2) * h);
            
            graphics().rootLayer().add(bgLayers[i]);

        }
        
        velocity = 30.0f;

      radarList = new RadarList(10000, 100, 30);
      polesLayer = graphics().createGroupLayer();
      Image poleImg = assets().getImage("images/pole.png");
      for (Pole p : radarList.getPoles()) {
        ImageLayer imgLayer = graphics().createImageLayer(poleImg);
        imgLayer.setTranslation(100, p.positionY);
        imgLayer.setSize(screenWidth/2, screenHeight/8);
        polesLayer.add(imgLayer);
      }

      graphics().rootLayer().add(polesLayer);
    }
    
    public void setVelocity(float vel) {
        velocity = vel;
    }

    @Override
    public void update(int delta) {
        float secs = delta / 1000.0f;
        
        for (int i = 0; i < 3; ++i) {
            bgLayers[i].setTy(bgLayers[i].ty() + velocity*secs);
        }
        polesLayer.setTy(polesLayer.ty() + velocity*secs);

        if (bgLayers[2].ty() > h) {
            bgLayers[2].setTranslation(0, bgLayers[0].ty() - h);

            for (int i = 2; i > 0; --i) {
                ImageLayer aux = bgLayers[i];
                bgLayers[i] = bgLayers[i - 1];
                bgLayers[i - 1] = aux;
            }
        }
    }
}
