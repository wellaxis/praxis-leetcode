package com.witalis.praxis.leetcode.task.h1.p0;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p0.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@LeetCode(
    id = 0,
    description = "Template Task",
    difficulty = TaskDifficulty.EASY,
    tags = {}
)
public class Template extends LeetCodeTask<Object> {
    private Object object;

    public static final String INFORMATION = """

            Description:
                It is a template for leetCode task.""";

    public Template(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.object = new Object();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    @Override
    protected Object original() {
        var original = new Original(object);
        return original.process();
    }

    @Override
    protected Object practice() {
        var practice = new Practice(object);
        return practice.process();
    }

    @Override
    protected Object solution() {
        var solution = new Solution(object);
        return solution.process();
    }
}
