package com.ffbit.algorithms.math;

/**
 * @see <a href="http://en.wikipedia.org/wiki/Greatest_common_divisor">Greatest common divisor</a>
 */
public class GreaterCommonDivisor {

    public int gcd(int a, int b) {
        checkParameters(a, b);

        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }

    private void checkParameters(int a, int b) {
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("Both parameters are zero");
        }
    }

}
