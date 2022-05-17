package com.witalis.praxis.leetcode.task.h4.p374;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p374.content.GuessUtils;
import com.witalis.praxis.leetcode.task.h4.p374.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 374,
    description = "Guess Number Higher or Lower",
    difficulty = TaskDifficulty.EASY,
    tags = {BINARY_SEARCH, INTERACTIVE}
)
public class GuessNumberHigherOrLower extends LeetCodeTask<Integer> {
    private int number;
    private int pick;

    public static final String INFORMATION = """

        We are playing the Guess Game. The game is as follows:

        I pick a number from 1 to n. You have to guess which number I picked.

        Every time you guess wrong, I will tell you whether
            the number I picked is higher or lower than your guess.

        You call a pre-defined API int guess(int num), which returns three possible results:
            * -1: Your guess is higher than the number I picked (i.e. num > pick).
            * 1: Your guess is lower than the number I picked (i.e. num < pick).
            * 0: your guess is equal to the number I picked (i.e. num == pick).

        Return the number that I picked.

        Example:
            Input: n = 10, pick = 6
            Output: 6""";

    public GuessNumberHigherOrLower(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
        this.pick = ThreadLocalRandom.current().nextInt(1, number + 1);

        GuessUtils.setPick(pick);

        log.info("Number 'n' is {}", number);
        log.info("Pick 'p' is {}", pick);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 487 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 444 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 442 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
