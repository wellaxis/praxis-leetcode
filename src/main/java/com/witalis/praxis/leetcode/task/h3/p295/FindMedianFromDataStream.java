package com.witalis.praxis.leetcode.task.h3.p295;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p295.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 295,
    description = "Find Median from Data Stream",
    difficulty = TaskDifficulty.HARD,
    tags = {STACK, DESIGN, QUEUE}
)
public class FindMedianFromDataStream extends LeetCodeTask<List<String>> {
    public static final int LEN = 50_000;
    public static final int VALUE = 100_000;

    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public static final String INFORMATION = """

        Description:
            The median is the middle value in an ordered integer list. If the size of the list is even,
                there is no middle value, and the median is the mean of the two middle values.
                * For example, for arr = [2,3,4], the median is 3.
                * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.

            Implement the MedianFinder class:
                * MedianFinder() initializes the MedianFinder object.
                * void addNum(int num) adds the integer num from the data stream to the data structure.
                * double findMedian() returns the median of all elements so far.
                  Answers within 10-5 of the actual answer will be accepted.

        Example:
            Input
                ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
                [[], [1], [2], [], [3], []]
            Output
                [null, null, null, 1.5, null, 2.0]
            Explanation
                MedianFinder medianFinder = new MedianFinder();
                medianFinder.addNum(1);    // arr = [1]
                medianFinder.addNum(2);    // arr = [1, 2]
                medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
                medianFinder.addNum(3);    // arr[1, 2, 3]
                medianFinder.findMedian(); // return 2.0""";

    public FindMedianFromDataStream(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(0, LEN + 1);

        operations = new ArrayList<>();
        operations.add(new AbstractMap.SimpleEntry<>("MedianFinder", null));
        operations.add(new AbstractMap.SimpleEntry<>("addNum", random.nextInt(-VALUE, VALUE)));
        for (int i = 0; i < len; i++) {
            if (random.nextBoolean()) {
                operations.add(new AbstractMap.SimpleEntry<>("addNum", random.nextInt(-VALUE, VALUE)));
            } else {
                operations.add(new AbstractMap.SimpleEntry<>("findMedian", null));
            }
        }

        log.info("Operations: {}", operations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3495702 ms, times limit exceeded
    @Override
    protected List<String> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 56904 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 52016 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
