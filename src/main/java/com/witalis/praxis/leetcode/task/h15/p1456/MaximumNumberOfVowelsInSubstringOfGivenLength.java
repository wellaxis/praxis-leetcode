package com.witalis.praxis.leetcode.task.h15.p1456;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1456.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1456,
    description = "Maximum Number of Vowels in a Substring of Given Length",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, SLIDING_WINDOW}
)
public class MaximumNumberOfVowelsInSubstringOfGivenLength extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;

    private String string;
    private int limit;

    public static final String INFORMATION = """

        Description:
            Given a string s and an integer k,
                return the maximum number of vowel letters in any substring of s with length k.

            Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

        Example:
            Input: s = "leetcode", k = 3
            Output: 2
            Explanation: "lee", "eet" and "ode" contain 2 vowels.""";

    public MaximumNumberOfVowelsInSubstringOfGivenLength(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int len = random.nextInt(1, LEN + 1);
        final var builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.string = builder.toString();
        this.limit = random.nextInt(1, len + 1);

        log.info("String: '{}'", string);
        log.info("Limit 'k': {}", limit);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5770 ms
    @Override
    protected Integer original() {
        var original = new Original(string, limit);
        return original.process();
    }

    // time = 3844 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string, limit);
        return practice.process();
    }

    // time = 2262 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string, limit);
        return solution.process();
    }
}
