package com.ffbit.algorithms.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static junitparams.JUnitParamsRunner.$;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class PeakFinder1DTest {
    private int[] numbers;
    private int expectedPeak;

    private PeakFinder1D peakFinder = new PeakFinder1D();

    public PeakFinder1DTest(int[] numbers, int expectedPeak) {
        this.numbers = numbers;
        this.expectedPeak = expectedPeak;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                $(new int[]{}, -1),
                $(new int[]{1}, -1),
                $(new int[]{3, 1}, -1),
                $(new int[]{3, 2, 1}, -1),

                $(new int[]{1, 3}, 3),
                $(new int[]{1, 3, 2}, 3),
                $(new int[]{1, 2, 3}, 3),
                $(new int[]{0, 1, 2, 3, 4, 5, 4, 3}, 5),
                $(new int[]{3, 4, 5, 4, 3, 2, 1, 100}, 5)
        });
    }

    @Test
    public void itShouldPerformStraightForwardFind() {
        assertThat(peakFinder.straightForwardFind(numbers), is(expectedPeak));
    }

    @Test
    public void itShouldPerformBinaryFind() {
        assertThat(peakFinder.binaryFind(numbers), is(expectedPeak));
    }

}
