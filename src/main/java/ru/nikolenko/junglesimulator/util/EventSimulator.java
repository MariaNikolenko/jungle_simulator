package ru.nikolenko.junglesimulator.util;

import ru.nikolenko.junglesimulator.entity.Bear;
import ru.nikolenko.junglesimulator.service.CheckConditions;

public class EventSimulator {

    //10% Брождение по лесу -6 энергии
    //10% Погоня -12 энергии
    //7% Рытьё берлоги -15 энергии
    //15% Сон +15 энергии
    //13% Поиск ягод -7 энергии, k*5 здоровья
    //14% Добыча мёда -14 энергии, k*10 здоровья
    //10% Добыча рыбы -10 энергии, k*8 здоровья
    //6% Охота на оленя -30 энергии, k*20 здоровья
    //6% Попадание в капкан -50 здоровья
    //9% Встреча с охотником -30 здоровья -30 энергии
    //Энергия=0 → -6 здоровья

    public void startSimulation(Bear bear) {
        while (checkStatus(bear)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber < 10) {
                walkEvent(bear);
            } else if (eventNumber >= 10 && eventNumber < 20) {
                chaseEvent(bear);
            } else if (eventNumber >= 20 && eventNumber < 27) {
                digDenEvent(bear);
            } else if (eventNumber >= 27 && eventNumber < 42) {
                sleepEvent(bear);
            } else if (eventNumber >= 42 && eventNumber < 55) {
                searchBerriesEvent(bear);
            } else if (eventNumber >= 55 && eventNumber < 69) {
                getHoneyEvent(bear);
            } else if (eventNumber >= 69 && eventNumber < 79) {
                getFishEvent(bear);
            } else if (eventNumber >= 79 && eventNumber < 85) {
                huntDeerEvent(bear);
            } else if (eventNumber >= 85 && eventNumber < 91) {
                getTrapEvent(bear);
            } else if (eventNumber >= 91 && eventNumber <= 100) {
                attackHunterEvent(bear);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("\u001B[41m" + "Медведь умер ☠");
    }

    //Брождение по лесу -6 энергии
    private void walkEvent(Bear bear) {
        int energy = bear.getEnergy();
        energy = energy - 6;
        if (energy < 0) {
            energy = 0;
        }
        //CheckConditions.checkEnParameters0(bear);
        bear.setEnergy(energy);
        CheckConditions.checkEnergy(bear);
        System.out.println("Брождение по лесу -6 энергии.");
    }

    //Погоня -12 энергии
    private void chaseEvent(Bear bear) {
        int energy = bear.getEnergy();
        energy = energy - 12;
        if (energy < 0) {
            energy = 0;
        }
        //CheckConditions.checkEnParameters0(bear);
        bear.setEnergy(energy);
        CheckConditions.checkEnergy(bear);
        System.out.println("Погоня -12 энергии.");
    }

    //Рытьё берлоги -15 энергии
    private void digDenEvent(Bear bear) {
        int energy = bear.getEnergy();
        energy = energy - 15;
        if (energy < 0) {
            energy = 0;
        }
        //CheckConditions.checkEnParameters0(bear);
        bear.setEnergy(energy);
        CheckConditions.checkEnergy(bear);
        System.out.println("Рытьё берлоги -15 энергии.");
    }

    //Сон +40 энергии
    private void sleepEvent(Bear bear) {
        int energy = bear.getEnergy();
        energy = energy + 15;
        if (energy > 100) {
            energy = 100;
        }
        //CheckConditions.checkEnParameters100(bear);
        bear.setEnergy(energy);
        CheckConditions.checkEnergy(bear);
        System.out.println("Сон +15 энергии.");
    }

    //Поиск ягод -7 энергии, k*5 здоровья
    private void searchBerriesEvent(Bear bear) {
        int energy = bear.getEnergy();
        int health = bear.getHealth();
        energy = energy - 7;
        if (energy < 0) {
            energy = 0;
        }
        //CheckConditions.checkEnParameters0(bear);
        health = health + (int) (bear.getEnergyGenerationCoefficient() * 5);
        if (health > 100) {
            health = 100;
        }
        //CheckConditions.checkHealthParameters100(bear);
        bear.setEnergy(energy);
        bear.setHealth(health);
        CheckConditions.checkEnergy(bear);
        System.out.println("Поиск ягод -7 энергии, + " + bear.getEnergyGenerationCoefficient()*5 + " здоровья.");
    }

    //Добыча мёда -14 энергии, k*10 здоровья
    private void getHoneyEvent(Bear bear) {
        int energy = bear.getEnergy();
        int health = bear.getHealth();
        energy = energy - 14;
        if (energy < 0) {
            energy = 0;
        }
        //CheckConditions.checkEnParameters0(bear);
        health = health + (int) (bear.getEnergyGenerationCoefficient() * 10);
        if (health > 100) {
            health = 100;
        }
        //CheckConditions.checkHealthParameters100(bear);
        bear.setEnergy(energy);
        bear.setHealth(health);
        CheckConditions.checkEnergy(bear);
        System.out.println("Добыча мёда -14 энергии, + " + bear.getEnergyGenerationCoefficient()*10 + " здоровья.");
    }

    //Добыча рыбы -10 энергии, k*8 здоровья
    private void getFishEvent(Bear bear) {
        int energy = bear.getEnergy();
        int health = bear.getHealth();
        energy = energy - 10;
        if (energy < 0) {
            energy = 0;
        }
        //CheckConditions.checkEnParameters0(bear);
        health = health + (int) (bear.getEnergyGenerationCoefficient() * 8);
        if (health > 100) {
            health = 100;
        }
        //CheckConditions.checkHealthParameters100(bear);
        bear.setEnergy(energy);
        bear.setHealth(health);
        CheckConditions.checkEnergy(bear);
        System.out.println("Добыча рыбы -10 энергии, + " + bear.getEnergyGenerationCoefficient()*8 + " здоровья.");
    }

    //Охота на оленя -30 энергии, k*20 здоровья
    private void huntDeerEvent(Bear bear) {
        int energy = bear.getEnergy();
        int health = bear.getHealth();
        energy = energy - 30;
        if (energy < 0) {
            energy = 0;
        }
        //CheckConditions.checkEnParameters0(bear);
        health = health + (int) (bear.getEnergyGenerationCoefficient() * 20);
        if (health > 100) {
            health = 100;
        }
        //CheckConditions.checkHealthParameters100(bear);
        bear.setEnergy(energy);
        bear.setHealth(health);
        CheckConditions.checkEnergy(bear);
        System.out.println("Охота на оленя -30 энергии, + " + bear.getEnergyGenerationCoefficient()*20 + " здоровья.");
    }

    //Попадание в капкан -50 здоровья
    private void getTrapEvent(Bear bear) {
        int health = bear.getHealth();
        health = health - 50;
        if (health < 0) {
            health = 0;
        }
        //CheckConditions.checkHealthParameters0(bear);
        bear.setHealth(health);
        CheckConditions.checkEnergy(bear);
        System.out.println("!! Медведь попал в капкан. -50 здоровья !!");
    }

    //Встреча с охотником -30 здоровья -30 энергии
    private void attackHunterEvent(Bear bear) {
        int energy = bear.getEnergy();
        int health = bear.getHealth();
        energy = energy - 30;
        if (energy < 0) {
            energy = 0;
        }
        //CheckConditions.checkEnParameters0(bear);
        health = health - 30;
        if (health < 0) {
            health = 0;
        }
        //CheckConditions.checkHealthParameters0(bear);
        bear.setEnergy(energy);
        bear.setHealth(health);
        CheckConditions.checkEnergy(bear);
        System.out.println("!! Медведя атаковал охотник. -30 энергии, -30 здоровья !!");
    }

    //Проверка уровня здоровья и энергии медведя
    private boolean checkStatus(Bear bear) {
        System.out.println("hp: " + bear.getHealth() + " energy: " + bear.getEnergy());
        return bear.getHealth() > 0;
    }
}
