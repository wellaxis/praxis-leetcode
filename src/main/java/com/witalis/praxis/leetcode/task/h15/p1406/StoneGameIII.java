package com.witalis.praxis.leetcode.task.h15.p1406;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1406.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1406,
    description = "Stone Game III",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, MATH, DYNAMIC_PROGRAMMING, GAME_THEORY}
)
public class StoneGameIII extends LeetCodeTask<String> {
    public static final int LEN = 50_000;
    public static final int VALUE = 1_000;

    private int[] stones;

    public static final String INFORMATION = """

        Description:
            Alice and Bob continue their games with piles of stones. There are several stones arranged in a row,
                and each stone has an associated value which is an integer given in the array stoneValue.

            Alice and Bob take turns, with Alice starting first. On each player's turn,
                that player can take 1, 2, or 3 stones from the first remaining stones in the row.

            The score of each player is the sum of the values of the stones taken. The score of each player is 0 initially.

            The objective of the game is to end with the highest score, and the winner is the player
                with the highest score and there could be a tie. The game continues until all the stones have been taken.

            Assume Alice and Bob play optimally.

            Return "Alice" if Alice will win, "Bob" if Bob will win, or "Tie" if they will end the game with the same score.

        Example:
            Input: values = [1,2,3,-9]
            Output: "Alice"
            Explanation: Alice must choose all the three piles at the first move to win and leave Bob with negative score.
                If Alice chooses one pile her score will be 1 and the next move Bob's score becomes 5.
                    In the next move, Alice will take the pile with value = -9 and lose.
                If Alice chooses two piles her score will be 3 and the next move Bob's score becomes 3.
                    In the next move, Alice will take the pile with value = -9 and also lose.
                Remember that both play optimally so here Alice will choose the scenario that makes her win.""";

    public StoneGameIII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.stones = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).toArray();

        log.info("Stone values: {}", Arrays.toString(stones));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3258 ms
    @Override
    protected String original() {
        var original = new Original(stones);
        return original.process();
    }

    // time = 3147 ms
    @Override
    protected String practice() {
        var practice = new Practice(stones);
        return practice.process();
    }

    // time = 3005 ms
    @Override
    protected String solution() {
        var solution = new Solution(stones);
        return solution.process();
    }
}
