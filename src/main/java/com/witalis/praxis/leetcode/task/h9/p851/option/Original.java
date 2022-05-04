package com.witalis.praxis.leetcode.task.h9.p851.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.IntStream;

/**
 * ID: 851
 * Name: Loud and Rich
 * URL: <a href="https://leetcode.com/problems/loud-and-rich/">Loud and Rich</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] richer;
    private int[] quiet;

    public int[] process() {
        return loudAndRich(richer, quiet);
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        if (richer == null || richer.length == 0) return IntStream.range(0, quiet.length).toArray();

        Map<Integer, List<Integer>> riches = new HashMap<>();
        for (int[] relation : richer) {
            riches.computeIfPresent(relation[1], (i, l) -> {l.add(relation[0]); return l;});
            riches.putIfAbsent(relation[1], new ArrayList<>(List.of(relation[0])));
        }

        int[] answer = new int[quiet.length];
        Arrays.fill(answer, -1);

        for (int person = 0; person < answer.length; person++) {
            if (answer[person] < 0) {
                recursiveQuietness(riches, quiet, person, answer);
            }
        }

        return answer;
    }

    private int recursiveQuietness(Map<Integer, List<Integer>> riches, int[] quiet, int person, int[] answer) {
        answer[person] = person;

        if (!riches.containsKey(person)) return person;

        int quietestPerson = person;
        for (int richerPerson : riches.get(person)) {
            int quietestRicher = answer[richerPerson];
            if (quietestRicher < 0) {
                quietestRicher = recursiveQuietness(riches, quiet, richerPerson, answer);
            }
            if (quiet[quietestRicher] < quiet[quietestPerson]) quietestPerson = quietestRicher;
        }

        answer[person] = quietestPerson;
        return quietestPerson;
    }
}
