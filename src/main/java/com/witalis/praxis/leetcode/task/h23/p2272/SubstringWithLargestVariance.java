package com.witalis.praxis.leetcode.task.h23.p2272;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h23.p2272.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2272,
    description = "Substring With Largest Variance",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class SubstringWithLargestVariance extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;

    private String string;

    public static final String INFORMATION = """

        Description:
            The variance of a string is defined as the largest difference between the number of occurrences
                of any 2 characters present in the string. Note the two characters may or may not be the same.

            Given a string s consisting of lowercase English letters only,
                return the largest variance possible among all substrings of s.

            A substring is a contiguous sequence of characters within a string.

        Example:
            Input: s = "aababbb"
            Output: 3
            Explanation:
                All possible variances along with their respective substrings are listed below:
                - Variance 0 for substrings "a", "aa", "ab", "abab", "aababb", "ba", "b", "bb", and "bbb".
                - Variance 1 for substrings "aab", "aba", "abb", "aabab", "ababb", "aababbb", and "bab".
                - Variance 2 for substrings "aaba", "ababbb", "abbb", and "babb".
                - Variance 3 for substring "babbb".
                Since the largest possible variance is 3, we return it.""";

    public SubstringWithLargestVariance(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.string = builder.toString();

        log.info("String: '{}'", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 25301 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 12907 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 10131 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
