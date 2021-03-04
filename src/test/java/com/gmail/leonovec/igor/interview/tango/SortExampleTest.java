package com.gmail.leonovec.igor.interview.tango;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortExampleTest {

    @Test
    public void testSort() {
        assertEquals("aabcde", SortExample.sort("bacaed", Arrays.asList('a', 'b', 'c', 'd', 'e')));
        assertEquals("xbbaacaa", SortExample.sort("abacabax", Arrays.asList('x', 'b', 'f')));
    }
}
