package com.nya.speedradar.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import com.nya.speedradar.core.SpeedRadar;

public class SpeedRadarJava {

  public static void main(String[] args) {
    JavaPlatform.Config config = new JavaPlatform.Config();
    // use config to customize the Java platform, if needed
    JavaPlatform.register(config);
    PlayN.run(new SpeedRadar());
  }
}
