package com.witalis.praxis.leetcode.task.h18.p1759;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h18.p1759.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1759,
    description = "Count Number of Homogenous Substrings",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, STRING}
)
public class CountNumberOfHomogenousSubstrings extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;

    private String string;

    public static final String INFORMATION = """

        Description:
            Given a string s, return the number of homogenous substrings of s.
                Since the answer may be too large, return it modulo 10^9 + 7.

            A string is homogenous if all the characters of the string are the same.

            A substring is a contiguous sequence of characters within a string.

        Example:
            Input: s = "abbcccaa"
            Output: 13
            Explanation: The homogenous substrings are listed as below:
                "a"   appears 3 times.
                "aa"  appears 1 time.
                "b"   appears 2 times.
                "bb"  appears 1 time.
                "c"   appears 3 times.
                "cc"  appears 2 times.
                "ccc" appears 1 time.
                3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.""";

    public CountNumberOfHomogenousSubstrings(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = 2 * random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.string = builder.toString();

        log.info("String 's' is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6252 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 4785 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 3002 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
