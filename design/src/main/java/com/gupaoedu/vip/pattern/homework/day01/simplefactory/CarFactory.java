package com.gupaoedu.vip.pattern.homework.day01.simplefactory;

/**
 * @author: leigang
 * @version: 2018-05-06
 */
public class CarFactory {

    public static Car createCar(String type) {
        if ("Audi".equalsIgnoreCase(type)) {
            return new Audi();
        } else if ("Byd".equalsIgnoreCase(type)) {
            return new Byd();
        }
        return null;
    }
}
