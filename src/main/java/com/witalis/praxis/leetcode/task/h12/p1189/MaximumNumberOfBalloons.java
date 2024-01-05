package com.witalis.praxis.leetcode.task.h12.p1189;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1189.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1189,
    description = "Maximum Number of Balloons",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, STRING, COUNTING}
)
public class MaximumNumberOfBalloons extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;

    private String text;

    public static final String INFORMATION = """

        Description:
            Given a string text, you want to use the characters of text
                to form as many instances of the word "balloon" as possible.

            You can use each character in text at most once.
                Return the maximum number of instances that can be formed.

        Example:
            Input: text = "loonbalxballpoon"
            Output: 2""";

    public MaximumNumberOfBalloons(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        var builder = new StringBuilder();
        for (int i = 0; i < len; i++)
            builder.append((char) random.nextInt('a', 'z' + 1));
        this.text = builder.toString();

        log.info("Text: '{}'", text);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1243 ms
    @Override
    protected Integer original() {
        var original = new Original(text);
        return original.process();
    }

    // time = 1011 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(text);
        return practice.process();
    }

    // time = 783 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(text);
        return solution.process();
    }
}
