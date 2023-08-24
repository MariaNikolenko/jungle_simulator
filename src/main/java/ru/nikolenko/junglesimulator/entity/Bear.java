package ru.nikolenko.junglesimulator.entity;

public class Bear {

    private int health = 100;
    private int energy = 100;

    private final double energyGenerationCoefficient = 1.8;

    public void setHealth (int health){
        this.health = health;
    }
    public int getHealth(){
        return this.health;
    }
    public void setEnergy (int energy){
        this.energy = energy;
    }

    public int getEnergy(){
        return this.energy;
    }

    public double getEnergyGenerationCoefficient() {
        return this.energyGenerationCoefficient;
    }



}
