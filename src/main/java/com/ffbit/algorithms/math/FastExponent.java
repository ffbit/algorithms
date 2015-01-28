package com.ffbit.algorithms.math;

public class FastExponent {

    public int exponentiate(int base, int exponent) {
        int result = 1;

        while (exponent > 0) {
            if (exponent % 2 != 0) {
                result = result * base;
            }

            exponent = exponent / 2;
            base = base * base;
        }

        return result;
    }

}
