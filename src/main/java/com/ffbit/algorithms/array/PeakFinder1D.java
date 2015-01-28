package com.ffbit.algorithms.array;

/**
 * Peak Finder - One-dimensional version
 * <p/>
 * Given an array of numbers<br />
 * <pre>
 * [a, b, c, d, e, f, g, h, i]
 *  1, 2, 3, 4, 5, 6, 7, 8, 9
 * </pre>
 * where <i>a</i>-<i>i</i> are numbers
 * <p/>
 * Position 2 is a peak if and only if b >= a and b >= c<br />
 * Position 9 is a peak iff i >= h<br />
 * <p/>
 * Problem: Find <b>a peak</b> if it exists.
 *
 * @see <a href="http://www.youtube.com/watch?v=HtSuA80QTyo&feature=youtu.be&t=15m22s">1. Algorithmic Thinking, Peak Finding 15:22</a>
 */
public class PeakFinder1D {

    /**
     * A straight forward find implementation which makes up to O(n)
     * comparisons.
     *
     * @param numbers numbers to search
     * @return value of a found peak, if exists or -1 otherwise.
     */
    public int straightForwardFind(int[] numbers) {
        int n = numbers.length;

        for (int i = 1; i < n - 1; i++) {
            if (numbers[i - 1] <= numbers[i] && numbers[i] >= numbers[i + 1]) {
                return numbers[i];
            }
        }

        if (n >= 2 && numbers[n - 2] <= numbers[n - 1]) {
            return numbers[n - 1];
        }

        return -1;
    }

}
