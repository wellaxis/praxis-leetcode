package com.witalis.praxis.leetcode.task.h1.p22;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p22.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 22,
    description = "Generate Parentheses",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, DYNAMIC_PROGRAMMING, BACKTRACKING}
)
public class GenerateParentheses extends LeetCodeTask<List<String>> {
    public static final int LEN = 8;
    private int number;

    public static final String INFORMATION = """

        Given n pairs of parentheses, write a function
            to generate all combinations of well-formed parentheses.
                                                                          
        Example:
            Input: n = 3
            Output: ["((()))","(()())","(())()","()(())","()()()"]""";

    public GenerateParentheses(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current()
            .nextInt(1, LEN + 1);

        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1028 ms
    @Override
    protected List<String> original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 962 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 967 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
