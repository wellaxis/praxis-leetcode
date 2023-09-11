package com.witalis.praxis.leetcode.task.h13.p1282.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1282
 * Name: Group the People Given the Group Size They Belong To
 * URL: <a href="https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/">Group the People Given the Group Size They Belong To</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] groupSizes;

    public List<List<Integer>> process() {
        return groupThePeople(groupSizes);
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();

        // a map from group size to the list of indices that are there in the group
        Map<Integer, List<Integer>> szToGroup = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!szToGroup.containsKey(groupSizes[i])) {
                szToGroup.put(groupSizes[i], new ArrayList<>());
            }

            List<Integer> group = szToGroup.get(groupSizes[i]);
            group.add(i);

            // when the list size equals the group size, empty it and store it in the answer
            if (group.size() == groupSizes[i]) {
                ans.add(group);
                szToGroup.remove(groupSizes[i]);
            }
        }

        return ans;
    }
}
