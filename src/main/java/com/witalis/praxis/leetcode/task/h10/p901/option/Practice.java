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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    class StockSpanner implements StockSpannable {
        public static final int PRICE = 0;
        public static final int SPAN = 1;

        private List<int[]> spans;

        public StockSpanner() {
            this.spans = new ArrayList<>();
        }

        @Override
        public int next(int price) {
            int span = 1;
            if (!spans.isEmpty()) {
                int index = spans.size() - 1;
                do {
                    int[] day = spans.get(index);
                    if (day[PRICE] > price) break;

                    span += day[SPAN];
                    index -= day[SPAN];
                } while (index >= 0);
            }
            spans.add(new int[] {price, span});

            return span;
        }
    }

    public List<Integer> process() {
        return StockSpannerHandler.process(operations, new StockSpanner());
    }
}
