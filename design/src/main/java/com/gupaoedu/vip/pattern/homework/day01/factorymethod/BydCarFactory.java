package com.gupaoedu.vip.pattern.homework.day01.factorymethod;

/**
 * @author: leigang
 * @version: 2018-05-06
 */
public class BydCarFactory implements CarFactory {

    public Car createCar(String type) {
        return new Byd();
    }
}
