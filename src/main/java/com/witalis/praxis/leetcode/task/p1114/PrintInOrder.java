package com.witalis.praxis.leetcode.task.p1114;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p1114.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.CONCURRENCY;

@Slf4j
@LeetCode(
    id = 1114,
    description = "Print in Order",
    tags = {CONCURRENCY}
)
public class PrintInOrder extends LeetCodeTask<Void> {
    private int[] numbers;

    public static final String INFORMATION = """

        Suppose we have a class:

        public class Foo {
            public void first() { print("first"); }
            public void second() { print("second"); }
            public void third() { print("third"); }
        }

        The same instance of Foo will be passed to three different threads.
            Thread A will call first(), thread B will call second(),
            and thread C will call third(). Design a mechanism and modify
            the program to ensure that second() is executed after first(),
            and third() is executed after second().

        Note:
            We do not know how the threads will be scheduled in the operating system,
            even though the numbers in the input seem to imply the ordering.
            The input format you see is mainly to ensure our tests' comprehensiveness.

        Example:
            Input: nums = [1,2,3]
            Output: "firstsecondthird"
            Explanation: There are three threads being fired asynchronously.
                The input [1,2,3] means thread A calls first(), thread B calls second(),
                and thread C calls third(). "firstsecondthird" is the correct output.""";

    public PrintInOrder(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var list = new ArrayList<>(IntStream.range(1, 4).boxed().toList());
        Collections.shuffle(list);
        this.numbers = list.stream().mapToInt(Integer::intValue).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1581 ms
    @Override
    protected Void original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 1105 ms
    @Override
    protected Void practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 954 ms
    @Override
    protected Void solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
