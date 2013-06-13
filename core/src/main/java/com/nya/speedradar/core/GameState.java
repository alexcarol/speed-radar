package com.nya.speedradar.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import playn.core.GroupLayer;
import static playn.core.PlayN.graphics;
import static playn.core.PlayN.keyboard;

public class GameState extends State<SpeedRadar> {

    private int h, w;
    private KeyboardListener keyboardListener = new KeyboardListener();
    private GameGUI gameGUI = new GameGUI();
    private ArrayList<GameElement> gameElements = new ArrayList<GameElement>();
    private Background background;
    private Car car;
    private Iterator<Pole> poleIterator;
    Pole nextPole;
    private float maxVelocityAllowed = 200.0f;

    @Override
    public void Enter(SpeedRadar owner) {
        // create and add background image layer

        h = graphics().height();
        w = graphics().width();

        System.out.println("height : " + h + " width : " + w);

        car = CarFactory.createCar(1, w, h);

        GroupLayer bichosLayer = graphics().createGroupLayer();
        bichosLayer.add(car.getLayer());

        background = new Background(w, h, car);
        gameElements.add(background);
        gameElements.add(car);

        graphics().rootLayer().add(bichosLayer);

        keyboardListener.add(car);
        keyboardListener.add(gameGUI);
        keyboard().setListener(keyboardListener);

        poleIterator = background.getRadarList().getPoleIterator();
        nextPole = poleIterator.next();
    }

    @Override
    public void Update(SpeedRadar owner, int delta) {
        if (gameGUI.isPaused()) {
            return;
        }

        //updating all game elements
        for (GameElement element : gameElements) {
            element.update(delta);
        }

        // Check if car traversing pole

        try {
            while (-nextPole.positionY <= car.getPixelsTravelled()) {
                System.out.println("Traversing Pole!  car vel = " + car.getVerticalVelocity());
                if (nextPole.radar) {
                    if (car.getVerticalVelocity() > maxVelocityAllowed) {
                        System.out.println("HAY RADAR!! GAME OVR!");
                    }
                }

                nextPole = poleIterator.next();
            }
        } catch (NoSuchElementException e) {
            //race finished
        }
    }

    @Override
    public void Exit(SpeedRadar owner) {
        // DO NOTHING
    }

    @Override
    public void GoNextState(StateMachine<SpeedRadar> fsm) {
        // DO NOTHING
    }
}
