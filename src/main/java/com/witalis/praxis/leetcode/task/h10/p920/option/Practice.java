package com.witalis.praxis.leetcode.task.h10.p920.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 920
 * Name: Number of Music Playlists
 * URL: <a href="https://leetcode.com/problems/number-of-music-playlists/">Number of Music Playlists</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int songs;
    private int goal;
    private int gap;

    public Practice(int songs, int goal, int gap) {
        this.songs = songs;
        this.goal = goal;
        this.gap = gap;
    }

    public Integer process() {
        return numMusicPlaylists(songs, goal, gap);
    }

    public static final long MOD = (long) 1e9 + 7;

    private long[][] dp;

    public int numMusicPlaylists(int n, int goal, int k) {
        if (n <= 0 || goal <= 0) return 0;

        this.dp = new long[goal + 1][goal + 1];
        for (long[] arr : dp) Arrays.fill(arr, -1);

        return (int) solver(n, goal, k, 0);
    }

    private long solver(int n, int goal, int k, int i) {
        if (goal == 0) return (i == n) ? 1 : 0;

        if (dp[i][goal] != -1) return dp[i][goal];

        long playlist = 0L;
        playlist = (playlist + ((n - i) * solver(n,goal - 1, k, i + 1)) % MOD) % MOD;
        if (i >= k) {
            playlist = (playlist + ((i - k) * solver(n, goal - 1, k, i)) % MOD) % MOD;
        }
        dp[i][goal] = playlist % MOD;

        return dp[i][goal];
    }
}
