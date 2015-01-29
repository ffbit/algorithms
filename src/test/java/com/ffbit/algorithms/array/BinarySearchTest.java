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
public class BinarySearchTest {
    private int[] numbers;
    private int needle;
    private int position;

    private BinarySearch binarySearch = new BinarySearch();

    public BinarySearchTest(int[] numbers, int needle, int position) {
        this.numbers = numbers;
        this.needle = needle;
        this.position = position;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1}, 1, 0},
                {new int[]{1, 4}, 1, 0},
                {new int[]{1, 4}, 4, 1},
                {new int[]{1, 4, 5}, 1, 0},
                {new int[]{1, 4, 5}, 4, 1},
                {new int[]{1, 4, 5}, 5, 2},
                {new int[]{1, 4, 5, 8}, 8, 3},

                {new int[]{}, 1, -1},
                {new int[]{0}, 1, -2},
                {new int[]{1, 3}, 0, -1},
                {new int[]{1, 3}, 2, -2},
                {new int[]{1, 3}, 4, -3},
        });
    }

    @Test
    public void itShouldPerformBinarySearch() {
        assertThat(binarySearch.binarySearch(numbers, needle), is(position));
    }

}
