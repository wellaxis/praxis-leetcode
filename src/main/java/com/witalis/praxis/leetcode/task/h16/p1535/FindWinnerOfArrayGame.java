package com.witalis.praxis.leetcode.task.h16.p1535;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1535.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1535,
    description = "Find the Winner of an Array Game",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, SIMULATION}
)
public class FindWinnerOfArrayGame extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000;
    public static final int THRESHOLD = 1_000_000_000;

    private int[] numbers;
    private int rounds;

    public static final String INFORMATION = """

        Description:
            Given an integer array arr of distinct integers and an integer k.

            A game will be played between the first two elements of the array (i.e. arr[0] and arr[1]).
                In each round of the game, we compare arr[0] with arr[1], the larger integer wins and remains at position 0,
                and the smaller integer moves to the end of the array. The game ends when an integer wins k consecutive rounds.

            Return the integer which will win the game.

            It is guaranteed that there will be a winner of the game.

        Example:
            Input: arr = [2,1,3,5,4,6,7], k = 2
            Output: 5
            Explanation: Let's see the rounds of the game:
            Round |       arr       | winner | win_count
              1   | [2,1,3,5,4,6,7] | 2      | 1
              2   | [2,3,5,4,6,7,1] | 3      | 1
              3   | [3,5,4,6,7,1,2] | 5      | 1
              4   | [5,4,6,7,1,2,3] | 5      | 2
            So we can see that 4 rounds will be played and 5 is the winner because it wins 2 consecutive games.""";

    public FindWinnerOfArrayGame(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(2, LEN + 1),
            1, VALUE + 1
        ).distinct().toArray();
        this.rounds = random.nextInt(1, THRESHOLD + 1);

        log.info("Array: {}", Arrays.toString(numbers));
        log.info("Rounds 'k': {}", rounds);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1840 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers, rounds);
        return original.process();
    }

    // time = 1571 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers, rounds);
        return practice.process();
    }

    // time = 1092 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers, rounds);
        return solution.process();
    }
}
