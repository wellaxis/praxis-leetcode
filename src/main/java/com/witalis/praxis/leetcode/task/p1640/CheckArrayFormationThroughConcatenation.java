package com.witalis.praxis.leetcode.task.p1640;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p1640.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@LeetCode(id = 1640, description = "Check Array Formation Through Concatenation")
public class CheckArrayFormationThroughConcatenation extends LeetCodeTask<Boolean> {
    private int[] array;
    private int[][] pieces;

    public static final String INFORMATION = """

        You are given an array of distinct integers arr
            and an array of integer arrays pieces,
            where the integers in pieces are distinct.
        Your goal is to form arr by concatenating the arrays in pieces in any order.
        However, you are not allowed to reorder the integers in each array pieces[i].
                                                      
        Return true if it is possible to form the array arr from pieces.
        Otherwise, return false.
        
        Example:
            Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
            Output: true
            Explanation: Concatenate [91] then [4,64] then [78]""";

    public CheckArrayFormationThroughConcatenation(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.array = new int[] {91,4,64,78};
        this.pieces = new int[][] {{78},{4,64},{91}};

        log.info("INIT: array {}, pieces {}", "[91,4,64,78]", "[[78],[4,64],[91]]");
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1158 ms
    @Override
    protected Boolean original() {
        var original = new Original(array.clone(), pieces.clone());
        return original.process();
    }

    // time = 1016 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(array.clone(), pieces.clone());
        return practice.process();
    }

    // time = 1036 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(array.clone(), pieces.clone());
        return solution.process();
    }
}
