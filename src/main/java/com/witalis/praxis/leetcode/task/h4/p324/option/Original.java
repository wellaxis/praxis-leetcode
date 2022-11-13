package com.witalis.praxis.leetcode.task.h4.p324.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 324
 * Name: Wiggle Sort II
 * URL: <a href="https://leetcode.com/problems/wiggle-sort-ii/">Wiggle Sort II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public int[] process() {
        wiggleSort(numbers);
        return numbers;
    }

    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 1) return;

        int len = nums.length;
        int[] wiggle = new int[len];

        Arrays.sort(nums);

        int half = (len - 1) / 2;

        int left = half - 1;
        int right = half + 1;

        int index = 0;
        boolean direct = true;
        wiggle[index] = nums[half];
        while (left >= 0 || right < len) {
            if (direct) {
                int r = right;
                while (r < len && nums[r] <= wiggle[index]) r++;
                if (r == len) throw new IllegalArgumentException("Array is incorrect");
                if (r == right) do right++; while (right < len && nums[right] < 0);
                wiggle[++index] = nums[r];
                nums[r] = -1;
            } else {
                int l = left;
                while (l >= 0 && nums[l] >= wiggle[index]) l--;
                if (l == -1) throw new IllegalArgumentException("Array is incorrect");
                if (l == left) do left--; while (left > 0 && nums[left] < 0);
                wiggle[++index] = nums[l];
                nums[l] = -1;
            }
            direct = !direct;
        }

        System.arraycopy(wiggle, 0, nums, 0, wiggle.length);
    }
}
