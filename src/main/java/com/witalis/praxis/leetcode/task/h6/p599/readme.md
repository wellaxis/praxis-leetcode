# [LeetCode][leetcode] task # 599: [Minimum Index Sum of Two Lists][task]

Description
-----------

> Given two arrays of strings `list1` and `list2`, find the **common strings with the least index sum**.
> 
> A **common string** is a string that appeared in both `list1` and `list2`.
> 
> A **common string with the least index sum** is a common string such
> that if it appeared at `list1[i]` and `list2[j]` then `i + j` should be the minimum value
> among all the other **common strings**.
> 
> Return _all the **common strings with the least index sum**_. Return the answer in **any order**.

Example
-------

```sh
Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
Output: ["sad","happy"]
Explanation: There are three common strings:
    "happy" with index sum = (0 + 1) = 1.
    "sad" with index sum = (1 + 0) = 1.
    "good" with index sum = (2 + 2) = 4.
    The strings with the least index sum are "sad" and "happy".
```

Solution
--------

| Task | Solution                                   |
|:----:|:-------------------------------------------|
| 599  | [Minimum Index Sum of Two Lists][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/minimum-index-sum-of-two-lists/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/h6/p599/option/Practice.java>
