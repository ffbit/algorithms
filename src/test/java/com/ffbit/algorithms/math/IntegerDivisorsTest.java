package com.ffbit.algorithms.math;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class IntegerDivisorsTest {
    private IntegerDivisors divisorsFinder = new IntegerDivisors();

    @Test
    @Parameters(method = "fixture")
    public void itShouldFindAllPositiveDivisors(
            int n, Integer[] expectedDivisors) {
        assertThat(divisorsFinder.divisors(n), contains(expectedDivisors));
    }

    private Object fixture() {
        return Arrays.asList(new Object[][]{
                {1, new Integer[]{1}},
                {2, new Integer[]{1, 2}},
                {6, new Integer[]{1, 2, 3, 6}},
                {9, new Integer[]{1, 3, 9}},
                {12, new Integer[]{1, 2, 3, 4, 6, 12}},
                {144, new Integer[]{1, 2, 3, 4, 6, 8, 9, 12, 16, 18, 24, 36, 48, 72, 144}}
        });
    }

}
