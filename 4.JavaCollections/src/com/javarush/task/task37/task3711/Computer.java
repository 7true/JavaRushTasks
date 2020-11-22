package com.javarush.task.task37.task3711;

import javax.print.attribute.HashAttributeSet;

public class Computer {
    private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hardDrive = new HardDrive();

    void run() {
        cpu.calculate();
        memory.allocate();
        hardDrive.storeData();
    }
}
