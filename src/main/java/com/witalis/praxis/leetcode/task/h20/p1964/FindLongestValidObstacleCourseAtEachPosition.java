package com.witalis.praxis.leetcode.task.h20.p1964;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h20.p1964.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1964,
    description = "Find the Longest Valid Obstacle Course at Each Position",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, BINARY_SEARCH, BINARY_SEARCH_TREE}
)
public class FindLongestValidObstacleCourseAtEachPosition extends LeetCodeTask<int[]> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000_000;

    private int[] obstacles;

    public static final String INFORMATION = """

        Description:
            You want to build some obstacle courses. You are given a 0-indexed integer array obstacles of length n,
                where obstacles[i] describes the height of the ith obstacle.

            For every index i between 0 and n - 1 (inclusive),
                find the length of the longest obstacle course in obstacles such that:
                * You choose any number of obstacles between 0 and i inclusive.
                * You must include the ith obstacle in the course.
                * You must put the chosen obstacles in the same order as they appear in obstacles.
                * Every obstacle (except the first) is taller than or the same height as the obstacle immediately before it.

            Return an array ans of length n, where ans[i] is the length
                of the longest obstacle course for index i as described above.

        Example:
            Input: obstacles = [3,1,5,6,4,2]
            Output: [1,1,2,3,2,2]
            Explanation: The longest valid obstacle course at each position is:
                - i = 0: [3], [3] has length 1.
                - i = 1: [3,1], [1] has length 1.
                - i = 2: [3,1,5], [3,5] has length 2. [1,5] is also valid.
                - i = 3: [3,1,5,6], [3,5,6] has length 3. [1,5,6] is also valid.
                - i = 4: [3,1,5,6,4], [3,4] has length 2. [1,4] is also valid.
                - i = 5: [3,1,5,6,4,2], [1,2] has length 2.""";

    public FindLongestValidObstacleCourseAtEachPosition(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.obstacles = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Obstacles: {}", Arrays.toString(obstacles));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2160 ms
    @Override
    protected int[] original() {
        var original = new Original(obstacles.clone());
        return original.process();
    }

    // time = 1608 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(obstacles.clone());
        return practice.process();
    }

    // time = 2053 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(obstacles.clone());
        return solution.process();
    }
}
