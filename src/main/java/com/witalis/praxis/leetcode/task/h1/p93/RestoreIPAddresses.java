package com.witalis.praxis.leetcode.task.h1.p93;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p93.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 93,
    description = "Restore IP Addresses",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, BACKTRACKING}
)
public class RestoreIPAddresses extends LeetCodeTask<List<String>> {
    public static final int LEN = 20;
    private String string;

    public static final String INFORMATION = """

        A valid IP address consists of exactly
            four integers separated by single dots.
        Each integer is between 0 and 255 (inclusive)
            and cannot have leading zeros.

        * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses,
            but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.

        Given a string s containing only digits,
            return all possible valid IP addresses
            that can be formed by inserting dots into s.

        You are not allowed to reorder or remove any digits in s.
        You may return the valid IP addresses in any order.

        Example:
            Input: s = "101023"
            Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]""";

    public RestoreIPAddresses(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int allocation = random.nextInt(0, 100);
        int size;

        if (allocation < 4) size = 5;
        else if (allocation < 6) size = 10;
        else if (allocation < 8) size = 20;
        else if (allocation < 10) size = 30;
        else if (allocation < 12) size = 20;
        else if (allocation < 14) size = 10;
        else size = 5;

        var length = random.nextInt(1, size + 1);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            allocation = random.nextInt(0, 100);
            if (allocation < 25) {
                builder.append('0');
            } else if (allocation < 45) {
                builder.append('1');
            } else if (allocation < 65) {
                builder.append('2');
            } else if (allocation < 70) {
                builder.append('3');
            } else if (allocation < 75) {
                builder.append('4');
            } else if (allocation < 80) {
                builder.append('5');
            } else if (allocation < 85) {
                builder.append('6');
            } else if (allocation < 90) {
                builder.append('7');
            } else if (allocation < 95) {
                builder.append('8');
            } else {
                builder.append('9');
            }
        }
        this.string = builder.toString();

        log.info("String is '{}'", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3298 ms
    @Override
    protected List<String> original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 903 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 500 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
