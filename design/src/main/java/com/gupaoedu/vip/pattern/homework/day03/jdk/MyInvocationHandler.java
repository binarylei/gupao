package com.gupaoedu.vip.pattern.homework.day03.jdk;

import java.lang.reflect.Method;

/**
 * @author: leigang
 * @version: 2018-10-02
 */
@FunctionalInterface
public interface MyInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
