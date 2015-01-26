package com.ffbit.algorithms.string;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * @see <a href="http://www.careercup.com/question?id=5111068527427584">Anagrams</a>
 * @see <a href="http://rosettacode.org/wiki/Anagrams">Anagrams</a>
 */
public class AnagramsTest {
    private Anagrams anagramFinder = new Anagrams();

    @Test
    public void itShouldFindAnagrams() {
        List<String> words =
                asList("star", "rats", "ice", "cie", "arts", "bike");

        assertThat(
                anagramFinder.findAnagrams(words),
                containsInAnyOrder(
                        asList("cie", "ice"),
                        asList("arts", "rats", "star"),
                        asList("bike")
                )
        );
    }

}
