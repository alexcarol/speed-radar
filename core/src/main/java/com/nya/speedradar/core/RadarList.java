package com.nya.speedradar.core;

import java.util.ArrayList;
import java.util.Random;

public class RadarList {

  private ArrayList<Pole> poles;
  private int currentPole = 0;

  public RadarList(long roadLength, int numPoles, int numRadars) {
    poles = new ArrayList<Pole>(numPoles);


    long roadSectionLength = roadLength/numPoles;

    for (int i = 0; i < numPoles; ++i) {
      //if we wanted we could make pole random in each section
      Pole p = new Pole(roadSectionLength/2 + roadSectionLength*i);
      poles.add(p);
    }

    Random rand = new Random(System.currentTimeMillis());

    for (int i = 0; i < numRadars; ++i) {
      poles.get(rand.nextInt(numRadars)).radar = true;
    }
  }

  public boolean isPolePassed() {
    return false;
  }

  public ArrayList<Pole> getPoles()
  {
    return poles;
  }
}

class Pole {
  public long positionY;
  public boolean radar = false;

  public Pole(long pos) {
    positionY = pos;
  }
}
