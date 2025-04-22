package com.github.exadmin.jutils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrUtilsTest {
    @Test
    public void testRemovalCharOnEdge_whenExist_returnModifiedString() {
        String sourceStr = "\"Hello World!\"";
        String actStr = StrUtils.removeSpeciaCharOnEdgesIfExist(sourceStr, '"');
        String expStr = "Hello World!";

        assertEquals(expStr, actStr);
    }

    @Test
    public void testRemovalCharOnEdge_whenOnlyOnTheLeftSide_returnOriginlString() {
        String sourceStr = "\"Hello World!";
        String actStr = StrUtils.removeSpeciaCharOnEdgesIfExist(sourceStr, '"');
        String expStr = "\"Hello World!";

        assertEquals(expStr, actStr);
    }

    @Test
    public void testRemovalCharOnEdge_whenOnlyOnTheRightSide_returnOriginlString() {
        String sourceStr = "Hello \"World!\"";
        String actStr = StrUtils.removeSpeciaCharOnEdgesIfExist(sourceStr, '"');
        String expStr = "Hello \"World!\"";

        assertEquals(expStr, actStr);
    }
}
