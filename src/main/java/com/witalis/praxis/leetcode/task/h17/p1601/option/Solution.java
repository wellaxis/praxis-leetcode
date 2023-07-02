package com.witalis.praxis.leetcode.task.h17.p1601.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1601
 * Name: Maximum Number of Achievable Transfer Requests
 * URL: <a href="https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/">Maximum Number of Achievable Transfer Requests</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int buildings;
    private int[][] requests;

    public Integer process() {
        return maximumRequests(buildings, requests);
    }

    public int maximumRequests(int n, int[][] requests) {
        int answer = 0;

        for (int mask = 0; mask < (1 << requests.length); mask++) {
            int[] indegree = new int[n];
            int pos = requests.length - 1;
            // number of set bits representing the requests we will consider
            int bitCount = Integer.bitCount(mask);

            // if the request count we're going to consider is less than the maximum request
            // we have considered without violating the constraints; then we can return it cannot be the answer
            if (bitCount <= answer) {
                continue;
            }

            // ror all the 1's in the number, update the array indegree for the building it involves
            for (int curr = mask; curr > 0; curr >>= 1, pos--) {
                if ((curr & 1) == 1) {
                    indegree[requests[pos][0]]--;
                    indegree[requests[pos][1]]++;
                }
            }

            boolean flag = true;
            // check if it doesn't violate the constraints
            for (int i = 0; i < n; i++) {
                if (indegree[i] != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag)  {
                answer = bitCount;
            }
        }

        return answer;
    }
}
