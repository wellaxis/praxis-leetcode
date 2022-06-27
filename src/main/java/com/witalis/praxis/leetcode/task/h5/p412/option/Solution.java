package com.witalis.praxis.leetcode.task.h5.p412.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 412
 * Name: Fizz Buzz
 * URL: <a href="https://leetcode.com/problems/fizz-buzz/">Fizz Buzz</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public List<String> process() {
        return fizzBuzz(number);
    }

    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();

        // map to store all fizzbuzz mappings
        Map<Integer, String> fizzBizzDictionary = Map.of(3, "Fizz", 5, "Buzz");

        // list of divisors which we will iterate over
        List<Integer> divisors = List.of(3, 5);

        for (int num = 1; num <= n; num++) {
            String numAnsStr = "";

            for (Integer key : divisors) {
                // num is divisible by key, add the corresponding string mapping to current numAnsStr
                if (num % key == 0) {
                    numAnsStr += fizzBizzDictionary.get(key);
                }
            }

            if (numAnsStr.equals("")) {
                // not divisible by 3 or 5, add the number
                numAnsStr += Integer.toString(num);
            }

            // append the current answer str to the ans list
            ans.add(numAnsStr);
        }

        return ans;
    }
}
