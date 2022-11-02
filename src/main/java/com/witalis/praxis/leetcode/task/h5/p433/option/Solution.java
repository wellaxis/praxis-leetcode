package com.witalis.praxis.leetcode.task.h5.p433.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 433
 * Name: Minimum Genetic Mutation
 * URL: <a href="https://leetcode.com/problems/minimum-genetic-mutation/">Minimum Genetic Mutation</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String start;
    private String end;
    private String[] bank;

    public Integer process() {
        return minMutation(start, end, bank);
    }

    public int minMutation(String start, String end, String[] bank) {
        int level = 0;
        char[] chr = {'A', 'C', 'G', 'T'};

        Set<String> hset = new HashSet<>();
        Collections.addAll(hset, bank);

        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        while (true) {
            level++;
            int n = queue.size();

            if (n == 0) {
                return -1;
            }

            for (int i = 0; i < n; i++) {
                char[] ch = Objects.requireNonNull(queue.poll()).toCharArray();

                for (int j = 0; j < 8; j++) {
                    char originalChar = ch[j];
                    for (int c = 0; c < 4; c++) {
                        ch[j] = chr[c];
                        String str = String.valueOf(ch);
                        if (str.equals(end)
                            && hset.contains(str)) {
                            return level;
                        }

                        if (!hset.contains(str)) {
                            continue;
                        }

                        hset.remove(str);
                        queue.add(str);
                    }
                    ch[j] = originalChar;
                }
            }
        }
    }
}
