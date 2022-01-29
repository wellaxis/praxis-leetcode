# [LeetCode][leetcode] task # 703: [Kth Largest Element in a Stream][task]

Description
-----------

> Design a class to find the `kth` largest element in a stream.
> Note that it is the `kth` largest element in the sorted order,
> not the `kth` distinct element.
> 
> Implement KthLargest class:
> * `KthLargest(int k, int[] nums)` Initializes the object
> with the integer `k` and the stream of integers `nums`.
> * `int add(int val)` Appends the integer `val` to the stream
> and returns the element representing the `kth` largest element in the stream.

Example
-------

```sh
Input
    ["KthLargest", "add", "add", "add", "add", "add"]
    [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
    [null, 4, 5, 5, 8, 8]
Explanation:
    KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
    kthLargest.add(3);   // return 4
    kthLargest.add(5);   // return 5
    kthLargest.add(10);  // return 5
    kthLargest.add(9);   // return 8
    kthLargest.add(4);   // return 8
```

Solution
--------

| Task | Solution                                    |
|:----:|:--------------------------------------------|
| 703  | [Kth Largest Element in a Stream][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/kth-largest-element-in-a-stream/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/h8/p703/option/Practice.java>
