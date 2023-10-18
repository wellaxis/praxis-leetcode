package com.witalis.praxis.leetcode.task.h21.p2050;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h21.p2050.option.*;
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
    id = 2050,
    description = "Parallel Courses III",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, GRAPH, TOPOLOGICAL_SORT}
)
public class ParallelCoursesIII extends LeetCodeTask<Integer> {
    public static final int LEN = 50_000;
    public static final int TIME = 10_000;

    private int size;
    private int[][] relations;
    private int[] times;

    public static final String INFORMATION = """

        Description:
            You are given an integer n, which indicates that there are n courses labeled from 1 to n.
                You are also given a 2D integer array relations where relations[j] = [prevCoursej, nextCoursej] denotes
                that course prevCoursej has to be completed before course nextCoursej (prerequisite relationship).
                Furthermore, you are given a 0-indexed integer array time where time[i] denotes
                how many months it takes to complete the (i+1)th course.

            You must find the minimum number of months needed to complete all the courses following these rules:
                * You may start taking a course at any time if the prerequisites are met.
                * Any number of courses can be taken at the same time.

            Return the minimum number of months needed to complete all the courses.

            Note: The test cases are generated such that it is possible to complete every course
                (i.e., the graph is a directed acyclic graph).

        Example:
            Input: n = 5, relations = [[1,5],[2,5],[3,5],[3,4],[4,5]], time = [1,2,3,4,5]
            Output: 12
            Explanation: The figure above represents the given graph and the time required to complete each course.
                You can start courses 1, 2, and 3 at month 0.
                You can complete them after 1, 2, and 3 months respectively.
                Course 4 can be taken only after course 3 is completed, i.e., after 3 months. It is completed after 3 + 4 = 7 months.
                Course 5 can be taken only after courses 1, 2, 3, and 4 have been completed, i.e., after max(1,2,3,7) = 7 months.
                Thus, the minimum time needed to complete all the courses is 7 + 5 = 12 months.""";

    public ParallelCoursesIII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.size = random.nextInt(1, LEN + 1);
        int len = random.nextInt(0, Math.min(size * (size - 1) / 2, LEN));
        this.relations = new int[len][2];
        Set<String> pairs = new HashSet<>();
        for (int i = 0; i < len; i++) {
            int prev = random.nextInt(1, size + 1);
            int next = random.nextInt(1, size + 1);
            while (next == prev)
                next = random.nextInt(1, size + 1);
            String value = prev + "/" + next;
            if (!pairs.contains(value)) {
                relations[i] = new int[] {prev, next};
                pairs.add(value);
            }
        }
        this.times = random.ints(size, 1, TIME + 1).toArray();

        log.info("Size 'n': {}", size);
        log.info("Relations: {}", Arrays.deepToString(relations));
        log.info("Times: {}", Arrays.toString(times));
    }

    public static int[][] cloneMatrix(int[][] matrix) {
        if (matrix == null) return new int[0][0];

        return Arrays.stream(matrix)
            .map(int[]::clone)
            .toArray(int[][]::new);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 24622 ms
    @Override
    protected Integer original() {
        var original = new Original(size, cloneMatrix(relations), times.clone());
        return original.process();
    }

    // time = 22184 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(size, cloneMatrix(relations), times.clone());
        return practice.process();
    }

    // time = 8642 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(size, cloneMatrix(relations), times.clone());
        return solution.process();
    }
}
