package com.witalis.praxis.leetcode.task.h5.p412.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 412
 * Name: Fizz Buzz
 * URL: <a href="https://leetcode.com/problems/fizz-buzz/">Fizz Buzz</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public List<String> process() {
        return fizzBuzz(number);
    }

    public List<String> fizzBuzz(int n) {
        if (n < 1) return Collections.emptyList();

        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                answer.add("FizzBuzz");
            } else if ((i % 3 == 0)) {
                answer.add("Fizz");
            } else if ((i % 5 == 0)) {
                answer.add("Buzz");
            } else {
                answer.add("" + i);
            }
        }

        return answer;
    }
}
