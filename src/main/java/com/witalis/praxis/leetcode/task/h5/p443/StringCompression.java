package com.witalis.praxis.leetcode.task.h5.p443;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p443.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 443,
    description = "String Compression",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TWO_POINTERS, STRING}
)
public class StringCompression extends LeetCodeTask<Map<Integer, String>> {
    public static final int LEN = 2_000;

    private char[] chars;

    public static final String INFORMATION = """

        Description:
            Given an array of characters chars, compress it using the following algorithm:

            Begin with an empty string s. For each group of consecutive repeating characters in chars:
                 * If the group's length is 1, append the character to s.
                 * Otherwise, append the character followed by the group's length.

            The compressed string s should not be returned separately,
                but instead, be stored in the input character array chars.
                Note that group lengths that are 10 or longer will be split into multiple characters in chars.

            After you are done modifying the input array, return the new length of the array.

            You must write an algorithm that uses only constant extra space.

        Example:
            Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
            Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
            Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".""";

    public StringCompression(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        while (len > 0) {
            char letter = switch (random.nextInt(0, 3)) {
                case 0 -> (char) random.nextInt('A', 'Z' + 1);
                case 1 -> (char) random.nextInt('a', 'z' + 1);
                case 2 -> (char) random.nextInt(0, 10);
                default -> throw new IllegalStateException("Unexpected value: " + random.nextInt(0, 3));
            };
            if (random.nextBoolean()) {
                int count = random.nextInt(1, 21);
                builder.append(String.valueOf(letter).repeat(count));
                len -= count;
            } else {
                builder.append(letter);
                len--;
            }
        }
        this.chars = builder.toString().toCharArray();

        log.info("Chars: {}", Arrays.toString(chars));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 60395 ms
    @Override
    protected Map<Integer, String> original() {
        var original = new Original(chars.clone());
        return original.process();
    }

    // time = 16618 ms
    @Override
    protected Map<Integer, String> practice() {
        var practice = new Practice(chars.clone());
        return practice.process();
    }

    // time = 8138 ms
    @Override
    protected Map<Integer, String> solution() {
        var solution = new Solution(chars.clone());
        return solution.process();
    }
}
