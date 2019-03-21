package com.gupao.binarylei.pattern.observer.homework;

import com.google.common.eventbus.EventBus;

/**
 * @author leigang
 * @version 2019-03-21
 */
public class GperContext {

    private EventBus eventBus;

    public GperContext() {
        this.eventBus = new EventBus();
    }

    public void registerListener(Object listener) {
        eventBus.register(listener);
    }

    public void unregisterListener(Object listener) {
        eventBus.unregister(listener);
    }

    public void publishEvent(GperEvent event) {
        eventBus.post(event);
    }

}
