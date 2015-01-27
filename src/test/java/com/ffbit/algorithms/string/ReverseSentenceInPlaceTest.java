package com.ffbit.algorithms.string;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ReverseSentenceInPlaceTest {
    private ReverseSentenceInPlace reverser = new ReverseSentenceInPlace();

    @Test
    @Parameters({
            "the sky is blue, blue is sky the",
            "I wish you a merry Christmas, Christmas merry a you wish I",
            "The quick brown fox jumps over the lazy dog, dog lazy the over jumps fox brown quick The"
    })
    public void itShouldReverseSentence(String sentence, String reversed) {
        assertThat(
                reverser.reverse(sentence.toCharArray()),
                is(reversed.toCharArray())
        );
    }

}
