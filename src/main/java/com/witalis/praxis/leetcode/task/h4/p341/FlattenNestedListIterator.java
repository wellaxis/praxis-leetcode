package com.witalis.praxis.leetcode.task.h4.p341;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p341.content.NestInteger;
import com.witalis.praxis.leetcode.task.h4.p341.content.NestedInteger;
import com.witalis.praxis.leetcode.task.h4.p341.option.*;
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
    id = 341,
    description = "Flatten Nested List Iterator",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STACK, TREE, DEPTH_FIRST_SEARCH, DESIGN, QUEUE, ITERATOR}
)
public class FlattenNestedListIterator extends LeetCodeTask<List<String>> {
    public static final int LEN = 500;
    public static final int VALUE = 1_000_000;
    private List<NestedInteger> nestedIntegers;

    public static final String INFORMATION = """

        Description:
            You are given a nested list of integers nestedList.
                Each element is either an integer or a list whose elements may also be integers or other lists.
                Implement an iterator to flatten it.

            Implement the NestedIterator class:
                * NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
                * int next() Returns the next integer in the nested list.
                * boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.

            Your code will be tested with the following pseudocode:
                initialize iterator with nestedList
                res = []
                while iterator.hasNext()
                    append iterator.next() to the end of res
                return res

            If res matches the expected flattened list, then your code will be judged as correct.

        Example:
            Input: nestedList = [[1,1],2,[1,1]]
            Output: [1,1,2,1,1]
            Explanation: By calling next repeatedly until hasNext returns false,
                the order of elements returned by next should be: [1,1,2,1,1].""";

    public FlattenNestedListIterator(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.nestedIntegers = new ArrayList<>();
        for (int i = 0; i < len; i++) nestedIntegers.add(generateNestedInteger(0));

        log.info("Nested integers: {}", nestedIntegers);
    }

    private static NestedInteger generateNestedInteger(int level) {
        final var levelThreshold = 3;
        final var maxListCapacity = 5;
        final var random = ThreadLocalRandom.current();

        if (random.nextBoolean() || level > levelThreshold) {
            return new NestInteger(random.nextInt(-VALUE, VALUE + 1));
        } else {
            List<NestedInteger> nestedList = new ArrayList<>();
            int len = random.nextInt(1, maxListCapacity + 1);
            for (int i = 0; i < len; i++) nestedList.add(generateNestedInteger(level + 1));
            return new NestInteger(nestedList);
        }
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 18825 ms
    @Override
    protected List<String> original() {
        var original = new Original(nestedIntegers);
        return original.process();
    }

    // time = 5578 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(nestedIntegers);
        return practice.process();
    }

    // time = 4373 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(nestedIntegers);
        return solution.process();
    }
}
