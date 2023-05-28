package com.witalis.praxis.leetcode.task.h16.p1547;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1547.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1547,
    description = "Minimum Cost to Cut a Stick",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, SORTING}
)
public class MinimumCostToCutStick extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int CUT = 100;

    private int units;
    private int[] cuts;

    public static final String INFORMATION = """

        Description:
            Given a wooden stick of length n units. The stick is labelled from 0 to n.
            For example, a stick of length 6 is labelled as follows: [0 .. 6]
            Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.

            You should perform the cuts in order, you can change the order of the cuts as you wish.

            The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts.
                When you cut a stick, it will be split into two smaller sticks
                (i.e. the sum of their lengths is the length of the stick before the cut).
                Please refer to the first example for a better explanation.

            Return the minimum total cost of the cuts.

        Example:
            Input: n = 9, cuts = [5,6,1,4,2]
            Output: 22
            Explanation: If you try the given cuts ordering the cost will be 25.
                There are much ordering with total cost <= 25, for example,
                the order [4, 6, 5, 2, 1] has total cost = 22 which is the minimum possible.""";

    public MinimumCostToCutStick(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.units = random.nextInt(2, LEN + 1);
        this.cuts = random.ints(
            random.nextInt(CUT, units),
            1, units
        ).distinct().toArray();

        log.info("Length n: {}", units);
        log.info("Cuts: {}", Arrays.toString(cuts));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 75598 ms
    @Override
    protected Integer original() {
        var original = new Original(units, cuts);
        return original.process();
    }

    // time = 73592 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(units, cuts);
        return practice.process();
    }

    // time = 26419 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(units, cuts);
        return solution.process();
    }
}
