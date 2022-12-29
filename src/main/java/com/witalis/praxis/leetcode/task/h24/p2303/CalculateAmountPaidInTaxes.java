package com.witalis.praxis.leetcode.task.h24.p2303;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2303.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2303,
    description = "Calculate Amount Paid in Taxes",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, SIMULATION}
)
public class CalculateAmountPaidInTaxes extends LeetCodeTask<Double> {
    public static final int LEN = 100;
    public static final int AMOUNT_VALUE = 1_000;
    public static final int PERCENT_VALUE = 100;
    private int[][] brackets;
    private int income;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed 2D integer array brackets where brackets[i] = [upper[i], percent[i]] means
                that the ith tax bracket has an upper bound of upper[i] and is taxed at a rate of percent[i].
                The brackets are sorted by upper bound (i.e. upper[i-1] < upper[i] for 0 < i < brackets.length).

            Tax is calculated as follows:
                * The first upper[0] dollars earned are taxed at a rate of percent[0].
                * The next upper[1] - upper[0] dollars earned are taxed at a rate of percent[1].
                * The next upper[2] - upper[1] dollars earned are taxed at a rate of percent[2].
                * And so on.

            You are given an integer income representing the amount of money you earned.
                Return the amount of money that you have to pay in taxes.
                Answers within 10^-5 of the actual answer will be accepted.

        Example:
            Input: brackets = [[1,0],[4,25],[5,50]], income = 2
            Output: 0.25000
            Explanation:
                Based on your income, you have 1 dollar in the 1st tax bracket and 1 dollar in the 2nd tax bracket.
                The tax rate for the two tax brackets is 0% and 25%, respectively.
                In total, you pay $1 * 0% + $1 * 25% = $0.25 in taxes.""";

    public CalculateAmountPaidInTaxes(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.income = random.nextInt(0, AMOUNT_VALUE + 1);

        int len = random.nextInt(1, LEN + 1);
        int[] uppers =  random.ints(len, 1, AMOUNT_VALUE + 1)
            .sorted()
            .distinct()
            .toArray();
        len = uppers.length;
        if (random.nextBoolean()) {
            uppers[len - 1] = income;
        } else {
            uppers[len - 1] += income;
        }

        this.brackets = new int[len][];
        for (int i = 0; i < len; i++) {
            brackets[i] = new int[] {
                uppers[i],
                random.nextInt(0, PERCENT_VALUE + 1)
            };
        }

        log.info("Brackets: {}", Arrays.deepToString(brackets));
        log.info("Income: {}", income);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 582 ms
    @Override
    protected Double original() {
        var original = new Original(brackets, income);
        return original.process();
    }

    // time = 530 ms
    @Override
    protected Double practice() {
        var practice = new Practice(brackets, income);
        return practice.process();
    }

    // time = 467 ms
    @Override
    protected Double solution() {
        var solution = new Solution(brackets, income);
        return solution.process();
    }
}
