package ru.nikolenko.junglesimulator._main;

import ru.nikolenko.junglesimulator.entity.Bear;
import ru.nikolenko.junglesimulator.util.EventSimulator;

public class _Main {
    public static void main(String[] args) {
        Bear bear = new Bear();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.startSimulation(bear);
    }
}
