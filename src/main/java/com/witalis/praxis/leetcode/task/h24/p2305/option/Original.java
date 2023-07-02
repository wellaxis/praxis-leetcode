package com.witalis.praxis.leetcode.task.h24.p2305.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2305
 * Name: Fair Distribution of Cookies
 * URL: <a href="https://leetcode.com/problems/fair-distribution-of-cookies/">Fair Distribution of Cookies</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] cookies;
    private int children;

    public Integer process() {
        return distributeCookies(cookies, children);
    }

    public int distributeCookies(int[] cookies, int k) {
        if (cookies == null || k <= 0) return 0;

        final int[] distributions = new int[k];
        final int[] minUnfairness = new int[] {Integer.MAX_VALUE};

        dfs(cookies, distributions, minUnfairness, 0, 0);

        return minUnfairness[0];
    }

    private void dfs(int[] cookies, int[] distributions, int[] minUnfairness, int index, int group) {
        // all cookies have been distributed
        if (index == cookies.length) {
            // maximum value among all bags
            int unfairnes = 0;
            for (int distribution : distributions) {
                unfairnes = Math.max(unfairnes, distribution);
            }
            minUnfairness[0] = Math.min(minUnfairness[0], unfairnes);
            return;
        }

        for (int i = 0; i < group; i++) {
            distributions[i] += cookies[index];
            dfs(cookies, distributions, minUnfairness, index + 1, group);
            distributions[i] -= cookies[index];
        }

        if (group < distributions.length) {
            distributions[group] += cookies[index];
            dfs(cookies, distributions, minUnfairness, index + 1, group + 1);
            distributions[group] -= cookies[index];
        }
    }
}
