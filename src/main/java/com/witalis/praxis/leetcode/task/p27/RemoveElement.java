package com.witalis.praxis.leetcode.task.p27;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p27.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Slf4j
@LeetCode(id = 27, description = "Remove Element")
public class RemoveElement extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int MAX = 50;
    private int[] numbers;
    private int value;

    public static final String INFORMATION = """

        Given an integer array nums and an integer val,
            remove all occurrences of val in nums in-place.
            The relative order of the elements may be changed.
                                                
        Since it is impossible to change the length of the array in some languages,
            you must instead have the result be placed in the first part of the array nums.
            More formally, if there are k elements after removing the duplicates,
            then the first k elements of nums should hold the final result.
            It does not matter what you leave beyond the first k elements.

        Return k after placing the final result in the first k slots of nums.

        Do not allocate extra space for another array. You must do this
            by modifying the input array in-place with O(1) extra memory.
        
        Custom Judge:
            The judge will test your solution with the following code:
            ----------------------------------------------------------------------
            int[] nums = [...]; // Input array
            int val = ...; // Value to remove
            int[] expectedNums = [...]; // The expected answer with correct length
            // It is sorted with no values equaling val.
            int k = removeDuplicates(nums); // Calls your implementation
            assert k == expectedNums.length;
            sort(nums, 0, k); // Sort the first k elements of nums
            for (int i = 0; i < k; i++) assert nums[i] == expectedNums[i];
            ----------------------------------------------------------------------
            If all assertions pass, then your solution will be accepted.
        
        Example:
            Input: nums = [0,1,2,2,3,0,4,2], val = 2
            Output: 5, nums = [0,1,4,0,3,_,_,_]
            Explanation: Your function should return k = 5,
                         with the first five elements of nums containing 0, 0, 1, 3, and 4.
                         Note that the five elements can be returned in any order.
                         It does not matter what you leave beyond the returned k
                         (hence they are underscores).""";

    public RemoveElement(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.numbers = IntStream.generate(
                () -> random.nextInt(0, MAX + 1)
            )
            .limit(random.nextInt(0, LEN + 1))
            .toArray();
        this.value = random.nextInt(0, MAX + 1);

        log.info("Numbers are {}, value is {}", numbers, value);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 522 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone(), value);
        return original.process();
    }

    // time = 457 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone(), value);
        return practice.process();
    }

    // time = 431 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone(), value);
        return solution.process();
    }
}
