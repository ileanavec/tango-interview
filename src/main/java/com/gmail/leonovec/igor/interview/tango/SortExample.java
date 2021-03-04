package com.gmail.leonovec.igor.interview.tango;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortExample {

    /**
     * Sort {@code input} string according to the order of characters in {@code alphabet} list
     * Expected time complexity - O(n)
     * You should expect any characters in the arguments, not only 'a' - 'z'
     * If some character exists in {@code input} string and {@code alphabet} list doesn't contain it,
     * than you need to put it to end of resulting string in any order
     */
    public static String sort(String input, List<Character> alphabet) {
        char[] inputChars = input.toCharArray();
        Map<Character, Integer> alphabetByIndexes = getAlphabetByIndexes(alphabet);
        int[] charCounts = new int[alphabet.size() + 1];

        for (char currChar : inputChars) {
            Integer charIndex = alphabetByIndexes.get(currChar);
            if (charIndex != null) {
                charCounts[charIndex]++;
            } else {
                charCounts[charCounts.length - 1]++;
            }
        }

        for (int i = 1; i < charCounts.length; i++) {
            charCounts[i] += charCounts[i - 1];
        }

        char[] sortedChars = new char[inputChars.length];

        for (int i = inputChars.length - 1; i >= 0; i--) {
            char currChar = inputChars[i];
            Integer charIndex = alphabetByIndexes.get(currChar);
            if (charIndex != null) {
                sortedChars[charCounts[charIndex] - 1] = currChar;
                charCounts[charIndex]--;
            } else {
                sortedChars[charCounts[charCounts.length - 1] -1] = currChar;
                charCounts[charCounts.length - 1]--;
            }
        }

        return String.valueOf(sortedChars);
    }

    private static Map<Character, Integer> getAlphabetByIndexes(List<Character> alphabet) {
        Map<Character, Integer> alphabetByIndexes = new HashMap<>(alphabet.size());
        int index = 0;
        for (Character character : alphabet) {
            alphabetByIndexes.put(character, index++);
        }
        return alphabetByIndexes;
    }
}
