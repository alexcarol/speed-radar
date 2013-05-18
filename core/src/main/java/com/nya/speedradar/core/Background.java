
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
    
    private Car car;

  private RadarList radarList;
  private GroupLayer polesLayer;

    public Background(int screenWidth, int screenHeight, Car myCar) {
        w = screenWidth;
        h = screenHeight;
        car = myCar;
        
        bgImage = assets().getImage("images/road.png");
        bgLayers = new ImageLayer[3];
        for (int i = 0; i < 3; ++i) {
            bgLayers[i] = graphics().createImageLayer(bgImage);
            bgLayers[i].setHeight(h);
            bgLayers[i].setWidth(w);
            bgLayers[i].setTranslation(0, (i - 2) * h);
            
            graphics().rootLayer().add(bgLayers[i]);

        }

      radarList = new RadarList(50000, 100, 30);
      polesLayer = graphics().createGroupLayer();
      Image poleImg = assets().getImage("images/pole.png");
      for (Pole p : radarList.getPoles()) {
        ImageLayer imgLayer = graphics().createImageLayer(poleImg);
        imgLayer.setSize(screenWidth/2, screenHeight/8);
        imgLayer.setTranslation(w/2 - imgLayer.width()/2, p.positionY);
        polesLayer.add(imgLayer);
      }

      graphics().rootLayer().add(polesLayer);
    }

    @Override
    public void update(int delta) {
        float secs = delta / 1000.0f;
        
        for (int i = 0; i < 3; ++i) {
            bgLayers[i].setTy(bgLayers[i].ty() + car.getPixelsTravelledSinceLastUpdate());
        }
        //polesLayer.setTy(polesLayer.ty() + velocity*secs);
        polesLayer.setTy(polesLayer.ty() + car.getPixelsTravelledSinceLastUpdate());

        if (bgLayers[2].ty() > h) {
            bgLayers[2].setTranslation(0, bgLayers[0].ty() - h);

            for (int i = 2; i > 0; --i) {
                ImageLayer aux = bgLayers[i];
                bgLayers[i] = bgLayers[i - 1];
                bgLayers[i - 1] = aux;
            }
        }
    }
    
    public RadarList getRadarList() {
        return radarList;
    }
}
