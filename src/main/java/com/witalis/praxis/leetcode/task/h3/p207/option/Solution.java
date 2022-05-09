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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int numCourses;
    private int[][] prerequisites;

    public Boolean process() {
        return canFinish(numCourses, prerequisites);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();

        for (int[] edge : prerequisites) {
            Set<Integer> uppers = graph.getOrDefault(edge[1], new HashSet<>());
            uppers.add(edge[0]);
            graph.put(edge[1], uppers);

            int inDegree = inDegrees.getOrDefault(edge[0], 0);
            inDegree++;
            inDegrees.put(edge[0], inDegree);
            inDegrees.put(edge[1], inDegrees.getOrDefault(edge[1], 0));
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int course : inDegrees.keySet()) {
            if (inDegrees.get(course) == 0) {
                queue.offer(course);
            }
        }

        int sorted = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            sorted++;

            if (graph.containsKey(course)) {
                for (int upper : graph.get(course)) {
                    int inDegree = inDegrees.get(upper) - 1;
                    inDegrees.put(upper, inDegree);
                    if (inDegree == 0) {
                        queue.offer(upper);
                    }
                }
            }
        }
        return sorted == inDegrees.size();
    }
}
