package com.gupaoedu.vip.pattern.homework.day01.simplefactory;

/**
 * @author: leigang
 * @version: 2018-05-06
 */
public class Byd  implements Car {

    public void run() {
        System.out.println(this.getClass().getSimpleName() + " run...");
    }
}
