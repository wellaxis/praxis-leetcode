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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] groupSizes;

    public List<List<Integer>> process() {
        return groupThePeople(groupSizes);
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        if (groupSizes == null) return Collections.emptyList();

        List<List<Integer>> groups = new ArrayList<>();
        Map<Integer, List<Integer>> people = new HashMap<>();

        final int n = groupSizes.length;
        for (int i = 0; i < n; i++) {
            people.putIfAbsent(groupSizes[i], new ArrayList<>());
            people.get(groupSizes[i]).add(i);
        }

        people.forEach(
            (capacity, persons) -> {
                List<Integer> group = new ArrayList<>();
                for (int person : persons) {
                    group.add(person);
                    if (group.size() % capacity == 0) {
                        groups.add(group);
                        group = new ArrayList<>();
                    }
                }
            }
        );

        return groups;
    }
}
