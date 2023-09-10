package com.witalis.praxis.leetcode.task.h14.p1359;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1359.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1359,
    description = "Count All Valid Pickup and Delivery Options",
    tags = {MATH, DYNAMIC_PROGRAMMING, COMBINATORICS}
)
public class CountAllValidPickupAndDeliveryOptions extends LeetCodeTask<Integer> {
    public static final int LEN = 500;

    private int orders;

    public static final String INFORMATION = """

        Description:
            Given n orders, each order consist in pickup and delivery services.

            Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).

            Since the answer may be too large, return it modulo 10^9 + 7.

        Example:
            Input: n = 2
            Output: 6
            Explanation: All possible orders:
                (P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
                This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.""";

    public CountAllValidPickupAndDeliveryOptions(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.orders = random.nextInt(1, LEN + 1);

        log.info("Orders: {}", orders);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 958464 ms, time limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(orders);
        return original.process();
    }

    // time = 755 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(orders);
        return practice.process();
    }

    // time = 465 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(orders);
        return solution.process();
    }
}
