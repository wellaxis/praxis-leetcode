# [LeetCode][leetcode] task # 1345: [Jump Game IV][task]

Description
-----------

> Given an array of integers `arr`, you are initially positioned at the first index of the array.
> 
> In one step you can jump from index `i` to index:
> * `i + 1` where: `i + 1 < arr.length`.
> * `i - 1` where: `i - 1 >= 0`.
> * `j` where: `arr[i] == arr[j]` and `i != j`.
>
> Return _the minimum number of steps to reach the **last index** of the array_.
> 
> Notice that you can not jump outside the array at any time.

Example
-------

```sh
Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
```

Solution
--------

| Task | Solution                 |
|:----:|:-------------------------|
| 1345 | [Jump Game IV][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/jump-game-iv/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h14/p1345/option/Practice.java>
