package ru.nikolenko.junglesimulator.service;

import ru.nikolenko.junglesimulator.entity.Bear;

public class CheckConditions {
    private void checkEnParameters100 (Bear bear) {
        int energy = bear.getEnergy();
        if (energy > 100) {
            energy = 100;
        }
    }

    private void checkEnParameters0 (Bear bear) {
        int energy = bear.getEnergy();
        if (energy < 0) {
            energy = 0;
        }
    }

}
