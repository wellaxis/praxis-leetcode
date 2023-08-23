package com.witalis.praxis.leetcode.task.h8.p767.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 767
 * Name: Reorganize String
 * URL: <a href="https://leetcode.com/problems/reorganize-string/">Reorganize String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public String process() {
        return reorganizeString(string);
    }

    class Letter {
        private char letter;
        private int frequency;

        public Letter(char letter, int frequency) {
            this.letter = letter;
            this.frequency = frequency;
        }
    }

    public String reorganizeString(String s) {
        if (s == null || s.isEmpty()) return "";

        char[] letters = s.toCharArray();
        int n = letters.length;

        final int[] frequencies = new int[26];
        for (char letter : letters)
            frequencies[letter - 'a']++;

        Comparator<Letter> compareByFrequency = Comparator.comparingInt(l -> l.frequency);
        Queue<Letter> heap = new PriorityQueue<>(compareByFrequency.reversed());
        for (int i = 0; i < 26; i++)
            if (frequencies[i] > 0)
                heap.offer(new Letter((char) (i + 'a'), frequencies[i]));

        StringBuilder builder = new StringBuilder();
        char previousLetter = '.';
        while (n-- > 0) {
            Letter topLetter = null;
            Letter maxLetter = heap.peek();

            if (maxLetter.letter == previousLetter) {
                topLetter = heap.poll();
                if (heap.isEmpty()) return "";
                maxLetter = heap.peek();
            }

            builder.append(maxLetter.letter);
            maxLetter.frequency--;
            previousLetter = maxLetter.letter;
            if (maxLetter.frequency == 0)
                heap.poll();

            if (topLetter != null) heap.offer(topLetter);
        }

        return builder.toString();
    }
}
