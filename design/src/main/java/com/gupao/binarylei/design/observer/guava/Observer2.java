package com.gupao.binarylei.pattern.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @author leigang
 * @version 2019-03-21
 */
public class Observer2 {
    @Subscribe
    public void ob2Method1(String msg) {
        System.out.println(msg + " - com.gupao.binarylei.pattern.observer.guava.Observer2.ob2Method1!");
    }

    // 错误的基本型参数
    @Subscribe
    public void ob2Method2(int msg) {
        System.out.println(msg + " - com.gupao.binarylei.pattern.observer.guava.Observer2.ob2Method2!");
    }

    /**
     * post() 不支持自动装箱功能,只能使用Integer,不能使用int,否则handlersByType的Class会是int而不是Integer
     * 而传入的int msg参数在post(int msg)的时候会被包装成Integer,导致无法匹配到
     */
    @Subscribe
    public void ob2Method3(Integer msg) {
        System.out.println(msg + " - com.gupao.binarylei.pattern.observer.guava.Observer2.ob2Method3!");
    }
}

