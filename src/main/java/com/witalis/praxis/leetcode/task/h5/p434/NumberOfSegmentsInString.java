package com.witalis.praxis.leetcode.task.h5.p434;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p434.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 434,
    description = "Number of Segments in a String",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING}
)
public class NumberOfSegmentsInString extends LeetCodeTask<Integer> {
    public static final int LEN = 300;
    private String string;

    public static final String INFORMATION = """

        Given a string s, return the number of segments in the string.

        A segment is defined to be a contiguous sequence of non-space characters.

        Example:
            Input: s = "Hello, my name is John"
            Output: 5
            Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]""";

    public NumberOfSegmentsInString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final int SPACE_THRESHOLD = 15;

        var random = ThreadLocalRandom.current();
        int len = random.nextInt(0, LEN + 1);

        var builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int mode = random.nextInt(0, 100);
            if (mode < SPACE_THRESHOLD) {
                builder.append(' ');
            } else {
                builder.append((char) random.nextInt(33, 127));
            }
        }
        this.string = builder.toString();

        log.info("String is '{}'", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 571 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 423 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 414 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
