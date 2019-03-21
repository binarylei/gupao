package com.gupao.binarylei.pattern.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @author leigang
 * @version 2019-03-21
 */
public class Observer1 {

    /**
     * 只有通过@Subscribe注解的方法才会被注册进EventBus
     * 而且方法有且只能有1个参数
     * @param msg
     */
    @Subscribe
    public void ob1Mthod1(String msg) {
        System.out.println(msg + " - com.gupao.binarylei.pattern.observer.guava.Observer1.ob1Mthod1!");
    }

    @Subscribe
    public void ob1Method2(String msg) {
        System.out.println(msg + " - com.gupao.binarylei.pattern.observer.guava.Observer1.ob1Method2!");
    }
    
}
