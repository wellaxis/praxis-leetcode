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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public List<String> process() {
        return fizzBuzz(number);
    }

    public List<String> fizzBuzz(int n) {
        if (n < 1) return Collections.emptyList();

        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean divisibleBy3 = divisibleThree(i);
            boolean divisibleBy5 = divisibleFive(i);
            if (divisibleBy3 && divisibleBy5) {
                answer.add("FizzBuzz");
            } else if (divisibleBy3) {
                answer.add("Fizz");
            } else if (divisibleBy5) {
                answer.add("Buzz");
            } else {
                answer.add("" + i);
            }
        }

        return answer;
    }

    private boolean divisibleThree(int n) {
        int sum;
        do {
            sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
        } while (n > 9);

        return (n % 3 == 0);
    }

    private boolean divisibleFive(int n) {
        String num = String.valueOf(n);
        char digit = num.charAt(num.length() - 1);

        return (digit == '0' || digit == '5');
    }
}
