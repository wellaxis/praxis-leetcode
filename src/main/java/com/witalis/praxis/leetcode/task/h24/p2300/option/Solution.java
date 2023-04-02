package com.witalis.praxis.leetcode.task.h24.p2300.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2300
 * Name: Successful Pairs of Spells and Potions
 * URL: <a href="https://leetcode.com/problems/successful-pairs-of-spells-and-potions/">Successful Pairs of Spells and Potions</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] spells;
    private int[] potions;
    private long success;

    public int[] process() {
        return successfulPairs(spells, potions, success);
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // get the length of the spells and potions array
        int n = spells.length;
        int m = potions.length;

        // get the maximum potion strength
        int max = -1;
        for (final int potion : potions)
            max = Math.max(max, potion);

        // count the frequency of potions with a specific strength
        final int[] potionsCount = new int[max + 1];
        for (final int potion : potions)
            potionsCount[potion]++;

        // calculate the cumulative frequency of potions with strengths less than or equal to a specific strength
        int count = 0;
        for (int i = max; i >= 0; i--) {
            count += potionsCount[i];
            potionsCount[i] = count;
        }

        // initialize the array to store the number of successful pairs for each spell
        final int[] answer = new int[n];

        // iterate through each spell
        for (int i = 0; i < n; i++) {
            // get the target potion strength for a successful pair with the current spell
            long target = success / spells[i];

            // if the target strength is greater than the maximum strength of the potions array, skip to the next spell
            if (target > max) continue;

            // increase the target strength until it is greater than or equal to success / spells[i]
            while (target < 100001 && target * spells[i] < success) target++;

            // if the target strength is greater than the maximum strength of the potions array, skip to the next spell
            if (target > max) continue;

            // store the number of successful pairs for the current spell
            answer[i] = potionsCount[(int) target];
        }

        // return the array with the number of successful pairs for each spell
        return answer;
    }
}
