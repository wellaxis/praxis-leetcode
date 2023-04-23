package com.witalis.praxis.leetcode.task.h15.p1416;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1416.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1416,
    description = "Restore The Array",
    difficulty = TaskDifficulty.HARD,
    tags = {STRING, DYNAMIC_PROGRAMMING}
)
public class RestoreArray extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000_000_000;

    private String string;
    private int number;

    public static final String INFORMATION = """

        Description:
            A program was supposed to print an array of integers. The program forgot to print whitespaces
                and the array is printed as a string of digits s and all we know is that all integers in the array
                were in the range [1, k] and there are no leading zeros in the array.

            Given the string s and the integer k, return the number of the possible arrays that can be printed
                as s using the mentioned program. Since the answer may be very large, return it modulo 10^9 + 7.

        Example:
            Input: s = "1317", k = 2000
            Output: 8
            Explanation: Possible arrays are [1317],[131,7],[13,17],[1,317],[13,1,7],[1,31,7],[1,3,17],[1,3,1,7]""";

    public RestoreArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        builder.append(random.nextInt(1, 10));
        for (int i = 0; i < len; i++) {
            builder.append(random.nextInt(0, 10));
        }
        this.string = builder.toString();
        this.number = random.nextInt(1, VALUE + 1);

        log.info("String: '{}'", string);
        log.info("Number 'K': {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4969 ms
    @Override
    protected Integer original() {
        var original = new Original(string, number);
        return original.process();
    }

    // time = 4850 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string, number);
        return practice.process();
    }

    // time = 2306 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string, number);
        return solution.process();
    }
}
