package com.gupaoedu.vip.pattern.homework.day06;


import org.junit.Test;

/**
 * @author leigang
 * @version 2019-03-21
 */
public class GperTest {

    @Test
    public void testObserver() {
        GperContext context = new GperContext();
        GperTeacherListener listener = new GperTeacherListener();
        context.registerListener(listener);

        context.publishEvent(new GperQuestEvent("How to Learn Design Patterns?", "GP16450"));
    }

}
