package com.witalis.praxis.leetcode.task.h16.p1531;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1531.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1531,
    description = "String Compression II",
    difficulty = TaskDifficulty.HARD,
    tags = {STRING, DYNAMIC_PROGRAMMING}
)
public class StringCompressionII extends LeetCodeTask<Integer> {
    public static final int LEN = 100;

    private String string;
    private int removes;

    public static final String INFORMATION = """

        Description:
            Run-length encoding is a string compression method that works by replacing
                consecutive identical characters (repeated 2 or more times) with the concatenation
                of the character and the number marking the count of the characters (length of the run).
                For example, to compress the string "aabccc" we replace "aa" by "a2" and replace "ccc" by "c3".
                Thus the compressed string becomes "a2bc3".

            Notice that in this problem, we are not adding '1' after single characters.

            Given a string s and an integer k. You need to delete at most k characters from s
                such that the run-length encoded version of s has minimum length.

            Find the minimum length of the run-length encoded version of s after deleting at most k characters.

        Example:
            Input: s = "aaabcccd", k = 2
            Output: 4
            Explanation: Compressing s without deleting anything will give us "a3bc3d" of length 6.
                Deleting any of the characters 'a' or 'c' would at most decrease the length of the compressed string to 5,
                for instance delete 2 'a' then we will have s = "abcccd" which compressed is abc3d.
                Therefore, the optimal way is to delete 'b' and 'd', then the compressed version of s will be "a3c3" of length 4.""";

    public StringCompressionII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        while (len > 0) {
            char letter = (char) random.nextInt('a', 'z' + 1);
            if (random.nextBoolean()) {
                int count = random.nextInt(1, 10);
                builder.append(String.valueOf(letter).repeat(count));
                len -= count;
            } else {
                builder.append(letter);
                len--;
            }
        }
        this.string = builder.toString();
        this.removes = random.nextInt(0, string.length());

        log.info("String 's': {}", string);
        log.info("Removes 'k': {}", removes);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2058 ms
    @Override
    protected Integer original() {
        var original = new Original(string, removes);
        return original.process();
    }

    // time = 1869 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string, removes);
        return practice.process();
    }

    // time = 1730 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string, removes);
        return solution.process();
    }
}
