package com.gupao.binarylei.pattern.observer.homework;

import java.util.EventObject;

/**
 * @author leigang
 * @version 2019-03-21
 */
public class GperEvent extends EventObject {
    
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public GperEvent(Object source) {
        super(source);
    }
}
