package com.witalis.praxis.leetcode.task.h3.p207.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 207
 * Name: Course Schedule
 * URL: <a href="https://leetcode.com/problems/course-schedule/">Course Schedule</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int numCourses;
    private int[][] prerequisites;

    public Boolean process() {
        return canFinish(numCourses, prerequisites);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return false;
        if (prerequisites == null || prerequisites.length == 0) return true;

        Map<Integer, List<Integer>> requisites = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            requisites.computeIfPresent(prerequisite[1], (i, l) -> {l.add(prerequisite[0]); return l;});
            requisites.putIfAbsent(prerequisite[1], new ArrayList<>(List.of(prerequisite[0])));
        }

        boolean[] processed = new boolean[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (!processed[course]) {
                if (!recursiveRequisites(requisites, course, new HashSet<>(), processed)) return false;
            }
        }

        return true;
    }

    private boolean recursiveRequisites(
        Map<Integer, List<Integer>> requisites,
        int course,
        Set<Integer> chain,
        boolean[] processed
    ) {
        if (processed[course]) return true;
        if (chain.contains(course)) return false;
        if (!requisites.containsKey(course)) {
            processed[course] = true;
            return true;
        }

        chain.add(course);
        for (int next : requisites.get(course)) {
            if (!processed[next]) {
                if (!recursiveRequisites(requisites, next, chain, processed)) return false;
            }
        }
        chain.remove(course);

        processed[course] = true;
        return true;
    }
}
