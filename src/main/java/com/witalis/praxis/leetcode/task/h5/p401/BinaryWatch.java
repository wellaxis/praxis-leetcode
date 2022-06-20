package com.witalis.praxis.leetcode.task.h5.p401;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p401.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 401,
    description = "Binary Watch",
    difficulty = TaskDifficulty.EASY,
    tags = {BACKTRACKING, BIT_MANIPULATION}
)
public class BinaryWatch extends LeetCodeTask<List<String>> {
    public static final int LEN = 10;
    private int turnedOn;

    public static final String INFORMATION = """

        A binary watch has 4 LEDs on the top to represent the hours (0-11),
            and 6 LEDs on the bottom to represent the minutes (0-59).
            Each LED represents a zero or one, with the least significant bit on the right.

        Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM),
            return all possible times the watch could represent. You may return the answer in any order.

        The hour must not contain a leading zero.
            * For example, "01:00" is not valid. It should be "1:00".
        The minute must be consist of two digits and may contain a leading zero.
            * For example, "10:2" is not valid. It should be "10:02".

        Example:
            Input: turnedOn = 1
            Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]""";

    public BinaryWatch(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.turnedOn = random.nextInt(0, LEN + 1);
        log.info("Turned On is {}", turnedOn);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2317 ms
    @Override
    protected List<String> original() {
        var original = new Original(turnedOn);
        return original.process();
    }

    // time = 488 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(turnedOn);
        return practice.process();
    }

    // time = 442 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(turnedOn);
        return solution.process();
    }
}
