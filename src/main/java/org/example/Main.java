package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        Random random = new Random();

        Prise prise;
        double wins = 0;
        double loses = 0;

        int tries = 10000;

        for(int i = 0; i < tries; i++) {
            Doors doors = new Doors();

            prise = doors.chooseDoorWithChange(random.nextInt(3));



            if (prise.equals(Prise.CAR)) {
                log.info("Game done! You Win!");
                wins++;
            } else {
                log.info("Game done! You Lose!");
                loses++;
            }
            log.debug("------------------------------------------");
        }
        log.info("WINS = {}, LOSES = {}, W/R = {}%",
                (int)wins,
                (int)loses,
                (int)(wins/(wins+loses)*100) );
    }
}