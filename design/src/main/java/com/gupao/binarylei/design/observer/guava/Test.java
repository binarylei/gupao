package com.gupao.binarylei.pattern.observer.guava;

import com.google.common.eventbus.EventBus;

/**
 * @author leigang
 * @version 2019-03-21
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        EventBus eventBus = new EventBus();
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();

        eventBus.register(observer1);
        eventBus.register(observer2);

        // 只有注册的参数类型为String的方法会被调用
        eventBus.post("post string method");
        eventBus.post(1);
        eventBus.post(new Integer(1));

        // 注销observer2
        eventBus.unregister(observer2);
        eventBus.post("post string method after unregister");
    }

}
