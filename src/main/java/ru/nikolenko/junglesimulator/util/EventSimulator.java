package ru.nikolenko.junglesimulator.util;

import ru.nikolenko.junglesimulator.entity.Bear;

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
    private void walking (Bear bear) {
        int energy = bear.getEnergy();
        energy = energy - 6;

    }


}
