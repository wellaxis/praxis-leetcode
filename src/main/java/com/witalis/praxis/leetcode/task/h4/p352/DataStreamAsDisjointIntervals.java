package com.witalis.praxis.leetcode.task.h4.p352;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p352.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 352,
    description = "Data Stream as Disjoint Intervals",
    difficulty = TaskDifficulty.HARD,
    tags = {BINARY_SEARCH, DESIGN, ORDERED_SET}
)
public class DataStreamAsDisjointIntervals extends LeetCodeTask<List<String>> {
    public static final int LEN = 30_000;
    public static final int VALUE = 10_000;

    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public static final String INFORMATION = """

        Description:
            Given a data stream input of non-negative integers a1, a2, ..., an,
                summarize the numbers seen so far as a list of disjoint intervals.

            Implement the SummaryRanges class:
                * SummaryRanges() Initializes the object with an empty stream.
                * void addNum(int value) Adds the integer value to the stream.
                * int[][] getIntervals() Returns a summary of the integers in the stream currently
                  as a list of disjoint intervals [starti, endi]. The answer should be sorted by starti.

        Example:
            Input
                ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
                [[], [1], [], [3], [], [7], [], [2], [], [6], []]
            Output
                [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
            Explanation
                SummaryRanges summaryRanges = new SummaryRanges();
                summaryRanges.addNum(1);      // arr = [1]
                summaryRanges.getIntervals(); // return [[1, 1]]
                summaryRanges.addNum(3);      // arr = [1, 3]
                summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
                summaryRanges.addNum(7);      // arr = [1, 3, 7]
                summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
                summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
                summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
                summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
                summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]""";

    public DataStreamAsDisjointIntervals(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        operations = new ArrayList<>();
        operations.add(new AbstractMap.SimpleEntry<>("SummaryRanges", null));

        int len = random.nextInt(1, LEN + 1);
        for (int i = 0; i < len; i++) {
            if (random.nextBoolean()) {
                int value = random.nextInt(0, VALUE + 1);
                operations.add(new AbstractMap.SimpleEntry<>("addNum", value));
            } else {
                operations.add(new AbstractMap.SimpleEntry<>("getIntervals", null));
            }
        }

        log.info("Operations are: {}", operations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 693169 ms
    @Override
    protected List<String> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 650425 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 1643877 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
