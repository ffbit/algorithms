package com.ffbit.algorithms.math;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class GreaterCommonDivisorTest {
    private GreaterCommonDivisor gcd = new GreaterCommonDivisor();

    @Test
    @Parameters({
            "8,  12, 4",
            "12, 8,  4",
            "5,  15, 5",
            "15, 5,  5",
            "3,  5,  1",
            "5,  3,  1",
            "3,  4,  1",
            "4,  3,  1",
            "1,  2,  1",
            "2,  1,  1",
            "1,  1,  1"
    })
    public void itShouldFindGreatestCommonDivisorOfTwoNonZeroIntegers(
            int a, int b, int expectedGcd
    ) {
        assertThat(gcd.gcd(a, b), is(expectedGcd));
    }

    @Test
    @Parameters({
            "3, 0, 3",
            "0, 2, 2"
    })
    public void itShouldFindGreatestCommonDivisorOfOneZeroInteger(
            int a, int b, int expectedGcd
    ) {
        assertThat(gcd.gcd(a, b), is(expectedGcd));
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldFindGreatestCommonDivisorOfTwoNonZeroIntegers() {
        gcd.gcd(0, 0);
    }

}
