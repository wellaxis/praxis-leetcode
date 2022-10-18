package com.witalis.praxis.leetcode.task.h4.p307.option;

import com.witalis.praxis.leetcode.task.h4.p307.content.NumericArray;
import com.witalis.praxis.leetcode.task.h4.p307.content.NumericArrayHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;

/**
 * ID: 307
 * Name: Range Sum Query - Mutable
 * URL: <a href="https://leetcode.com/problems/range-sum-query-mutable/">Range Sum Query - Mutable</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;
    private int[] numbers;

    class SegmentTree {
        int[] nums;
        Node root;

        class Node {
            int begin;
            int end;
            int sum;
            Node left;
            Node right;
        }

        public SegmentTree(int[] nums) {
            this.nums = nums;
            this.root = init(0, nums.length, nums);
        }

        private Node init(int begin, int end, int[] array) {
            if (array.length == 0 || begin < 0 || end < 0 || begin > end) return null;

            Node node = new Node();
            node.begin = begin;
            node.end = end - 1;

            int len = array.length;

            if (len == 1) {
                node.sum = array[0];
            } else {
                int mid = begin + (end - begin) / 2;
                int add = array.length % 2 == 1 ? 1 : 0;

                Node left = init(begin, mid + add, Arrays.copyOfRange(array, 0, len / 2 + add));
                Node right = init(mid + add, end, Arrays.copyOfRange(array, len / 2 + add, len));

                if (left != null) {
                    node.left = left;
                    node.sum += left.sum;
                }
                if (right != null) {
                    node.right = right;
                    node.sum += right.sum;
                }
            }

            return node;
        }

        public void update(int index, int value) {
            int previous = nums[index];
            nums[index] = value;
            update(index, value, previous, root);
        }

        private void update(int index, int value, int previous, Node node) {
            if (node == null) return;

            if (node.begin <= index && index <= node.end) node.sum += (value - previous);

            int mid = node.begin + (node.end - node.begin) / 2;
            if (index > mid) {
                update(index, value, previous, node.right);
            } else {
                update(index, value, previous, node.left);
            }
        }

        public int sumRange(int left, int right) {
            return sumRange(left, right, root);
        }

        private int sumRange(int left, int right, Node node) {
            if (node == null) return 0;

            if (left <= node.begin && node.end <= right) return node.sum;

            int sum = 0;
            int mid = node.begin + (node.end - node.begin) / 2;

            if (left <= mid) sum += sumRange(left, right, node.left);
            if (right >= mid) sum += sumRange(left, right, node.right);

            return sum;
        }
    }

    public class NumArray implements NumericArray {
        private final SegmentTree tree;

        public NumArray(int[] nums) {
            this.tree = new SegmentTree(nums);
        }

        @Override
        public void update(int index, int val) {
            tree.update(index, val);
        }

        @Override
        public int sumRange(int left, int right) {
            return tree.sumRange(left, right);
        }
    }

    public List<Integer> process() {
        return NumericArrayHandler.process(operations, new NumArray(numbers));
    }
}
