# [LeetCode][leetcode] task # 1095: [Find in Mountain Array][task]

Description
-----------

> _(This problem is an interactive problem.)_
> 
> You may recall that an array `arr` is a **mountain array** if and only if:
> * `arr.length >= 3`
> * There exists some `i` with `0 < i < arr.length - 1` such that:
>   * `arr[0] < arr[1] < ... < arr[i - 1] < arr[i]`
>   * `arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`
> 
> Given a mountain array `mountainArr`, return _the **minimum** `index` such that
> `mountainArr.get(index) == target`. If such an `index` does not exist, return `-1`.
> 
> **You cannot access the mountain array directly**. You may only access the array using a `MountainArray` interface:
> * `MountainArray.get(k)` returns the element of the array at index `k` (0-indexed).
> * `MountainArray.length()` returns the length of the array.
> 
> Submissions making more than `100` calls to `MountainArray.get` will be judged _Wrong Answer_.
> Also, any solutions that attempt to circumvent the judge will result in disqualification.

Example
-------

```sh
Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
```

Solution
--------

| Task | Solution                           |
|:----:|:-----------------------------------|
| 1095 | [Find in Mountain Array][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/find-in-mountain-array/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h11/p1095/option/Practice.java>
