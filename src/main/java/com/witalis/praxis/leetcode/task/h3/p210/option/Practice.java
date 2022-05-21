package com.witalis.praxis.leetcode.task.h3.p210.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.IntStream;

/**
 * ID: 210
 * Name: Course Schedule II
 * URL: <a href="https://leetcode.com/problems/course-schedule-ii/">Course Schedule II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int numCourses;
    private int[][] prerequisites;

    public Practice(int numCourses, int[][] prerequisites) {
        this.numCourses = numCourses;
        this.prerequisites = prerequisites;
    }

    public int[] process() {
        return findOrder(numCourses, prerequisites);
    }

    private Map<Integer, List<Integer>> requisites = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[0];
        if (prerequisites == null || prerequisites.length == 0) return IntStream.range(0, numCourses).toArray();

        List<Integer> courses = new ArrayList<>();

        for (int[] prerequisite : prerequisites) {
            requisites.computeIfPresent(prerequisite[1], (i, l) -> {l.add(prerequisite[0]); return l;});
            requisites.putIfAbsent(prerequisite[1], new ArrayList<>(List.of(prerequisite[0])));
        }

        boolean[] processed = new boolean[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (!processed[course] && !recursiveRequisites(courses, course, new HashSet<>(), processed)) return new int[0];
        }

        Collections.reverse(courses);

        return courses.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean recursiveRequisites(List<Integer> courses, int course, Set<Integer> chain, boolean[] processed) {
        if (processed[course]) return true;
        if (chain.contains(course)) return false;
        if (!requisites.containsKey(course)) {
            courses.add(course);
            processed[course] = true;
            return true;
        }

        chain.add(course);
        for (int next : requisites.get(course)) {
            if (!processed[next] && !recursiveRequisites(courses, next, chain, processed)) return false;
        }
        chain.remove(course);

        courses.add(course);
        processed[course] = true;
        return true;
    }
}
