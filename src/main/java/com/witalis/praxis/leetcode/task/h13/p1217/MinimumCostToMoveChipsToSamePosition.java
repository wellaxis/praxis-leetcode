package com.witalis.praxis.leetcode.task.h13.p1217;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h13.p1217.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1217,
    description = "Minimum Cost to Move Chips to The Same Position",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH, GREEDY}
)
public class MinimumCostToMoveChipsToSamePosition extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int VALUE = 1_000_000_000;

    private int[] positions;

    public static final String INFORMATION = """

        Description:
            We have n chips, where the position of the ith chip is position[i].

            We need to move all the chips to the same position.
            In one step, we can change the position of the ith chip from position[i] to:
                * position[i] + 2 or position[i] - 2 with cost = 0.
                * position[i] + 1 or position[i] - 1 with cost = 1.

            Return the minimum cost needed to move all the chips to the same position.

        Example:
            Input: position = [1,2,3]
            Output: 1
            Explanation: First step: Move the chip at position 3 to position 1 with cost = 0.
                Second step: Move the chip at position 2 to position 1 with cost = 1.
                Total cost is 1.""";

    public MinimumCostToMoveChipsToSamePosition(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.positions = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Positions: {}", Arrays.toString(positions));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // dfs, time = 776 ms
    @Override
    protected Integer original() {
        var original = new Original(positions.clone());
        return original.process();
    }

    // dfs, time = 774 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(positions.clone());
        return practice.process();
    }

    // bfs, time = 530 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(positions.clone());
        return solution.process();
    }
}
