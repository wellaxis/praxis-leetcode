package com.witalis.praxis.leetcode.task.h25.p2483;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h25.p2483.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2483,
    description = "Minimum Penalty for a Shop",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, PREFIX_SUM}
)
public class MinimumPenaltyForShop extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;

    private String customers;

    public static final String INFORMATION = """

        Description:
            You are given the customer visit log of a shop represented by a 0-indexed string
                customers consisting only of characters 'N' and 'Y':
                * if the ith character is 'Y', it means that customers come at the ith hour
                * whereas 'N' indicates that no customers come at the ith hour.

            If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:
                * For every hour when the shop is open and no customers come, the penalty increases by 1.
                * For every hour when the shop is closed and customers come, the penalty increases by 1.

            Return the earliest hour at which the shop must be closed to incur a minimum penalty.

            Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.

        Example:
            Input: customers = "YYNY"
            Output: 2
            Explanation:
                - Closing the shop at the 0th hour incurs in 1+1+0+1 = 3 penalty.
                - Closing the shop at the 1st hour incurs in 0+1+0+1 = 2 penalty.
                - Closing the shop at the 2nd hour incurs in 0+0+0+1 = 1 penalty.
                - Closing the shop at the 3rd hour incurs in 0+0+1+1 = 2 penalty.
                - Closing the shop at the 4th hour incurs in 0+0+1+0 = 1 penalty.
                Closing the shop at 2nd or 4th hour gives a minimum penalty.
                Since 2 is earlier, the optimal closing time is 2.""";

    public MinimumPenaltyForShop(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final var len = random.nextInt(1, LEN + 1);
        final var builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(random.nextBoolean() ? 'Y' : 'N');
        }
        this.customers = builder.toString();

        log.info("Customers: '{}'", customers);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3630 ms
    @Override
    protected Integer original() {
        var original = new Original(customers);
        return original.process();
    }

    // time = 3460 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(customers);
        return practice.process();
    }

    // time = 4552 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(customers);
        return solution.process();
    }
}
