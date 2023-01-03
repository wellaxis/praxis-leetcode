package com.witalis.praxis.leetcode.task.h10.p944;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p944.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 944,
    description = "Delete Columns to Make Sorted",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, STRING}
)
public class DeleteColumnsToMakeSorted extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int AMOUNT = 100;
    private String[] strings;

    public static final String INFORMATION = """

        Description:
            You are given an array of n strings strs, all of the same length.

            The strings can be arranged such that there is one on each line, making a grid.
                For example, strs = ["abc", "bce", "cae"] can be arranged as:
                * abc
                * bce
                * cae

            You want to delete the columns that are not sorted lexicographically.
                In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted
                while column 1 ('b', 'c', 'a') is not, so you would delete column 1.

            Return the number of columns that you will delete.

        Example:
            Input: strs = ["cba","daf","ghi"]
            Output: 1
            Explanation:
                The grid looks as follows:
                    cba
                    daf
                    ghi
                Columns 0 and 2 are sorted, but column 1 is not, so you only need to delete 1 column.""";

    public DeleteColumnsToMakeSorted(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var amount = random.nextInt(1, AMOUNT + 1);
        this.strings = new String[amount];
        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder;
        for (int i = 0; i < amount; i++) {
            builder = new StringBuilder();
            for (int j = 0; j < len; j++) {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
            strings[i] = builder.toString();
        }

        log.info("Strings: {}", Arrays.toString(strings));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 618 ms
    @Override
    protected Integer original() {
        var original = new Original(strings);
        return original.process();
    }

    // time = 607 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(strings);
        return practice.process();
    }

    // time = 606 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(strings);
        return solution.process();
    }
}
