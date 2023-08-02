package com.witalis.praxis.leetcode.task.h9.p860;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p860.option.Original;
import com.witalis.praxis.leetcode.task.h9.p860.option.Practice;
import com.witalis.praxis.leetcode.task.h9.p860.option.Solution;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 860,
    description = "Lemonade Change",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, GREEDY}
)
public class LemonadeChange extends LeetCodeTask<Boolean> {
    public static final int LEN = 100_000;

    private int[] bills;

    public static final String INFORMATION = """

        Description:
            At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you
                and order one at a time (in the order specified by bills).
                Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
                You must provide the correct change to each customer so that the net transaction is that the customer pays $5.

            Note that you do not have any change in hand at first.

            Given an integer array bills where bills[i] is the bill the ith customer pays,
                return true if you can provide every customer with the correct change, or false otherwise.

        Example:
            Input: bills = [5,5,10,10,20]
            Output: false
            Explanation:
                From the first two customers in order, we collect two $5 bills.
                For the next two customers in order, we collect a $10 bill and give back a $5 bill.
                For the last customer, we can not give the change of $15 back because we only have two $10 bills.
                Since not every customer received the correct change, the answer is false.""";

    public LemonadeChange(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.bills = random.ints(
            random.nextInt(1, LEN + 1),
            1, 4
        ).map(i -> switch (i) {case 1 -> 5; case 2 -> 10; case 3 -> 20;default -> 0;}).toArray();

        log.info("Bills: {}", Arrays.toString(bills));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 462 ms
    @Override
    protected Boolean original() {
        var original = new Original(bills);
        return original.process();
    }

    // time = 430 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(bills);
        return practice.process();
    }

    // time = 451 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(bills);
        return solution.process();
    }
}
