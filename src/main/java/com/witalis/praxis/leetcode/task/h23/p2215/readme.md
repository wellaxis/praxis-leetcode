# [LeetCode][leetcode] task # 2215: [Find the Difference of Two Arrays][task]

Description
-----------

> Given two **0-indexed** integer arrays `nums1` and `nums2`, return _a list `answer` of size `2` where_:
> * `answer[0]` is a list of all **distinct** integers in `nums1` which are **not** present in `nums2`.
> * `answer[1]` is a list of all **distinct** integers in `nums2` which are **not** present in `nums1`.
>
> **Note** that the integers in the lists may be returned in **any** order.

Example
-------

```sh
Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
    For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
    For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
```

Solution
--------

| Task | Solution                                      |
|:----:|:----------------------------------------------|
| 2215 | [Find the Difference of Two Arrays][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/find-the-difference-of-two-arrays/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h23/p2215/option/Practice.java>
