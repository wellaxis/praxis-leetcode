package com.witalis.praxis.leetcode.task.h16.p1503;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1503.option.*;
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
    id = 1503,
    description = "Last Moment Before All Ants Fall Out of a Plank",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BRAINTEASER, SIMULATION}
)
public class LastMomentBeforeAllAntsFallOutOfPlank extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000_000;

    private int number;
    private int[] left;
    private int[] right;

    public static final String INFORMATION = """

        Description:
            We have a wooden plank of the length n units. Some ants are walking on the plank,
                each ant moves with a speed of 1 unit per second. Some of the ants move to the left, the other move to the right.

            When two ants moving in two different directions meet at some point, they change their directions and continue moving again.
                Assume changing directions does not take any additional time.

            When an ant reaches one end of the plank at a time t, it falls out of the plank immediately.

            Given an integer n and two integer arrays left and right, the positions of the ants moving to the left and the right,
                return the moment when the last ant(s) fall out of the plank.

        Example:
            Input: n = 4, left = [4,3], right = [0,1]
            Output: 4
            Explanation: In the image above:
                -The ant at index 0 is named A and going to the right.
                -The ant at index 1 is named B and going to the right.
                -The ant at index 3 is named C and going to the left.
                -The ant at index 4 is named D and going to the left.
                The last moment when an ant was on the plank is t = 4 seconds. After that, it falls immediately out of the plank.
                (i.e., We can say that at t = 4.0000000001, there are no ants on the plank).""";

    public LastMomentBeforeAllAntsFallOutOfPlank(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, LEN + 1);
        Set<Integer> cache = new HashSet<>();

        int[] directions = random.ints(
            random.nextInt(0, number + 1),
            0, number + 1
        ).distinct().toArray();

        int half = directions.length / 2;
        this.left = new int[half];
        System.arraycopy(directions, 0, left, 0, left.length);
        this.right = new int[directions.length - half];
        System.arraycopy(directions, half, right, 0, right.length);

        log.info("Number 'n': {}", number);
        log.info("Left: {}", Arrays.toString(left));
        log.info("Right: {}", Arrays.toString(right));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 492 ms
    @Override
    protected Integer original() {
        var original = new Original(number, left, right);
        return original.process();
    }

    // time = 484 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number, left, right);
        return practice.process();
    }

    // time = 474 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number, left, right);
        return solution.process();
    }
}
