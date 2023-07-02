package com.witalis.praxis.leetcode.task.h24.p2305.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2305
 * Name: Fair Distribution of Cookies
 * URL: <a href="https://leetcode.com/problems/fair-distribution-of-cookies/">Fair Distribution of Cookies</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] cookies;
    private int children;

    public Practice(int[] cookies, int children) {
        this.cookies = cookies;
        this.children = children;
    }

    public Integer process() {
        return distributeCookies(cookies, children);
    }

    private int[] distributions;
    private int minUnfairness;

    public int distributeCookies(int[] cookies, int k) {
        if (cookies == null || k <= 0) return 0;

        this.distributions = new int[k];
        this.minUnfairness = Integer.MAX_VALUE;

        dfs(cookies, 0, 0);

        return minUnfairness;
    }

    private void dfs(int[] cookies, int index, int group) {
        // all cookies have been distributed
        if (index == cookies.length) {
            // maximum value among all bags
            int unfairnes = 0;
            for (int distribution : distributions) {
                unfairnes = Math.max(unfairnes, distribution);
            }
            minUnfairness = Math.min(minUnfairness, unfairnes);
            return;
        }

        for (int i = 0; i < group; i++) {
            distributions[i] += cookies[index];
            dfs(cookies, index + 1, group);
            distributions[i] -= cookies[index];
        }

        if (group < distributions.length) {
            distributions[group] += cookies[index];
            dfs(cookies, index + 1, group + 1);
            distributions[group] -= cookies[index];
        }
    }
}
