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
    private void walkingEvent (Bear bear) {
        int energy = bear.getEnergy();
        energy = energy - 6;
        CheckConditions.checkEnParameters0(bear);
        bear.setEnergy(energy);
        CheckConditions.checkEnergy(bear);
        System.out.println("Брождение по лесу -6 энергии.");
    }
    private void chaseEvent (Bear bear) {
        int energy = bear.getEnergy();
        energy = energy - 12;
        CheckConditions.checkEnParameters0(bear);
        bear.setEnergy(energy);
        CheckConditions.checkEnergy(bear);
        System.out.println("Погоня -12 энергии.");
    }
    private void denDiggingEvent (Bear bear) {
        int energy = bear.getEnergy();
        energy = energy - 15;
        CheckConditions.checkEnParameters0(bear);
        bear.setEnergy(energy);
        CheckConditions.checkEnergy(bear);
        System.out.println("Рытьё берлоги -15 энергии.");
    }

    private void sleepEvent (Bear bear) {
        int energy = bear.getEnergy();
        energy = energy + 40;
        CheckConditions.checkEnParameters100(bear);
        bear.setEnergy(energy);
        CheckConditions.checkEnergy(bear);
        System.out.println("Рытьё берлоги -15 энергии.");
    }




}
