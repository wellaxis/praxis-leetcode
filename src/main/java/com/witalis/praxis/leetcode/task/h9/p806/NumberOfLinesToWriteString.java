package com.witalis.praxis.leetcode.task.h9.p806;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p806.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 806,
    description = "Number of Lines To Write String",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, STRING}
)
public class NumberOfLinesToWriteString extends LeetCodeTask<int[]> {
    public static final int LEN = 1_000;
    public static final int SIZE = 10;

    private int[] widths;
    private String string;

    public static final String INFORMATION = """

        Description:
            You are given a string s of lowercase English letters and an array widths
                denoting how many pixels wide each lowercase English letter is.
                Specifically, widths[0] is the width of 'a', widths[1] is the width of 'b', and so on.

            You are trying to write s across several lines, where each line is no longer than 100 pixels.
                Starting at the beginning of s, write as many letters on the first line
                such that the total width does not exceed 100 pixels.
                Then, from where you stopped in s, continue writing as many letters as you can on the second line.
                Continue this process until you have written all of s.

            Return an array result of length 2 where:#
                * result[0] is the total number of lines.
                * result[1] is the width of the last line in pixels.

        Example:
            Input: widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10], s = "bbbcccdddaaa"
            Output: [2,4]
            Explanation: You can write s as follows:
                bbbcccdddaa  // 98 pixels wide
                a            // 4 pixels wide
                There are a total of 2 lines, and the last line is 4 pixels wide.""";

    public NumberOfLinesToWriteString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.widths = new int[26];
        for (int i = 0; i < widths.length; i++) {
            widths[i] = random.nextInt(2, SIZE + 1);
        }

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.string = builder.toString();

        log.info("Widths: {}", Arrays.toString(widths));
        log.info("String: {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 502 ms
    @Override
    protected int[] original() {
        var original = new Original(widths, string);
        return original.process();
    }

    // time = 505 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(widths, string);
        return practice.process();
    }

    // time = 516 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(widths, string);
        return solution.process();
    }
}
