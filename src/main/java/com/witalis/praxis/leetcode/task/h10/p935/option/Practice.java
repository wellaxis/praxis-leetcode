package com.witalis.praxis.leetcode.task.h10.p935.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ID: 935
 * Name: Knight Dialer
 * URL: <a href="https://leetcode.com/problems/knight-dialer/">Knight Dialer</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return knightDialer(number);
    }

    public static final int MOD = 1_000_000_007;

    public int knightDialer(int n) {
        if (n == 0) return 0;
        if (n == 1) return 10;

        Map<Integer, int[]> moves = new HashMap<>();
        moves.put(0, new int[] {4, 6});
        moves.put(1, new int[] {6, 8});
        moves.put(2, new int[] {7, 9});
        moves.put(3, new int[] {4, 8});
        moves.put(4, new int[] {0, 3, 9});
        moves.put(6, new int[] {0, 1, 7});
        moves.put(7, new int[] {2, 6});
        moves.put(8, new int[] {1, 3});
        moves.put(9, new int[] {2, 4});

        int[] dp = new int[10];
        Arrays.fill(dp, 1);

        for (int i = 2; i <= n; i++) {
            int[] tmp = new int[10];

            int[] dpTmp = dp;
            moves.forEach(
                (key, value) -> {
                    for (int item : value) {
                        tmp[key] = (tmp[key] + dpTmp[item]) % MOD;
                    }
                }
            );
            dp = tmp;
        }

        int answer = 0;
        for (int item : dp)
            answer = (answer + item) % MOD;

        return answer;
    }
}
