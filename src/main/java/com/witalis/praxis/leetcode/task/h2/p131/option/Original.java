package com.witalis.praxis.leetcode.task.h2.p131.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 131
 * Name: Palindrome Partitioning
 * URL: <a href="https://leetcode.com/problems/palindrome-partitioning/">Palindrome Partitioning</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public List<List<String>> process() {
        return partition(string);
    }

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return Collections.emptyList();

        List<List<String>> partitions = new ArrayList<>();
        recursivePartition(s, 0, new ArrayList<>(), partitions);

        return partitions;
    }

    private void recursivePartition(String s, int index, List<String> candidates, List<List<String>> partitions) {
        if (index >= s.length()) {
            partitions.add(candidates);
            return;
        }

        for (int i = index; i < s.length(); i++) {

            int k = 0;
            boolean palindrome = true;
            while (index + k < i - k) {
                if (s.charAt(index + k) != s.charAt(i - k)) {
                    palindrome = false;
                    break;
                }
                k++;
            }

            if (palindrome) {
                List<String> nextCandidates = new ArrayList<>(candidates);
                nextCandidates.add(s.substring(index, i + 1));
                recursivePartition(s, i + 1, nextCandidates, partitions);
            }
        }
    }
}
