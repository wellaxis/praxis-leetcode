package com.witalis.praxis.leetcode.task.h16.p1578;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1578.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1578,
    description = "Minimum Time to Make Rope Colorful",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, STRING, DYNAMIC_PROGRAMMING, GREEDY}
)
public class MinimumTimeToMakeRopeColorful extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000;

    private String colors;
    private int[] neededTime;

    public static final String INFORMATION = """

        Description:
            Alice has n balloons arranged on a rope.
                You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.

            Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color,
                so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful.
                You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds)
                that Bob needs to remove the ith balloon from the rope.

            Return the minimum time Bob needs to make the rope colorful.

        Example:
            Input: colors = "abaac", neededTime = [1,2,3,4,5]
            Output: 3
            Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
                Bob can remove the blue balloon at index 2. This takes 3 seconds.
                There are no longer two consecutive balloons of the same color. Total time = 3.""";

    public MinimumTimeToMakeRopeColorful(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int n = random.nextInt(1, LEN + 1);
        this.neededTime = new int[n];
        var builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
            neededTime[i] = random.nextInt(1, VALUE + 1);
        }
        this.colors = builder.toString();

        log.info("Colors: '{}'", colors);
        log.info("Needed Time: {}", Arrays.toString(neededTime));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6994 ms
    @Override
    protected Integer original() {
        var original = new Original(colors, neededTime);
        return original.process();
    }

    // time = 3300 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(colors, neededTime);
        return practice.process();
    }

    // time = 2168 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(colors, neededTime);
        return solution.process();
    }
}
