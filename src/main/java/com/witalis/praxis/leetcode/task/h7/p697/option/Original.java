package com.witalis.praxis.leetcode.task.h7.p697.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * ID: 697
 * Name: Degree of an Array
 * URL: <a href="https://leetcode.com/problems/degree-of-an-array/">Degree of an Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return findShortestSubArray(numbers);
    }

    class Element {
        public int value;
        public int frequency;
        public int startIndex;
        public int endIndex;

        public Element(int value, int frequency, int startIndex, int endIndex) {
            this.value = value;
            this.frequency = frequency;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }

    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Element> elements = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (elements.containsKey(value)) {
                elements.get(value).frequency++;
                elements.get(value).endIndex = i;
            } else {
                elements.put(value, new Element(value, 1, i, i));
            }
        }

        Comparator<Element> sortByFrequency = (e1, e2) -> Integer.compare(e1.frequency, e2.frequency);
        Comparator<Element> sortByDuration = (e1, e2) -> Integer.compare(e1.endIndex - e1.startIndex, e2.endIndex - e2.startIndex);

        Element element = elements.keySet().stream()
            .map(elements::get)
            .min(sortByFrequency.reversed().thenComparing(sortByDuration))
            .orElse(new Element(0, 0, 0, 0));

        return element.endIndex - element.startIndex + 1;
    }
}
