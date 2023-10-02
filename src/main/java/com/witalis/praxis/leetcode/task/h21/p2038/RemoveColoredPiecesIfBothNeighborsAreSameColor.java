package com.witalis.praxis.leetcode.task.h21.p2038;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h21.p2038.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2038,
    description = "Remove Colored Pieces if Both Neighbors are the Same Color",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, STRING, GREEDY, GAME_THEORY}
)
public class RemoveColoredPiecesIfBothNeighborsAreSameColor extends LeetCodeTask<Boolean> {
    public static final int LEN = 100_000;

    private String colors;

    public static final String INFORMATION = """

        Description:
            There are n pieces arranged in a line, and each piece is colored either by 'A' or by 'B'.
                You are given a string colors of length n where colors[i] is the color of the ith piece.

            Alice and Bob are playing a game where they take alternating turns removing pieces from the line.
                In this game, Alice moves first.

            * Alice is only allowed to remove a piece colored 'A' if both its neighbors are also colored 'A'.
              She is not allowed to remove pieces that are colored 'B'.
            * Bob is only allowed to remove a piece colored 'B' if both its neighbors are also colored 'B'.
              He is not allowed to remove pieces that are colored 'A'.
            * Alice and Bob cannot remove pieces from the edge of the line.
            * If a player cannot make a move on their turn, that player loses and the other player wins.

            Assuming Alice and Bob play optimally, return true if Alice wins, or return false if Bob wins.

        Example:
            Input: colors = "AAABABB"
            Output: true
            Explanation:
                AAABABB -> AABABB
                Alice moves first. She removes the second 'A' from the left since that is the only 'A' whose neighbors are both 'A'.
                Now it's Bob's turn. Bob cannot make a move on his turn since there are no 'B's whose neighbors are both 'B'.
                Thus, Alice wins, so return true.""";

    public RemoveColoredPiecesIfBothNeighborsAreSameColor(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append(random.nextBoolean() ? 'A' : 'B');
        }
        this.colors = builder.toString();

        log.info("Colors: '{}'", colors);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1564 ms
    @Override
    protected Boolean original() {
        var original = new Original(colors);
        return original.process();
    }

    // time = 1144 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(colors);
        return practice.process();
    }

    // time = 834 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(colors);
        return solution.process();
    }
}
