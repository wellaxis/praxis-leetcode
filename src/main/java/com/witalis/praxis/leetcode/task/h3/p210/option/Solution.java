package com.witalis.praxis.leetcode.task.h3.p210.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 210
 * Name: Course Schedule II
 * URL: <a href="https://leetcode.com/problems/course-schedule-ii/">Course Schedule II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int numCourses;
    private int[][] prerequisites;

    public int[] process() {
        return findOrder(numCourses, prerequisites);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        // create the adjacency list representation of the graph
        for (int[] prerequisite : prerequisites) {
            int dest = prerequisite[0];
            int src = prerequisite[1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            adjList.put(src, lst);

            // record in-degree of each vertex
            inDegree[dest] += 1;
        }

        // add all vertices with 0 in-degree to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        // process until the queue becomes empty
        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            topologicalOrder[i++] = node;

            // reduce the in-degree of each neighbor by 1
            if (adjList.containsKey(node)) {
                for (Integer neighbor : adjList.get(node)) {
                    inDegree[neighbor]--;

                    // if in-degree of a neighbor becomes 0, add it to the queue
                    if (inDegree[neighbor] == 0) queue.add(neighbor);
                }
            }
        }

        // check to see if topological sort is possible or not.
        if (i == numCourses) return topologicalOrder;

        return new int[0];
    }
}
