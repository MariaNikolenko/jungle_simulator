package ru.nikolenko.junglesimulator.util;

import ru.nikolenko.junglesimulator.entity.Bear;
import ru.nikolenko.junglesimulator.service.CheckConditions;

public class EventSimulator {

    //Брождение по лесу -6 энергии
    //Погоня -12 энергии
    //Рытьё берлоги -15 энергии
    //Сон +40 энергии
    //Поиск ягод -7 энергии, k*5 здоровья
    //Добыча мёда -14 энергии, k*10 здоровья
    //Добыча рыбы -10 энергии, k*8 здоровья
    //Охота на оленя -30 энергии, k*20 здоровья
    //Попадание в капкан -50 здоровья
    //Встреча с охотником -30 здоровья -30 энергии
    //Энергия=0 → -6 здоровья

    public void startSimulation (){

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

    //проверка уровня здоровья и энергии медведя
    private boolean checkStatus(Bear bear) {
        System.out.println("hp: " + bear.getHealth() + " energy: " + bear.getEnergy());
        if (bear.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }
    }

}
