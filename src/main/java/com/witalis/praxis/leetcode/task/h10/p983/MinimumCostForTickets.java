package com.witalis.praxis.leetcode.task.h10.p983;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p983.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 983,
    description = "Minimum Cost For Tickets",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class MinimumCostForTickets extends LeetCodeTask<Integer> {
    public static final int DAYS = 365;
    public static final int COSTS = 1_000;

    private int[] days;
    private int[] costs;

    public static final String INFORMATION = """

        Description:
            You have planned some train traveling one year in advance.
                The days of the year in which you will travel are given as an integer array days.
                Each day is an integer from 1 to 365.

            Train tickets are sold in three different ways:
                * a 1-day pass is sold for costs[0] dollars,
                * a 7-day pass is sold for costs[1] dollars, and
                * a 30-day pass is sold for costs[2] dollars.

            The passes allow that many days of consecutive travel.

            For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.

            Return the minimum number of dollars you need to travel every day in the given list of days.

        Example:
            Input: days = [1,4,6,7,8,20], costs = [2,7,15]
            Output: 11
            Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
                On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
                On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
                On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
                In total, you spent $11 and covered all the days of your travel.""";

    public MinimumCostForTickets(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.days = random.ints(
            random.nextInt(1, DAYS + 1),
            1, DAYS + 1
        ).distinct().sorted().toArray();
        this.costs = new int[] {
            random.nextInt(1, COSTS + 1),
            random.nextInt(1, COSTS + 1),
            random.nextInt(1, COSTS + 1)
        };
        Arrays.sort(costs);

        log.info("Days: {}", Arrays.toString(days));
        log.info("Costs: {}", Arrays.toString(costs));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 834 ms
    @Override
    protected Integer original() {
        var original = new Original(days, costs);
        return original.process();
    }

    // time = 779 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(days, costs);
        return practice.process();
    }

    // time = 637 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(days, costs);
        return solution.process();
    }
}
