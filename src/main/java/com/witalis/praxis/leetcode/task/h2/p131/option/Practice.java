package com.witalis.praxis.leetcode.task.h2.p131.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 131
 * Name: Palindrome Partitioning
 * URL: <a href="https://leetcode.com/problems/palindrome-partitioning/">Palindrome Partitioning</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Practice(String string) {
        this.string = string;
    }

    public List<List<String>> process() {
        return partition(string);
    }

    private Set<String> palindromes = new HashSet<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return Collections.emptyList();

        List<List<String>> partitions = new ArrayList<>();
        recursivePartition(s, 0, new ArrayList<>(), partitions);

        return partitions;
    }

    private void recursivePartition(String s, int index, List<String> candidates, List<List<String>> partitions) {
        if (index >= s.length()) {
            partitions.add(new ArrayList<>(candidates));
            return;
        }

        int begin;
        int end;
        boolean palindrome;

        for (int i = index; i < s.length(); i++) {
            String partition = s.substring(index, i + 1);

            palindrome = true;
            if (!palindromes.contains(partition)) {
                for (begin = index, end = i; begin < end; begin++, end--) {
                    if (s.charAt(begin) != s.charAt(end)) {
                        palindrome = false;
                        break;
                    }
                }
                if (palindrome) palindromes.add(partition);
            }

            if (palindrome) {
                candidates.add(partition);
                recursivePartition(s, i + 1, candidates, partitions);
                candidates.remove(candidates.size() - 1);
            }
        }
    }
}
