package com.gupaoedu.vip.pattern.homework.day06;

import com.google.common.eventbus.Subscribe;

/**
 * @author leigang
 * @version 2019-03-21
 */
public class GperTeacherListener {

    @Subscribe
    public void onEvent(GperQuestEvent event) {
        System.out.println(String.format("%s ask a request: %s", event.getName(), event.getSource()));
    }
}
