package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;

public class Doors {
    private static final Logger log = LogManager.getLogger(Doors.class);
    Door[] doors = new Door[3];
    Random random = new Random();
    int choose;
    ArrayList<Integer> canDelete = new ArrayList<>();
    int toDelete;
    boolean needTochange;

    public Doors() {
        switch (random.nextInt(3)) {
            case 0 -> {
                doors = new Door[]{
                        new Door(Prise.CAR),
                        new Door(Prise.GOAT),
                        new Door(Prise.GOAT)
                };
            } case 1 -> {
                doors = new Door[]{
                        new Door(Prise.GOAT),
                        new Door(Prise.CAR),
                        new Door(Prise.GOAT)
                };
            }
            case 2 -> {
                doors = new Door[]{
                        new Door(Prise.GOAT),
                        new Door(Prise.GOAT),
                        new Door(Prise.CAR)
                };
            }
        }
    }

    public Prise chooseDoorNoChange(int i){
        needTochange = false;
        return chooseDoorNoChange(i);

    }

    public Prise chooseDoorWithChange(int i){
        needTochange = true;
        return chooseDoorNoChange(i);
    }

    private Prise chooseDoor(int i) {
        choose = i;
        log.debug("Choosed door: {}", choose);

        openOtherDoor(choose);

        if (needTochange) changeDoor();

        return getPrise();
    }

    private void openOtherDoor(int choose) {
        for (int i = 0; i < 3; i++) {
            if (i != choose) {
                if (doors[i].open().equals(Prise.GOAT)) {
                    canDelete.add(i);
                }
            }
        }
        toDelete = canDelete.get(random.nextInt(1));

        log.debug("Opening other door ({})", toDelete);
        doors[toDelete] = null;
    }

    private void changeDoor() {
        for (int i = 0; i < 3; i++) {
            if(i!=choose){
                if (doors[i]!=null){
                    choose =i;
                    break;
                }
            }
        }
        log.debug("Door changed to {}", choose);
    }

    private Prise getPrise() {
        log.debug("Getting prise from door {}. Its {}", choose, doors[choose].open());
        return doors[choose].open();
    }

}
