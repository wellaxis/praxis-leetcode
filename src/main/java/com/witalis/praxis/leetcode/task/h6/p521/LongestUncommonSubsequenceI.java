package com.witalis.praxis.leetcode.task.h6.p521;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p521.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 521,
    description = "Longest Uncommon Subsequence I",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING}
)
public class LongestUncommonSubsequenceI extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    private String a;
    private String b;

    public static final String INFORMATION = """

        Given two strings a and b, return the length of the longest uncommon subsequence between a and b.
            If the longest uncommon subsequence does not exist, return -1.

        An uncommon subsequence between two strings is a string that is a subsequence of one but not the other.

        A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.

        * For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc".
          Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).

        Example:
            Input: a = "aba", b = "cdc"
            Output: 3
            Explanation: One longest uncommon subsequence is "aba" because "aba" is a subsequence of "aba" but not "cdc".
                Note that "cdc" is also a longest uncommon subsequence.""";

    public LongestUncommonSubsequenceI(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.a = generate();
        this.b = generate();

        log.info("String a is {}", a);
        log.info("String b is {}", b);
    }

    private String generate() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);

        var builder = new StringBuilder();

        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 933 ms
    @Override
    protected Integer original() {
        var original = new Original(a, b);
        return original.process();
    }

    // time = 613 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(a, b);
        return practice.process();
    }

    // time = 611 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(a, b);
        return solution.process();
    }
}
