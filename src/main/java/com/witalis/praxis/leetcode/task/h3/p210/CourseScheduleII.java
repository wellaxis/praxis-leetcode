package com.witalis.praxis.leetcode.task.h3.p210;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p210.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 210,
    description = "Course Schedule II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {GRAPH, TOPOLOGICAL_SORT, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class CourseScheduleII extends LeetCodeTask<int[]> {
    public static final int LEN = 2_000;
    public static final int SIZE = 5_000;
    private int numCourses;
    private int[][] prerequisites;

    public static final String INFORMATION = """

        There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
            You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
            that you must take course bi first if you want to take course ai.
            * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

        Return the ordering of courses you should take to finish all courses.
            If there are many valid answers, return any of them.
            If it is impossible to finish all courses, return an empty array.

        Example:
            Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
            Output: [0,2,1,3]
            Explanation: There are a total of 4 courses to take.
                To take course 3 you should have finished both courses 1 and 2.
                Both courses 1 and 2 should be taken after you finished course 0.
                So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].""";

    public CourseScheduleII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();
        final int combination = 20;

        this.numCourses = random.nextInt(1, LEN + 1);
        log.info("Courses are {}", numCourses);

        int counter = 0;
        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            for (int j = i + 1; j < numCourses; j++) {
                if (random.nextInt(0, combination + 1) == 0) {
                    set.add(new int[] {i, j});
                    counter++;
                }
            }
            if (counter >= SIZE) break;
        }

        this.prerequisites = set.toArray(int [][]::new);
        log.info("Prerequisites len {}", prerequisites.length);

        var builder = new StringBuilder();
        for (int[] prerequisite: prerequisites) {
            builder.append(Arrays.toString(prerequisite)).append(' ');
        }
        log.info("Prerequisites are {}", builder);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // dfs, time = 21887 ms
    @Override
    protected int[] original() {
        var original = new Original(numCourses, prerequisites);
        return original.process();
    }

    // dfs, time = 13400 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numCourses, prerequisites);
        return practice.process();
    }

    // bfs, time = 5788 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numCourses, prerequisites);
        return solution.process();
    }
}
