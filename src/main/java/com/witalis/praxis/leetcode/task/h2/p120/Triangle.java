package com.witalis.praxis.leetcode.task.h2.p120;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p120.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 120,
    description = "Triangle",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class Triangle extends LeetCodeTask<Integer> {
    public static final int LEN = 200;
    public static final int VALUE = 10_000;
    private List<List<Integer>> triangle;

    public static final String INFORMATION = """

        Given a triangle array, return the minimum path sum from top to bottom.

        For each step, you may move to an adjacent number of the row below.
            More formally, if you are on index i on the current row,
            you may move to either index i or index i + 1 on the next row.

        Example:
            Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
            Output: 11
            Explanation:
                The triangle looks like:
                   2
                  3 4
                 6 5 7
                4 1 8 3
                The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).""";

    public Triangle(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int len = random.nextInt(1, LEN + 1);
        List<List<Integer>> rows = new ArrayList<>();

        for (int i = 1; i <= len; i++) {
            List<Integer> row = random.ints(i, -VALUE, VALUE + 1).boxed().toList();
            rows.add(row);
        }
        this.triangle = rows;

        log.info("Triangle is {}", triangle);
    }

    private List<List<Integer>> clone(List<List<Integer>> triangle) {
        List<List<Integer>> clone = new ArrayList<>();
        triangle.forEach(item -> clone.add(new ArrayList<>(item)));
        return clone;
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6235 ms
    @Override
    protected Integer original() {
        var original = new Original(clone(triangle));
        return original.process();
    }

    // time = 5589 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(clone(triangle));
        return practice.process();
    }

    // time = 2089 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(clone(triangle));
        return solution.process();
    }
}
