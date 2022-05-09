package com.witalis.praxis.leetcode.task.h3.p207;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p207.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 207,
    description = "Course Schedule",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {GRAPH, TOPOLOGICAL_SORT, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class CourseSchedule extends LeetCodeTask<Boolean> {
    public static final int LEN = 2_000;
    public static final int SIZE = 5_000;
    private int numCourses;
    private int[][] prerequisites;

    public static final String INFORMATION = """

        There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
            You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
            that you must take course bi first if you want to take course ai.
            * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

        Return true if you can finish all courses. Otherwise, return false.

        Example:
            Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
            Output: false
            Explanation: There are a total of 2 courses to take.
                To take course 1 you should have finished course 0,
                and to take course 0 you should also have finished course 1.
                So it is impossible.""";

    public CourseSchedule(int id, String description, TaskRevision revision) {
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

    // dfs, time = 7096 ms
    @Override
    protected Boolean original() {
        var original = new Original(numCourses, prerequisites);
        return original.process();
    }

    // dfs, time = 5231 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(numCourses, prerequisites);
        return practice.process();
    }

    // bfs, time = 6739 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(numCourses, prerequisites);
        return solution.process();
    }
}
