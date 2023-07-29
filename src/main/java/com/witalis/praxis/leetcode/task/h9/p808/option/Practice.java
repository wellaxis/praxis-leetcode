package com.witalis.praxis.leetcode.task.h9.p808.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 808
 * Name: Soup Servings
 * URL: <a href="https://leetcode.com/problems/soup-servings/">Soup Servings</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Practice(int number) {
        this.number = number;
    }

    public Double process() {
        return soupServings(number);
    }

    record Serving(int soup1, int soup2) {}

    enum Operation {
        SERVE1(new Serving(100, 0)),
        SERVE2(new Serving(75, 25)),
        SERVE3(new Serving(50, 50)),
        SERVE4(new Serving(25, 75));

        private final Serving serve;

        Operation(Serving serve) {
            this.serve = serve;
        }
    }

    private Map<Serving, Double> memo;

    public double soupServings(int n) {
        if (n < 0) return 0D;
        if (n > 5_000) return 1D;

        this.memo = new HashMap<>();

        return solver(new Serving(n, n));
    }

    private double solver(Serving serving) {
        if (serving.soup1 <= 0 || serving.soup2 <= 0) {
            if (serving.soup1 <= 0 && serving.soup2 <= 0) return 0.5;
            return (serving.soup1 <= 0) ? 1 : 0;
        }

        if (memo.containsKey(serving)) return memo.get(serving);

        double probability = 0D;
        for (Operation operation : Operation.values()) {
            probability += solver(new Serving(serving.soup1 - operation.serve.soup1, serving.soup2 - operation.serve.soup2)) / 4;
        }

        memo.put(serving, probability);

        return probability;
    }
}
