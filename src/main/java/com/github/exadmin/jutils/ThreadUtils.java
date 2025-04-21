package com.github.exadmin.jutils;

public class ThreadUtils {

    /**
     * Calls Thread.sleep() method but hides catchable exception
     * @param milliSecs number of milliseconds to sleep
     */
    public static void sleep(int milliSecs) {
        try {
            Thread.sleep(milliSecs);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
