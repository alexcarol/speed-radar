package com.nya.speedradar.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import com.nya.speedradar.core.SpeedRadar;

public class SpeedRadarActivity extends GameActivity {

  @Override
  public void main(){
    PlayN.run(new SpeedRadar());
  }
}
