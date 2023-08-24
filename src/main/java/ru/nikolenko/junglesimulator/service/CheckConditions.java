package ru.nikolenko.junglesimulator.service;

import ru.nikolenko.junglesimulator.entity.Bear;

public class CheckConditions {
    public static void checkEnParameters100 (Bear bear) {
        int energy = bear.getEnergy();
        if (energy > 100) {
            energy = 100;
        }
    }

    public static void checkEnParameters0 (Bear bear) {
        int energy = bear.getEnergy();
        if (energy < 0) {
            energy = 0;
        }
    }

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
