package sk.examples.string.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Given a list of digits, print all possible words.
 * ie, given 223, print AAD, AAE, AAF
 *
 * Mapping
 * 2 -> a, b, c
 * 3 -> d, e, f
 *
 * Solution
 * 223
 * a, b, c
 * aa, ab, ac
 * aad, aae, aaf, abd, abe, abf, ...
 *
 * Algorithm:
    start with 1st digit
        get its mapping
        combine it with all of the mappings in the next
        if at last digit
            add to the list

    Alternative:
    seed q with first char mapping
    while q is not empty
        pop it
        populate it with next digit mappings
 *
 *
 */
public class PhoneWordFinder {
    Map<Character, List<Character>> mapping;

    public PhoneWordFinder() {
        initMapping();
    }

    private void initMapping() {
        mapping = new HashMap<>();
        mapping.put('2', Arrays.asList('A', 'B', 'C'));
        mapping.put('3', Arrays.asList('D', 'E', 'F'));
    }

    private void findWords(String combo) {
        List<Character> characters = mapping.get(combo.charAt(0));
        List<String> words = new ArrayList<>();
        Queue<String> wordQ = new LinkedBlockingQueue<>();
        for (Character character : characters) {
            wordQ.add(character + "");
        }

        while (!wordQ.isEmpty()) {
            String word = wordQ.remove();
            if (word.length() == combo.length()) {
                words.add(word);
            } else {
                char nextDigit = combo.charAt(word.length());
                List<Character> nextMappings = mapping.get(nextDigit);
                for (Character character : nextMappings) {
                    wordQ.add(word + character);
                }
            }
        }

        System.out.println(words);

    }

    public static void main(String[] args) {
        new PhoneWordFinder().findWords("223");
    }
}
