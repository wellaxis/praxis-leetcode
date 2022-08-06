package com.witalis.praxis.leetcode.task.h6.p520;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p520.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 520,
    description = "Detect Capital",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING}
)
public class DetectCapital extends LeetCodeTask<Boolean> {
    public static final int LEN = 100;
    private String word;

    public static final String INFORMATION = """

        We define the usage of capitals in a word to be right when one of the following cases holds:
            * All letters in this word are capitals, like "USA".
            * All letters in this word are not capitals, like "leetcode".
            * Only the first letter in this word is capital, like "Google".

        Given a string word, return true if the usage of capitals in it is right.

        Example:
            Input: word = "USA"
            Output: true""";

    public DetectCapital(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();

        for (int s = 0; s < len; s++) {
            if (random.nextBoolean()) {
                builder.append((char) random.nextInt('a', 'z' + 1));
            } else {
                builder.append((char) random.nextInt('A', 'Z' + 1));
            }
        }

        this.word = builder.toString();

        log.info("Word is {}", word);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 738 ms
    @Override
    protected Boolean original() {
        var original = new Original(word);
        return original.process();
    }

    // time = 509 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(word);
        return practice.process();
    }

    // time = 520 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(word);
        return solution.process();
    }
}
