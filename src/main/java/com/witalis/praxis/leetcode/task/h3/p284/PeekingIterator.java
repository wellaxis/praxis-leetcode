package com.witalis.praxis.leetcode.task.h3.p284;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p284.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 284,
    description = "Peeking Iterator",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DESIGN, ITERATOR}
)
public class PeekingIterator extends LeetCodeTask<List<String>> {
    public static final int LEN = 1_000;
    public static final int VALUE = 1_000;
    private List<AbstractMap.SimpleEntry<String, Iterator<Integer>>> operations1;
    private List<AbstractMap.SimpleEntry<String, Iterator<Integer>>> operations2;
    private List<AbstractMap.SimpleEntry<String, Iterator<Integer>>> operations3;

    public static final String INFORMATION = """

        Design an iterator that supports the peek operation on an existing iterator
            in addition to the hasNext and the next operations.

        Implement the PeekingIterator class:
            * PeekingIterator(Iterator<int> nums) Initializes the object with the given integer iterator iterator.
            * int next() Returns the next element in the array and moves the pointer to the next element.
            * boolean hasNext() Returns true if there are still elements in the array.
            * int peek() Returns the next element in the array without moving the pointer.

        Note: Each language may have a different implementation of the constructor
            and Iterator, but they all support the int next() and boolean hasNext() functions.

        Example:
            Input:
                ["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
                [[[1, 2, 3]], [], [], [], [], []]
            Output:
                [null, 1, 2, 2, 3, false]
            Explanation:
                PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [1,2,3]
                peekingIterator.next();    // return 1, the pointer moves to the next element [1,2,3].
                peekingIterator.peek();    // return 2, the pointer does not move [1,2,3].
                peekingIterator.next();    // return 2, the pointer moves to the next element [1,2,3]
                peekingIterator.next();    // return 3, the pointer moves to the next element [1,2,3]
                peekingIterator.hasNext(); // return false""";

    public PeekingIterator(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    @SuppressWarnings("unchecked")
    private void initialization() {
        var random = ThreadLocalRandom.current();
        int len = random.nextInt(1, LEN + 1);

        List<Integer> values = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).boxed().toList();

        operations1 = new ArrayList<>(len);
        operations2 = new ArrayList<>(len);
        operations3 = new ArrayList<>(len);

        operations1.add(new AbstractMap.SimpleEntry<>("PeekingIterator", values.iterator()));
        operations2.add(new AbstractMap.SimpleEntry<>("PeekingIterator", values.iterator()));
        operations3.add(new AbstractMap.SimpleEntry<>("PeekingIterator", values.iterator()));

        for (int i = 1; i < len; i++) {
            int operation = random.nextInt(0, 3);
            switch (operation) {
                case 0 -> {
                    operations1.add(new AbstractMap.SimpleEntry<>("peek", null));
                    operations2.add(new AbstractMap.SimpleEntry<>("peek", null));
                    operations3.add(new AbstractMap.SimpleEntry<>("peek", null));
                }
                case 1 -> {
                    operations1.add(new AbstractMap.SimpleEntry<>("next", null));
                    operations2.add(new AbstractMap.SimpleEntry<>("next", null));
                    operations3.add(new AbstractMap.SimpleEntry<>("next", null));
                }
                case 2 -> {
                    operations1.add(new AbstractMap.SimpleEntry<>("hasNext", null));
                    operations2.add(new AbstractMap.SimpleEntry<>("hasNext", null));
                    operations3.add(new AbstractMap.SimpleEntry<>("hasNext", null));
                }
                default -> throw new IllegalArgumentException("unexpected operation");
            }
        }

        log.info("Peeking iterator is {}", operations1.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1459 ms
    @Override
    protected List<String> original() {
        var original = new Original(operations1);
        return original.process();
    }

    // time = 1390 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(operations2);
        return practice.process();
    }

    // time = 1556 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(operations3);
        return solution.process();
    }
}
