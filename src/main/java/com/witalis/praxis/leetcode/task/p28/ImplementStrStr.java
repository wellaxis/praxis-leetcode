package com.witalis.praxis.leetcode.task.p28;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p28.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 28, description = "Implement strStr()")
public class ImplementStrStr extends LeetCodeTask<Integer> {
    public static final int LEN = 5 * (int) Math.pow(10, 4);
    private String haystack;
    private String needle;

    public static final String INFORMATION = """

        Implement strStr().
        Return the index of the first occurrence of needle in haystack,
            or -1 if needle is not part of haystack.

        Clarification:
            What should we return when needle is an empty string?
            This is a great question to ask during an interview.

        For the purpose of this problem,
            we will return 0 when needle is an empty string.
            This is consistent to C's strstr() and Java's indexOf().

        Example:
            Input: haystack = "hello", needle = "ll"
            Output: 2""";

    public ImplementStrStr(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.haystack = generation(0, LEN + 1);
        this.needle = generation(0, LEN + 1);

        log.info("Haystack is {}, needle is {}", haystack, needle);
    }

    private String generation(int origin, int bound) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        var random = ThreadLocalRandom.current();
        var length = random.nextInt(origin, bound);
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int)
                (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 852 ms, time limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(haystack, needle);
        return original.process();
    }

    // time = 873 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(haystack, needle);
        return practice.process();
    }

    // time = 849 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(haystack, needle);
        return solution.process();
    }
}
