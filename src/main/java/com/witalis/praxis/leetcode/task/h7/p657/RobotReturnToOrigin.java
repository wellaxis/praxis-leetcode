package com.witalis.praxis.leetcode.task.h7.p657;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p657.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 657,
    description = "Robot Return to Origin",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, SIMULATION}
)
public class RobotReturnToOrigin extends LeetCodeTask<Boolean> {
    public static final int LEN = 20_000;
    private String moves;

    public static final String INFORMATION = """

        There is a robot starting at the position (0, 0), the origin, on a 2D plane.
            Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.

        You are given a string moves that represents the move sequence of the robot
            where moves[i] represents its ith move.
            Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).

        Return true if the robot returns to the origin after it finishes all of its moves, or false otherwise.

        Note: The way that the robot is "facing" is irrelevant.
            'R' will always make the robot move to the right once, 'L' will always make it move left, etc.
            Also, assume that the magnitude of the robot's movement is the same for each move.

        Example:
            Input: moves = "UD"
            Output: true
            Explanation: The robot moves up once, and then down once.
                All moves have the same magnitude, so it ended up at the origin where it started.
                Therefore, we return true.""";

    public RobotReturnToOrigin(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int mode = random.nextInt(0, 4);
            switch (mode) {
                case 0 -> builder.append("U");
                case 1 -> builder.append("D");
                case 2 -> builder.append("L");
                case 3 -> builder.append("R");
            }
        }
        this.moves = builder.toString();

        log.info("Moves are {}", moves);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 973 ms
    @Override
    protected Boolean original() {
        var original = new Original(moves);
        return original.process();
    }

    // time = 705 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(moves);
        return practice.process();
    }

    // time = 781 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(moves);
        return solution.process();
    }
}
