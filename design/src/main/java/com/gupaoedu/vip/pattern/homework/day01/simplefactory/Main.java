package com.gupaoedu.vip.pattern.homework.day01.simplefactory;

/**
 * @author: leigang
 * @version: 2018-05-06
 */
public class Main {

    public static void main(String[] args) {
        Car audi = CarFactory.createCar("Audi");
        audi.run();
    }
}
