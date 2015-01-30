package com.ffbit.algorithms.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ReverseArrayTest {
    private int[] original;
    private int[] reversed;

    private ReverseArray reverser = new ReverseArray();

    public ReverseArrayTest(int[] original, int[] reversed) {
        this.original = original;
        this.reversed = reversed;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, new int[]{}},
                {new int[]{1}, new int[]{1}},
                {new int[]{1, 2}, new int[]{2, 1}},
                {new int[]{1, 2, 3}, new int[]{3, 2, 1}},
                {new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1}},
                {new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}},

                {new int[]{1, 1, 2, 3, 5, 8}, new int[]{8, 5, 3, 2, 1, 1}}
        });
    }

    @Test
    public void itShouldReverseArray() {
        assertThat(reverser.reverse(original), is(reversed));
    }

}
