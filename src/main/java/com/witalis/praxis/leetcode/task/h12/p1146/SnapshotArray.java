package com.witalis.praxis.leetcode.task.h12.p1146;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1146.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1146,
    description = "Snapshot Array",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, BINARY_SEARCH, DESIGN}
)
public class SnapshotArray extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 50_000;
    public static final int VALUE = 1_000_000_000;

    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    public static final String INFORMATION = """

        Description:
            Implement a SnapshotArray that supports the following interface:
            * SnapshotArray(int length) initializes an array-like data structure with the given length. Initially, each element equals 0.
            * void set(index, val) sets the element at the given index to be equal to val.
            * int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
            * int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id

        Example:
            Input: ["SnapshotArray","set","snap","set","get"]
                [[3],[0,5],[],[0,6],[0,0]]
            Output:
                [null,null,0,null,5]
            Explanation:
                SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
                snapshotArr.set(0,5);  // Set array[0] = 5
                snapshotArr.snap();  // Take a snapshot, return snap_id = 0
                snapshotArr.set(0,6);
                snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5""";

    public SnapshotArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        final int len = random.nextInt(1, LEN + 1);

        operations = new ArrayList<>(len);
        operations.add(new AbstractMap.SimpleEntry<>("SnapshotArray", new int[] {len}));
        operations.add(new AbstractMap.SimpleEntry<>("snap", new int[0]));

        int snapCounter = 0;
        for (int i = 1; i < len; i++) {
            int index = random.nextInt(0, len);
            int value = random.nextInt(0, VALUE + 1);
            int snapId = random.nextInt(0, snapCounter + 1);
            int operation = random.nextInt(0, 3);
            switch (operation) {
                case 0 -> operations.add(new AbstractMap.SimpleEntry<>("set", new int[] {index, value}));
                case 1 -> {
                    operations.add(new AbstractMap.SimpleEntry<>("snap", new int[0]));
                    snapCounter++;
                }
                case 2 -> operations.add(new AbstractMap.SimpleEntry<>("get", new int[] {index, snapId}));
                default -> throw new IllegalArgumentException("unexpected operation");
            }
        }

        log.info("Operations: {}", operations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 24468 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 20176 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 16945 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
