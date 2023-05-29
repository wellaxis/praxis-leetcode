package com.witalis.praxis.leetcode.task.h9.p821;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p821.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 821,
    description = "Shortest Distance to a Character",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, TWO_POINTERS, STRING}
)
public class ShortestDistanceToCharacter extends LeetCodeTask<int[]> {
    public static final int LEN = 10_000;

    private String string;
    private char character;

    public static final String INFORMATION = """

        Description:
            Given a string s and a character c that occurs in s,
                return an array of integers answer where answer.length == s.length and answer[i]
                is the distance from index i to the closest occurrence of character c in s.

            The distance between two indices i and j is abs(i - j), where abs is the absolute value function.

        Example:
            Input: s = "loveleetcode", c = "e"
            Output: [3,2,1,0,1,0,0,1,2,2,1,0]
            Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
                The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
                The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
                For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
                The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.""";

    public ShortestDistanceToCharacter(int id, String description, TaskRevision revision) {
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

        final int index = random.nextInt(0, len);
        this.character = string.charAt(index);

        log.info("String: '{}'", string);
        log.info("Character: '{}'", character);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1197 ms
    @Override
    protected int[] original() {
        var original = new Original(string, character);
        return original.process();
    }

    // time = 1127 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(string, character);
        return practice.process();
    }

    // time = 1193 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(string, character);
        return solution.process();
    }
}
