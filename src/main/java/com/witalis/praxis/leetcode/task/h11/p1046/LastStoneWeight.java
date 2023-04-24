package com.witalis.praxis.leetcode.task.h11.p1046;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1046.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1046,
    description = "Last Stone Weight",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HEAP}
)
public class LastStoneWeight extends LeetCodeTask<Integer> {
    public static final int LEN = 30;
    public static final int VALUE = 1_000;

    private int[] stones;

    public static final String INFORMATION = """

        Description:
            You are given an array of integers stones where stones[i] is the weight of the ith stone.

            We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
                Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
                * If x == y, both stones are destroyed, and
                * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.

            At the end of the game, there is at most one stone left.

            Return the weight of the last remaining stone. If there are no stones left, return 0.

        Example:
            Input: stones = [2,7,4,1,8,1]
            Output: 1
            Explanation:
                We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
                we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
                we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
                we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.""";

    public LastStoneWeight(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.stones = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Stones: {}", Arrays.toString(stones));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 510 ms
    @Override
    protected Integer original() {
        var original = new Original(stones.clone());
        return original.process();
    }

    // time = 486 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(stones.clone());
        return practice.process();
    }

    // time = 464 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(stones.clone());
        return solution.process();
    }
}
