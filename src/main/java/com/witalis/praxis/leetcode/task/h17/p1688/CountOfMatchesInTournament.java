package com.witalis.praxis.leetcode.task.h17.p1688;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h17.p1688.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1688,
    description = "Count of Matches in Tournament",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, SIMULATION}
)
public class CountOfMatchesInTournament extends LeetCodeTask<Integer> {
    public static final int VALUE = 200;

    private int number;

    public static final String INFORMATION = """

        Description:
            You are given an integer n, the number of teams in a tournament that has strange rules:
                * If the current number of teams is even, each team gets paired with another team.
                  A total of n / 2 matches are played, and n / 2 teams advance to the next round.
                * If the current number of teams is odd, one team randomly advances in the tournament, and the rest gets paired.
                  A total of (n - 1) / 2 matches are played, and (n - 1) / 2 + 1 teams advance to the next round.

            Return the number of matches played in the tournament until a winner is decided.

        Example:
            Input: n = 14
            Output: 13
            Explanation: Details of the tournament:
                - 1st Round: Teams = 14, Matches = 7, and 7 teams advance.
                - 2nd Round: Teams = 7, Matches = 3, and 4 teams advance.
                - 3rd Round: Teams = 4, Matches = 2, and 2 teams advance.
                - 4th Round: Teams = 2, Matches = 1, and 1 team is declared the winner.
                Total number of matches = 7 + 3 + 2 + 1 = 13.""";

    public CountOfMatchesInTournament(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, VALUE + 1);

        log.info("Number: {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 514 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 511 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 450 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
