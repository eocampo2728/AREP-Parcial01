package edu.escuelaing.arep.parcialpractico;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class WebAppTest {

    @Test
    public void positiveTest() {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        ListOperations.mergeSort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }
}
