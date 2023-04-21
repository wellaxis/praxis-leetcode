package com.witalis.praxis.leetcode.task.h9.p879;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p879.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 879,
    description = "Profitable Schemes",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class ProfitableSchemes extends LeetCodeTask<Integer> {
    public static final int LEN = 1000;
    public static final int VALUE = 1000;

    private int members;
    private int minProfit;
    private int[] groups;
    private int[] profits;

    public static final String INFORMATION = """

        Description:
            There is a group of n members, and a list of various crimes they could commit.
                The ith crime generates a profit[i] and requires group[i] members to participate in it.
                If a member participates in one crime, that member can't participate in another crime.

            Let's call a profitable scheme any subset of these crimes that generates at least minProfit profit,
                and the total number of members participating in that subset of crimes is at most n.

            Return the number of schemes that can be chosen. Since the answer may be very large, return it modulo 109 + 7.

        Example:
            Input: n = 5, minProfit = 3, group = [2,2], profit = [2,3]
            Output: 2
            Explanation: To make a profit of at least 3, the group could either commit crimes 0 and 1, or just crime 1.
                In total, there are 2 schemes.""";

    public ProfitableSchemes(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.members = random.nextInt(1, LEN + 1);
        this.minProfit = random.nextInt(0, VALUE + 1);
        final int len = random.nextInt(1, LEN + 1);
        this.groups = random.ints(len, 1, VALUE + 1).toArray();
        this.profits = random.ints(len, 0, VALUE + 1).toArray();

        log.info("Members: {}", members);
        log.info("Min profit: {}", minProfit);
        log.info("Groups: {}", Arrays.toString(groups));
        log.info("Profits: {}", Arrays.toString(profits));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6339526 ms
    @Override
    protected Integer original() {
        var original = new Original(members, minProfit, groups, profits);
        return original.process();
    }

    // time = 6258539 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(members, minProfit, groups, profits);
        return practice.process();
    }

    // time = 242366 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(members, minProfit, groups, profits);
        return solution.process();
    }
}
