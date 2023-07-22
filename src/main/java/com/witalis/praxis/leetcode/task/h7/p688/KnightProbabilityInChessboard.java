package com.witalis.praxis.leetcode.task.h7.p688;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p688.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 688,
    description = "Knight Probability in Chessboard",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DYNAMIC_PROGRAMMING}
)
public class KnightProbabilityInChessboard extends LeetCodeTask<Double> {
    public static final int LEN = 25;
    public static final int STEPS = 100;

    private int size;
    private int moves;
    private int row;
    private int column;

    public static final String INFORMATION = """

        Description:
            On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves.
                The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).

            A chess knight has eight possible moves it can make, as illustrated below.
                Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.

            Each time the knight is to move, it chooses one of eight possible moves uniformly at random
                (even if the piece would go off the chessboard) and moves there.

            The knight continues moving until it has made exactly k moves or has moved off the chessboard.

            Return the probability that the knight remains on the board after it has stopped moving.

        Example:
            Input: n = 3, k = 2, row = 0, column = 0
            Output: 0.06250
            Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
                From each of those positions, there are also two moves that will keep the knight on the board.
                The total probability the knight stays on the board is 0.0625.""";

    public KnightProbabilityInChessboard(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.size = random.nextInt(1, LEN + 1);
        this.moves = random.nextInt(0, STEPS + 1);
        this.row = random.nextInt(0, size);
        this.column = random.nextInt(0, size);

        log.info("Size: [{} x {}]", size, size);
        log.info("Moves K: {}", moves);
        log.info("Start row: {}", row);
        log.info("Start column: {}", column);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2291 ms
    @Override
    protected Double original() {
        var original = new Original(size, moves, row, column);
        return original.process();
    }

    // time = 2003 ms
    @Override
    protected Double practice() {
        var practice = new Practice(size, moves, row, column);
        return practice.process();
    }

    // time = 1009 ms
    @Override
    protected Double solution() {
        var solution = new Solution(size, moves, row, column);
        return solution.process();
    }
}
