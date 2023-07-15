package com.witalis.praxis.leetcode.task.h18.p1751.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1751
 * Name: Maximum Number of Events That Can Be Attended II
 * URL: <a href="https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/">Maximum Number of Events That Can Be Attended II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] events;
    private int attendance;

    public Integer process() {
        return maxValue(events, attendance);
    }

    public int maxValue(int[][] events, int k) {
        int max = 0;
        if (k == 1) {
            for (int[] event : events)
                max = Math.max(max, event[2]);

            return max;
        }

        // sort the events based on start time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int size = events.length;

        int[][] cache = new int[size + 1][k + 1];

        // if you want to create a recursive method, you can break off the rest of the code into a DFS method

        // looping through each event from the back
        for (int i = size - 1; i >= 0; i--) {
            // find the next available event (next event's start must be after current event's end)
            int next = binarySearch(events, events[i][1], i + 1, size);

            for (int j = 1; j <= k; j++) {
                // we have 2 choices: attend current event OR skip current & attend the next available event
                cache[i][j] = Math.max(cache[i + 1][j], // current event
                    cache[next][j - 1] + events[i][2]); // last event + next available event
            }
        }
        return cache[0][k];
    }

    // search for next available event that starts after current event ends
    private int binarySearch(int[][] events, int targetEnd, int lo, int hi) {
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (targetEnd >= events[mid][0]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
