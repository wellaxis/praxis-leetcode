package com.witalis.praxis.leetcode.task.h4.p319;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p319.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 319,
    description = "Bulb Switcher",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, BRAINTEASER}
)
public class BulbSwitcher extends LeetCodeTask<Integer> {
    public static final int LEN = (int) Math.pow(10, 9);
    private int number;

    public static final String INFORMATION = """

        Description:
            There are n bulbs that are initially off.
            You first turn on all the bulbs, then you turn off every second bulb.
            On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on).
            For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.

            Return the number of bulbs that are on after n rounds.

        Example:
            Input: n = 3
            Output: 1
            Explanation:
                At first, the three bulbs are [off, off, off].
                After the first round, the three bulbs are [on, on, on].
                After the second round, the three bulbs are [on, off, on].
                After the third round, the three bulbs are [on, off, off].
                So you should return 1 because there is only one bulb is on.""";

    public BulbSwitcher(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(0, LEN + 1);

        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 486 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 441 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 560 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
