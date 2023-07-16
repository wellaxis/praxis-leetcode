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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] reqSkills;
    private List<List<String>> people;

    public int[] process() {
        return smallestSufficientTeam(reqSkills, people);
    }

    public int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
        if (reqSkills == null || people == null) return new int[0];

        int n = reqSkills.length;
        Map<String, Set<Integer>> dp = new HashMap<>();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(reqSkills[i], i);
        }

        Set<Integer> skills = helper(people, map, dp, new boolean[n]);
        if (skills == null || skills.isEmpty()) return new int[0];

        return skills.stream().mapToInt(Integer::intValue).toArray();
    }

    private Set<Integer> helper(List<List<String>> people, Map<String, Integer> map, Map<String, Set<Integer>> dp, boolean[] hasSkills) {
        boolean taken = true;
        for (boolean skill : hasSkills) {
            if (!skill) {
                taken = false;
                break;
            }
        }
        if (taken) return new HashSet<>();

        String key = Arrays.toString(hasSkills);
        if (dp.containsKey(key)) return dp.get(key);

        Set<Integer> skills = null;
        int minLength = Integer.MAX_VALUE;

        boolean[] temp = hasSkills.clone();
        for (int i = 0; i < people.size(); i++) {
            hasSkills = temp.clone();

            for (String skill : people.get(i)) {
                hasSkills[map.get(skill)] = true;
            }

            boolean candidate = false;
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] != hasSkills[j]) {
                    candidate = true;
                    break;
                }
            }

            if (candidate) {
                Set<Integer> set = new HashSet<>(helper(people, map, dp, hasSkills));
                set.add(i);
                if (set.size() < minLength) {
                    minLength = set.size();
                    skills = set;
                }
            }
        }

        dp.put(key, skills);

        return skills;
    }
}
