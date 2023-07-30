package com.witalis.praxis.leetcode.task.h7.p664;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p664.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 664,
    description = "Strange Printer",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, TWO_POINTERS, GREEDY}
)
public class StrangePrinter extends LeetCodeTask<Integer> {
    public static final int LEN = 100;

    private String string;

    public static final String INFORMATION = """

        Description:
            There is a strange printer with the following two special properties:
                * The printer can only print a sequence of the same character each time.
                * At each turn, the printer can print new characters starting from and ending
                  at any place and will cover the original existing characters.

            Given a string s, return the minimum number of turns the printer needed to print it.

        Example:
            Input: s = "aba"
            Output: 2
            Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.""";

    public StrangePrinter(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);

        StringBuilder builder = new StringBuilder();
        for (int s = 0; s < len; s++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }

        this.string = builder.toString();

        log.info("String 's': {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1157 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 1081 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 1702 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
