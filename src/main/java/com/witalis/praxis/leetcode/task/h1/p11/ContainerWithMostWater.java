package com.witalis.praxis.leetcode.task.h1.p11;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p11.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 11,
    description = "Container With Most Water",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, TWO_POINTERS, GREEDY}
)
public class ContainerWithMostWater extends LeetCodeTask<Integer> {
    public static final int SIZE = 100_000;
    public static final int VALUE = 10_000;
    private int[] height;

    public static final String INFORMATION = """

        Given n non-negative integers a1, a2, ..., an ,
            where each represents a point at coordinate (i, ai).
            n vertical lines are drawn such that
            the two endpoints of the line i is at (i, ai) and (i, 0).
        Find two lines, which, together with the x-axis forms a container,
            such that the container contains the most water..
                                                                        
        Notice that you may not slant the container.
        
        Example:
            Input: height = [1,8,6,2,5,4,8,3,7]
            Output: 49
            Explanation: The vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
                In this case, the max area of water the container can contain is 49.""";

    public ContainerWithMostWater(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.height = IntStream.generate(
                () -> random.nextInt(0, VALUE + 1)
            )
            .limit(random.nextInt(2, SIZE + 1))
            .toArray();
        log.info("Height is {}", Arrays.toString(height));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 906799 ms, limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(height.clone());
        return original.process();
    }

    // time = 682748 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(height.clone());
        return practice.process();
    }

    // time = 683094 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(height.clone());
        return solution.process();
    }
}
