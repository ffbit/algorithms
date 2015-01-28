package com.ffbit.algorithms.math;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class FastExponentTest {
    private FastExponent fastExponent = new FastExponent();

    @Test
    @Parameters({
            "0, 1",
            "1, 2",
            "2, 4",
            "3, 8",
            "4, 16",
            "5, 32",
            "6, 64",
            "7, 128",
            "8, 256",
            "9, 512",
            "10, 1024",
            "11, 2048",
    })
    public void itShouldExponentiateTwo(int exponent, int expectedValue) {
        assertThat(fastExponent.exponentiate(2, exponent), is(expectedValue));
    }

}
