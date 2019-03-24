package com.gupaoedu.vip.pattern.homework.day01.abstractfactory;

/**
 * @author: leigang
 * @version: 2018-05-06
 */
public interface CarFactory {

    Engine createEngine();

    Tyre createTyre();

    Seat createSeat();
}
