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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] richer;
    private int[] quiet;

    public int[] process() {
        return loudAndRich(richer, quiet);
    }

    public Practice(int[][] richer, int[] quiet) {
        this.richer = richer;
        this.quiet = quiet;
    }

    private Map<Integer, List<Integer>> riches;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        if (richer == null || richer.length == 0) return IntStream.range(0, quiet.length).toArray();

        riches = new HashMap<>();
        for (int[] relation : richer) {
            riches.computeIfPresent(relation[1], (i, l) -> {l.add(relation[0]); return l;});
            riches.putIfAbsent(relation[1], new ArrayList<>(List.of(relation[0])));
        }

        int[] answer = new int[quiet.length];
        Arrays.fill(answer, -1);

        for (int person = 0; person < answer.length; person++) {
            if (answer[person] < 0) recursiveQuietness(quiet, person, answer);
        }

        return answer;
    }

    private int recursiveQuietness(int[] quiet, int person, int[] answer) {
        answer[person] = person;

        if (!riches.containsKey(person)) return person;

        int quietestPerson = person;
        for (int richerPerson : riches.get(person)) {
            int quietestRicher = answer[richerPerson];
            if (quietestRicher < 0) {
                quietestRicher = recursiveQuietness(quiet, richerPerson, answer);
            }
            if (quiet[quietestRicher] < quiet[quietestPerson]) quietestPerson = quietestRicher;
        }

        answer[person] = quietestPerson;
        return quietestPerson;
    }
}
