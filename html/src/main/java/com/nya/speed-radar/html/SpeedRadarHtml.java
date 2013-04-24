package com.nya.speed-radar.html;

import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

import com.nya.speed-radar.core.SpeedRadar;

public class SpeedRadarHtml extends HtmlGame {

  @Override
  public void start() {
    HtmlPlatform.Config config = new HtmlPlatform.Config();
    // use config to customize the HTML platform, if needed
    HtmlPlatform platform = HtmlPlatform.register(config);
    platform.assets().setPathPrefix("speed-radar/");
    PlayN.run(new SpeedRadar());
  }
}
