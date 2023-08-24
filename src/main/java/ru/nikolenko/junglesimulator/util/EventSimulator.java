package ru.nikolenko.junglesimulator.util;

import ru.nikolenko.junglesimulator.entity.Bear;
import ru.nikolenko.junglesimulator.service.CheckConditions;

import javax.management.MBeanRegistration;

public class EventSimulator {

    //15% Брождение по лесу -6 энергии
    //10% Погоня -12 энергии
    //7% Рытьё берлоги -15 энергии
    //15% Сон +40 энергии
    //13% Поиск ягод -7 энергии, k*5 здоровья
    //14% Добыча мёда -14 энергии, k*10 здоровья
    //10% Добыча рыбы -10 энергии, k*8 здоровья
    //6% Охота на оленя -30 энергии, k*20 здоровья
    //4% Попадание в капкан -50 здоровья
    //6% Встреча с охотником -30 здоровья -30 энергии
    //Энергия=0 → -6 здоровья

    public void startSimulation(Bear bear) {
        while (checkStatus(bear)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber < 15) {
                walkingEvent(bear);
            } else if (eventNumber >= 15 && eventNumber <25) {
                chaseEvent(bear);
            } else if (eventNumber >= 25 && eventNumber <32) {
                denDiggingEvent(bear);
            } else if (eventNumber >= 32 && eventNumber <47) {
                sleepEvent(bear);
            } else if (eventNumber >= 47 && eventNumber <60) {
                searchBerriesEvent(bear);
            } else if (eventNumber >= 60 && eventNumber <74) {
                honeyExtractionEvent(bear);
            } else if (eventNumber >= 74 && eventNumber <84) {
                fishExtractionEvent(bear);
            } else if (eventNumber >= 84 && eventNumber <90) {
                DeerHuntingEvent(bear);
            } else if (eventNumber >= 90 && eventNumber <94) {
                gettingTrapEvent(bear);
            } else if (eventNumber >= 94 && eventNumber <= 100) {
                hunterAttackEvent(bear);
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Медведь умер \u9760");
        }
    }


    //Брождение по лесу -6 энергии
    private void walkingEvent (Bear bear) {
        int energy = bear.getEnergy();
        energy = energy - 6;
        CheckConditions.checkEnParameters0(bear);
        bear.setEnergy(energy);
        CheckConditions.checkEnergy(bear);
        System.out.println("Брождение по лесу -6 энергии.");
    }

    //Погоня -12 энергии
    private void chaseEvent (Bear bear) {
        int energy = bear.getEnergy();
        energy = energy - 12;
        CheckConditions.checkEnParameters0(bear);
        bear.setEnergy(energy);
        CheckConditions.checkEnergy(bear);
        System.out.println("Погоня -12 энергии.");
    }

    //Рытьё берлоги -15 энергии
    private void denDiggingEvent (Bear bear) {
        int energy = bear.getEnergy();
        energy = energy - 15;
        CheckConditions.checkEnParameters0(bear);
        bear.setEnergy(energy);
        CheckConditions.checkEnergy(bear);
        System.out.println("Рытьё берлоги -15 энергии.");
    }

    //Сон +40 энергии
    private void sleepEvent (Bear bear) {
        int energy = bear.getEnergy();
        energy = energy + 40;
        CheckConditions.checkEnParameters100(bear);
        bear.setEnergy(energy);
        CheckConditions.checkEnergy(bear);
        System.out.println("Сон +40 энергии.");
    }

    //Поиск ягод -7 энергии, k*5 здоровья
    private void searchBerriesEvent (Bear bear) {
        int energy = bear.getEnergy();
        int health = bear.getHealth();
        energy = energy - 7;
        CheckConditions.checkEnParameters0(bear);
        health = health + (int) (bear.getEnergyGenerationCoefficient()*5);
        CheckConditions.checkHealthParameters100(bear);
        bear.setEnergy(energy);
        bear.setHealth(health);
        CheckConditions.checkEnergy(bear);
        System.out.println("Поиск ягод -7 энергии, + k*5 здоровья.");
    }

    //Добыча мёда -14 энергии, k*10 здоровья
    private void honeyExtractionEvent (Bear bear) {
        int energy = bear.getEnergy();
        int health = bear.getHealth();
        energy = energy - 14;
        CheckConditions.checkEnParameters0(bear);
        health = health + (int) (bear.getEnergyGenerationCoefficient()*10);
        CheckConditions.checkHealthParameters100(bear);
        bear.setEnergy(energy);
        bear.setHealth(health);
        CheckConditions.checkEnergy(bear);
        System.out.println("Добыча мёда -14 энергии, + k*10 здоровья.");
    }

    //Добыча рыбы -10 энергии, k*8 здоровья
    private void fishExtractionEvent (Bear bear) {
        int energy = bear.getEnergy();
        int health = bear.getHealth();
        energy = energy - 10;
        CheckConditions.checkEnParameters0(bear);
        health = health + (int) (bear.getEnergyGenerationCoefficient()*8);
        CheckConditions.checkHealthParameters100(bear);
        bear.setEnergy(energy);
        bear.setHealth(health);
        CheckConditions.checkEnergy(bear);
        System.out.println("Добыча рыбы -10 энергии, + k*8 здоровья.");
    }

    //Охота на оленя -30 энергии, k*20 здоровья
    private void DeerHuntingEvent (Bear bear) {
        int energy = bear.getEnergy();
        int health = bear.getHealth();
        energy = energy - 30;
        CheckConditions.checkEnParameters0(bear);
        health = health + (int) (bear.getEnergyGenerationCoefficient()*20);
        CheckConditions.checkHealthParameters100(bear);
        bear.setEnergy(energy);
        bear.setHealth(health);
        CheckConditions.checkEnergy(bear);
        System.out.println("Охота на оленя -30 энергии, + k*20 здоровья.");
    }

    //Попадание в капкан -50 здоровья
    private void gettingTrapEvent (Bear bear) {
        int health = bear.getHealth();
        health = health - 50;
        CheckConditions.checkHealthParameters0(bear);
        bear.setHealth(health);
        CheckConditions.checkEnergy(bear);
        System.out.println("!! Медведь попал в капкан -50 здоровья !!");
    }

    //Встреча с охотником -30 здоровья -30 энергии
    private void hunterAttackEvent (Bear bear) {
        int energy = bear.getEnergy();
        int health = bear.getHealth();
        energy = energy - 30;
        CheckConditions.checkEnParameters0(bear);
        health = health -30;
        CheckConditions.checkHealthParameters0(bear);
        bear.setEnergy(energy);
        bear.setHealth(health);
        CheckConditions.checkEnergy(bear);
        System.out.println("!! Медведя атаковал охотник -30 энергии, -30 здоровья !!");
    }

    //Проверка уровня здоровья и энергии медведя
    private boolean checkStatus(Bear bear) {
        System.out.println("hp: " + bear.getHealth() + " energy: " + bear.getEnergy());
        if (bear.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }
    }

}
