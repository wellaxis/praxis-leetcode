package com.witalis.praxis.leetcode.task.h12.p1125.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1125
 * Name: Smallest Sufficient Team
 * URL: <a href="https://leetcode.com/problems/smallest-sufficient-team/">Smallest Sufficient Team</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] reqSkills;
    private List<List<String>> people;

    public int[] process() {
        return smallestSufficientTeam(reqSkills, people);
    }

    public int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
        if (reqSkills == null || people == null) return new int[0];

        final int n = reqSkills.length;
        final Map<String, Set<Integer>> memo = new HashMap<>();

        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(reqSkills[i], i);

        final Set<Integer> team = helper(people, map, memo, new boolean[n]);
        if (team == null || team.isEmpty()) return new int[0];

        return team.stream().mapToInt(Integer::intValue).toArray();
    }

    private Set<Integer> helper(List<List<String>> people, Map<String, Integer> map, Map<String, Set<Integer>> memo, boolean[] takenSkills) {
        boolean taken = true;
        for (boolean skill : takenSkills) {
            if (!skill) {
                taken = false;
                break;
            }
        }
        if (taken) return new HashSet<>();

        final String key = Arrays.toString(takenSkills);
        if (memo.containsKey(key)) return memo.get(key);

        Set<Integer> skills = null;
        int minLength = Integer.MAX_VALUE;

        final boolean[] tempSkills = takenSkills.clone();
        for (int i = 0; i < people.size(); i++) {
            takenSkills = tempSkills.clone();

            for (String skill : people.get(i))
                takenSkills[map.get(skill)] = true;

            boolean candidate = false;
            for (int j = 0; j < tempSkills.length; j++) {
                if (tempSkills[j] != takenSkills[j]) {
                    candidate = true;
                    break;
                }
            }

            if (candidate) {
                Set<Integer> candidateSkills = new HashSet<>(helper(people, map, memo, takenSkills));
                candidateSkills.add(i);
                if (candidateSkills.size() < minLength) {
                    minLength = candidateSkills.size();
                    skills = candidateSkills;
                }
            }
        }

        memo.put(key, skills);

        return skills;
    }
}
