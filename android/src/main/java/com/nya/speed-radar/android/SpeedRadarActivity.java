package com.nya.speed-radar.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import com.nya.speed-radar.core.SpeedRadar;

public class SpeedRadarActivity extends GameActivity {

  @Override
  public void main(){
    PlayN.run(new SpeedRadar());
  }
}
