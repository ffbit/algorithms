package com.ffbit.algorithms.string;

/**
 * Inplace reverse a sentence.
 * <p/>
 * You given a sentence of english words and spaces between them.
 * <br/>
 * Nothing crazy:<br/>
 * 1) no double spaces<br/>
 * 2) no empty words<br/>
 * 3) no spaces at the ends of a sentence
 * <pre><code>
 * void inplace_reverse(char* arr, int length) {
 * // your solution
 * }
 * </code></pre>
 * Example:<br/>
 * input "I wish you a merry Christmas"<br/>
 * output "Christmas merry a you wish I"<br/>
 * <p/>
 * Constrains: O(1) additional memory<br/>
 *
 * @see <a href="http://www.careercup.com/question?id=5717567253512192">Inplace reverse a sentence </a>
 */
public class ReverseSentenceInPlace {

    public char[] reverse(char[] sentence) {
        reverseWholeSentence(sentence);
        reverseEachWord(sentence);

        return sentence;
    }

    private void reverseWholeSentence(char[] sentence) {
        reverse(sentence, 0, sentence.length);
    }

    private void reverseEachWord(char[] sentence) {
        int wordStartIndex = 0;
        for (int i = 0; i < sentence.length; i++) {
            if (sentence[i] == ' ') {
                reverse(sentence, wordStartIndex, i);
                wordStartIndex = i + 1;
            } else if (i == sentence.length - 1) {
                reverse(sentence, wordStartIndex, sentence.length);
            }
        }
    }

    private void reverse(char[] sentence, int from, int to) {
        for (int i = 0; i < (to - from) / 2; i++) {
            swap(sentence, from + i, to - 1 - i);
        }
    }

    private void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
