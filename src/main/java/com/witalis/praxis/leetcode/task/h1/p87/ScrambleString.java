package com.witalis.praxis.leetcode.task.h1.p87;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p87.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 87,
    description = "Scramble String",
    difficulty = TaskDifficulty.HARD,
    tags = {STRING, DYNAMIC_PROGRAMMING}
)
public class ScrambleString extends LeetCodeTask<Boolean> {
    public static final int LEN = 30;
    private String string1;
    private String string2;

    public static final String INFORMATION = """

        We can scramble a string s to get a string t using the following algorithm:
            1. If the length of the string is 1, stop.
            2. If the length of the string is > 1, do the following:
                * Split the string into two non-empty substrings at a random index, i.e.,
                  if the string is s, divide it to x and y where s = x + y.
                * Randomly decide to swap the two substrings or to keep them in the same order. i.e.,
                  after this step, s may become s = x + y or s = y + x.
                * Apply step 1 recursively on each of the two substrings x and y.

        Given two strings s1 and s2 of the same length,
            return true if s2 is a scrambled string of s1, otherwise, return false.

        Example:
            Input: s1 = "great", s2 = "rgeat"
            Output: true
            Explanation: One possible scenario applied on s1 is:
                "great" --> "gr/eat" // divide at random index.
                "gr/eat" --> "gr/eat" // random decision is not to swap the two substrings and keep them in order.
                "gr/eat" --> "g/r / e/at" // apply the same algorithm recursively on both substrings. divide at random index each of them.
                "g/r / e/at" --> "r/g / e/at" // random decision was to swap the first substring and to keep the second substring in the same order.
                "r/g / e/at" --> "r/g / e/ a/t" // again apply the algorithm recursively, divide "at" to "a/t".
                "r/g / e/ a/t" --> "r/g / e/ a/t" // random decision is to keep both substrings in the same order.
                The algorithm stops now, and the result string is "rgeat" which is s2.
                As one possible scenario led s1 to be scrambled to s2, we return true.""";

    public ScrambleString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.string1 = generate(len);
        this.string2 = generate(len);

        log.info("String N1 is '{}'", string1);
        log.info("String N2 is '{}'", string2);
    }

    private static String generate(int length) {
        final var random = ThreadLocalRandom.current();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }

        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 730 ms, time limit exceeded
    @Override
    protected Boolean original() {
        var original = new Original(string1, string2);
        return original.process();
    }

    // time = 569 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(string1, string2);
        return practice.process();
    }

    // time = 439 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(string1, string2);
        return solution.process();
    }
}
