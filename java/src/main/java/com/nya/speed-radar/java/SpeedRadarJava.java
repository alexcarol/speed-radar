package com.nya.speed-radar.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import com.nya.speed-radar.core.SpeedRadar;

public class SpeedRadarJava {

  public static void main(String[] args) {
    JavaPlatform.Config config = new JavaPlatform.Config();
    // use config to customize the Java platform, if needed
    JavaPlatform.register(config);
    PlayN.run(new SpeedRadar());
  }
}
