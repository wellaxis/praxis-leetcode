package com.witalis.praxis.leetcode.task.h8.p703;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p703.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 703,
    description = "Kth Largest Element in a Stream",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, DESIGN, BINARY_SEARCH_TREE, HEAP, BINARY_TREE, DATA_STREAM}
)
public class KthLargestElementInStream extends LeetCodeTask<int[]> {
    public static final int VALUE = 10_000;
    public static final int LEN = 10_000;
    public static final int EXTRA_LEN = 10;

    private int[] numbers;
    private int k;
    private int[] extra;

    public static final String INFORMATION = """

        Design a class to find the kth largest element in a stream.
            Note that it is the kth largest element in the sorted order,
            not the kth distinct element.

        Implement KthLargest class:
            * KthLargest(int k, int[] nums) Initializes the object
              with the integer k and the stream of integers nums.
            * int add(int val) Appends the integer val to the stream
              and returns the element representing the kth largest element in the stream.

        Example:
            Input
                ["KthLargest", "add", "add", "add", "add", "add"]
                [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
            Output
                [null, 4, 5, 5, 8, 8]
            Explanation
                KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
                kthLargest.add(3);   // return 4
                kthLargest.add(5);   // return 5
                kthLargest.add(10);  // return 5
                kthLargest.add(9);   // return 8
                kthLargest.add(4);   // return 8""";

    public KthLargestElementInStream(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.numbers = random.ints(
            random.nextInt(0, LEN + 1),
            -VALUE,
            VALUE + 1
        ).toArray();
        this.extra = random.ints(
            EXTRA_LEN,
            -VALUE,
            VALUE + 1
        ).toArray();
        this.k = random.nextInt(1, numbers.length + 1);

        log.info("K element is {}", k);
        log.info("Numbers are {}", numbers);
        log.info("Extra numbers are {}", extra);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 10438 ms
    @Override
    protected int[] original() {
        var original = new Original(k, numbers.clone(), extra.clone());
        return original.process();
    }

    // time = 3877 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(k, numbers.clone(), extra.clone());
        return practice.process();
    }

    // time = 3158 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(k, numbers.clone(), extra.clone());
        return solution.process();
    }
}
