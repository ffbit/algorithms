package com.ffbit.algorithms.string;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @see <a href="http://www.careercup.com/question?id=5111068527427584">Anagrams</a>
 * @see <a href="http://rosettacode.org/wiki/Anagrams">Anagrams</a>
 */
public class Anagrams {

    public Collection<List<String>> findAnagrams(List<String> words) {
        Function<String, String> group = word -> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        };

        return words.stream()
                .sorted()
                .collect(Collectors.groupingBy(group))
                .values();
    }

}
