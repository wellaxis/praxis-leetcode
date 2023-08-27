package com.witalis.praxis.leetcode.task.h5.p403;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p403.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 403,
    description = "Frog Jump",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class FrogJump extends LeetCodeTask<Boolean> {
    public static final int LEN = 2_000;

    private int[] stones;

    public static final String INFORMATION = """

        Description:
            A frog is crossing a river. The river is divided into some number of units, and at each unit,
                there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

            Given a list of stones' positions (in units) in sorted ascending order,
                determine if the frog can cross the river by landing on the last stone.
                Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

            If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units.
                The frog can only jump in the forward direction.

        Example:
            Input: stones = [0,1,3,5,6,8,12,17]
            Output: true
            Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone,
                then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone,
                then 4 units to the 7th stone, and 5 units to the 8th stone.""";

    public FrogJump(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.stones = random.ints(
            random.nextInt(2, LEN + 1),
            0,
            Integer.MAX_VALUE
        ).distinct().sorted().toArray();

        log.info("Stones: {}", Arrays.toString(stones));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6192 ms
    @Override
    protected Boolean original() {
        var original = new Original(stones);
        return original.process();
    }

    // time = 3224 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(stones);
        return practice.process();
    }

    // time = 664 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(stones);
        return solution.process();
    }
}
