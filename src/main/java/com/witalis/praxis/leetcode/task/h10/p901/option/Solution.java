package com.witalis.praxis.leetcode.task.h10.p901.option;

import com.witalis.praxis.leetcode.task.h10.p901.content.StockSpannable;
import com.witalis.praxis.leetcode.task.h10.p901.content.StockSpannerHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 901
 * Name: Online Stock Span
 * URL: <a href="https://leetcode.com/problems/online-stock-span/">Online Stock Span</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    class StockSpanner implements StockSpannable {
        private Deque<int[]> stack;

        public StockSpanner() {
            this.stack = new ArrayDeque<>();
        }

        @Override
        public int next(int price) {
            int ans = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                ans += stack.pop()[1];
            }
            stack.push(new int[] {price, ans});

            return ans;
        }
    }

    public List<Integer> process() {
        return StockSpannerHandler.process(operations, new StockSpanner());
    }
}
