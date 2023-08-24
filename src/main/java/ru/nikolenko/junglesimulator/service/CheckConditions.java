package ru.nikolenko.junglesimulator.service;

import ru.nikolenko.junglesimulator.entity.Bear;

public class CheckConditions {
    /*public static void checkEnParameters100 (Bear bear) {
        int energy = bear.getEnergy();
        if (energy > 100) {
            energy = 100;
        }
        bear.setEnergy(energy);
    }

    public static void checkEnParameters0 (Bear bear) {
        int energy = bear.getEnergy();
        if (energy < 0) {
            energy = 0;
        }
        bear.setEnergy(energy);
    }

    public static void checkHealthParameters100 (Bear bear) {
        int health = bear.getHealth();
        if (health > 100) {
            health = 100;
        }
        bear.setHealth(health);
    }

    public static void checkHealthParameters0 (Bear bear) {
        int health = bear.getHealth();
        if (health < 0) {
            health = 0;
        }
        bear.setHealth(health);
    }
*/
    public static void checkEnergy(Bear bear) {
        if (bear.getEnergy() <= 0) {
            int health = bear.getHealth();
            health = health - 6;
            if (health < 0) {
                health = 0;
            }
            bear.setHealth(health);
        }
    }

}
