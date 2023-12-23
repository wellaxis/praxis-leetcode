package com.witalis.praxis.leetcode.task.h15.p1496;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1496.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1496,
    description = "Path Crossing",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, STRING}
)
public class PathCrossing extends LeetCodeTask<Boolean> {
    public static final int LEN = 10_000;

    private String path;

    public static final String INFORMATION = """

        Description:
            Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing
                moving one unit north, south, east, or west, respectively.
                You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.

            Return true if the path crosses itself at any point, that is,
                if at any time you are on a location you have previously visited. Return false otherwise.

        Example:
            Input: path = "NESWW"
            Output: true
            Explanation: Notice that the path visits the origin twice.""";

    public PathCrossing(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int n = random.nextInt(1, LEN + 1);
        var builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int mode = random.nextInt(0, 4);
            switch (mode) {
                case 0 -> builder.append('N');
                case 1 -> builder.append('E');
                case 2 -> builder.append('S');
                case 3 -> builder.append('W');
                default -> throw new IllegalArgumentException("unexpected mode: " + mode);
            }
        }
        this.path = builder.toString();

        log.info("Path: {}", path);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3328 ms
    @Override
    protected Boolean original() {
        var original = new Original(path);
        return original.process();
    }

    // time = 748 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(path);
        return practice.process();
    }

    // time = 496 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(path);
        return solution.process();
    }
}
