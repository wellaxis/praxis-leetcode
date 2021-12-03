package com.witalis.praxis.leetcode.task.p26;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p26.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Slf4j
@LeetCode(id = 26, description = "Remove Duplicates from Sorted Array")
public class RemoveDuplicatesFromSortedArray extends LeetCodeTask<Integer> {
    public static final int LEN = 3 * (int) Math.pow(10, 4);
    public static final int MAX = 100;
    private int[] numbers;

    public static final String INFORMATION = """

        Given an integer array nums sorted in non-decreasing order,
            remove the duplicates in-place such that each unique element appears only once.
            The relative order of the elements should be kept the same.
                                                
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
            int[] expectedNums = [...]; // The expected answer with correct length
            int k = removeDuplicates(nums); // Calls your implementation
            assert k == expectedNums.length;
            for (int i = 0; i < k; i++) assert nums[i] == expectedNums[i];
            ----------------------------------------------------------------------
            If all assertions pass, then your solution will be accepted.
        
        Example:
            Input: nums = [0,0,1,1,1,2,2,3,3,4]
            Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
            Explanation: Your function should return k = 5,
                         with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
                         It does not matter what you leave beyond the returned k
                         (hence they are underscores).""";

    public RemoveDuplicatesFromSortedArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.numbers = IntStream.generate(
                () -> random.nextInt(-MAX, MAX + 1)
            )
            .limit(random.nextInt(0, LEN + 1))
            .sorted()
            .toArray();

        log.info("Numbers are {}", numbers);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 771 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 662 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 676 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
