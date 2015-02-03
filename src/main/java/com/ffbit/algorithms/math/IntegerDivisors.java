package com.ffbit.algorithms.math;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Find all positive integers which evenly divide a given positive number.
 */
public class IntegerDivisors {

    public List<Integer> divisors(int n) {
        List<Integer> head = new ArrayList<>();
        Deque<Integer> tail = new LinkedList<>();

        tail.add(n);
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (gcd(i, n) == i) {
                if (i != tail.peek()) {
                    head.add(i);

                    int mirrorDivisor = n / i;
                    if (mirrorDivisor != i && tail.peek() != mirrorDivisor) {
                        tail.push(mirrorDivisor);
                    }
                }
            }
        }

        head.addAll(tail);

        return head;
    }

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }

}
