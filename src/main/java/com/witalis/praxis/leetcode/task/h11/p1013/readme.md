# [LeetCode][leetcode] task # 1013: [Partition Array Into Three Parts With Equal Sum][task]

Description
-----------

> Given an array of integers `arr`,
> return _`true` if we can partition the array into three **non-empty** parts with equal sums_.
> 
> Formally, we can partition the array if we can find indexes `i + 1 < j` with
> `(arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])`

Example
-------

```sh
Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
```

Solution
--------

| Task | Solution                                                    |
|:----:|:------------------------------------------------------------|
| 1013 | [Partition Array Into Three Parts With Equal Sum][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h11/p1013/option/Practice.java>
