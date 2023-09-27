package com.witalis.praxis.leetcode.task.h9.p880;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p880.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 880,
    description = "Decoded String at Index",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, STACK}
)
public class DecodedStringIndex extends LeetCodeTask<String> {
    public static final int LEN = 100;
    public static final int VALUE = (int) 1e9;

    private String string;
    private int index;

    public static final String INFORMATION = """

        Description:
            You are given an encoded string s. To decode the string to a tape,
                the encoded string is read one character at a time and the following steps are taken:
                * If the character read is a letter, that letter is written onto the tape.
                * If the character read is a digit d, the entire current tape is repeatedly written d - 1 more times in total.

            Given an integer k, return the kth letter (1-indexed) in the decoded string.

        Example:
            Input: s = "leet2code3", k = 10
            Output: "o"
            Explanation: The decoded string is "leetleetcodeleetleetcodeleetleetcode".
                The 10th letter in the string is "o".""";

    public DecodedStringIndex(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(2, LEN + 1);
        var builder = new StringBuilder();
        builder.append((char) random.nextInt('a', 'z' + 1));
        for (int i = 0; i < len; i++) {
            if (random.nextBoolean()) {
                builder.append((char) random.nextInt('a', 'z' + 1));
            } else {
                builder.append(random.nextInt(2, 10));
            }
        }
        this.string = builder.toString();
        this.index = random.nextInt(1, VALUE + 1);

        log.info("String 's': {}", string);
        log.info("Index 'k': {}", index);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 496 ms
    @Override
    protected String original() {
        var original = new Original(string, index);
        return original.process();
    }

    // time = 468 ms
    @Override
    protected String practice() {
        var practice = new Practice(string, index);
        return practice.process();
    }

    // time = 479 ms
    @Override
    protected String solution() {
        var solution = new Solution(string, index);
        return solution.process();
    }
}
