package com.witalis.praxis.leetcode.task.h12.p1125.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ID: 1125
 * Name: Smallest Sufficient Team
 * URL: <a href="https://leetcode.com/problems/smallest-sufficient-team/">Smallest Sufficient Team</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] reqSkills;
    private List<List<String>> people;

    public Solution(String[] reqSkills, List<List<String>> people) {
        this.reqSkills = reqSkills;
        this.people = people;
    }

    public int[] process() {
        return smallestSufficientTeam(reqSkills, people);
    }

    private List<Integer> sol = new ArrayList<>();

    public int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
        //skills are represented by 0, 1, 2....
        Map<String, Integer> idx = new HashMap<>();
        int n = 0;
        for (String s : reqSkills) idx.put(s, n++);
        int[] pe = new int[people.size()];
        for (int i = 0; i < pe.length; i++) {
            for (String p : people.get(i)) {
                int skill = idx.get(p);
                pe[i] += 1 << skill;
            }
        }
        // each person is transferred to a number, of which the bits of 1 means the guy has the skill
        search(0, pe, new ArrayList<>(), n);
        int[] ans = new int[sol.size()];
        for (int i = 0; i < sol.size(); i++) ans[i] = sol.get(i);

        return ans;
    }

    public void search(int cur, int[] pe, List<Integer> oneSol, int n) {
        // when all bits are 1, all skills are covered
        if (cur == (1 << n) - 1) {
            if (sol.isEmpty() || oneSol.size() < sol.size()) {
                sol = new ArrayList<>(oneSol);
            }
            return;
        }
        //pruning
        if (!sol.isEmpty() && oneSol.size() >= sol.size()) return;
        int zeroBit = 0;
        while (((cur >> zeroBit) & 1) == 1) zeroBit++;
        for (int i = 0; i < pe.length; i++) {
            int per = pe[i];
            // when a person can cover a zero bit in the current number, we can add him
            if (((per >> zeroBit) & 1) == 1) {
                oneSol.add(i);
                search(cur | per, pe, oneSol, n);
                //search in a backtracking way
                oneSol.remove(oneSol.size() - 1);
            }
        }
    }
}
