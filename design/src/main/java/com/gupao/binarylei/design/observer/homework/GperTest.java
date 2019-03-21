package com.gupao.binarylei.pattern.observer.homework;


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
