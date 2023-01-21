package com.witalis.praxis.leetcode.task.h22.p2101;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h22.p2101.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2101,
    description = "Detonate the Maximum Bombs",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATH, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, GRAPH, GEOMETRY}
)
public class DetonateMaximumBombs extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int VALUE = 100_000;
    private int[][] bombs;

    public static final String INFORMATION = """

        Description:
            You are given a list of bombs. The range of a bomb is defined as the area where its effect can be felt.
                This area is in the shape of a circle with the center as the location of the bomb.

            The bombs are represented by a 0-indexed 2D integer array bombs where bombs[i] = [xi, yi, ri].
                xi and yi denote the X-coordinate and Y-coordinate of the location of the ith bomb,
                whereas ri denotes the radius of its range.

            You may choose to detonate a single bomb. When a bomb is detonated, it will detonate all bombs that lie in its range.
                These bombs will further detonate the bombs that lie in their ranges.

            Given the list of bombs, return the maximum number of bombs that can be detonated
                if you are allowed to detonate only one bomb.

        Example:
            Input: bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
            Output: 5
            Explanation:
                The best bomb to detonate is bomb 0 because:
                - Bomb 0 detonates bombs 1 and 2. The red circle denotes the range of bomb 0.
                - Bomb 2 detonates bomb 3. The blue circle denotes the range of bomb 2.
                - Bomb 3 detonates bomb 4. The green circle denotes the range of bomb 3.
                Thus all 5 bombs are detonated.""";

    public DetonateMaximumBombs(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        this.bombs = new int[len][];
        for (int i = 0; i < len; i++) {
            bombs[i] = new int[] {
                random.nextInt(1, VALUE + 1),
                random.nextInt(1, VALUE + 1),
                random.nextInt(1, VALUE + 1)
            };
        }

        log.info("Bombs: {}", Arrays.deepToString(bombs));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5525 ms
    @Override
    protected Integer original() {
        var original = new Original(bombs);
        return original.process();
    }

    // time = 2670 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(bombs);
        return practice.process();
    }

    // time = 1426 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(bombs);
        return solution.process();
    }
}
