package com.gupao.binarylei.pattern.observer.homework;

/**
 * @author leigang
 * @version 2019-03-21
 */
public class GperQuestEvent extends GperEvent {
    private String name;

    public GperQuestEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
