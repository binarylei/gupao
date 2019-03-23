package com.gupaoedu.vip.pattern.homework.day03.jdk;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author leigang
 * @version 2019-03-23
 */
public class Main {

    // 模拟 JDK 代理
    @Test
    public void testMyProxy() {
        UserService obj = new UserServiceImpl();
        UserService proxy = (UserService) MyProxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{UserService.class},
                new MyInvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(proxy.getClass().getName());
                        System.out.println(method);
                        Object ret = method.invoke(obj, args);
                        return ret;
                    }
                });
        proxy.say();
    }

    // jdk 代理
    @Test
    public void testJDKProxy() {
        UserService obj = new UserServiceImpl();
        UserService proxy = (UserService) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{UserService.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(proxy.getClass().getName());
                        System.out.println(method);
                        Object ret = method.invoke(obj, args);
                        return ret;
                    }
                });
        proxy.say();
    }
}
