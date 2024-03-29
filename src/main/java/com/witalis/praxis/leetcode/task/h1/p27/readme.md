# [LeetCode][leetcode] task # 27: [Remove Element][task]

Description
-----------

> Given an integer array `nums` and an integer `val`,
> remove all occurrences of `val` in `nums` in-place.
> The relative order of the elements may be changed.
> 
> Since it is impossible to change the length of the array in some languages,
> you must instead have the result be placed in the **first part** of the array `nums`.
> More formally, if there are `k` elements after removing the duplicates,
> then the first `k` elements of `nums` should hold the final result.
> It does not matter what you leave beyond the first `k` elements.
> 
> Return `k` _after placing the final result in the first_ `k` _slots of_ `nums`.
> 
> Do **not** allocate extra space for another array. You must do this
> by **modifying the input array** in-place with O(1) extra memory.
> 
> **Custom Judge:**
> 
> The judge will test your solution with the following code:
```
int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length
// It is sorted with no values equaling val.
int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
``` 
> If all assertions pass, then your solution will be **accepted**.

Example
-------

```sh
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5,
             with the first five elements of nums containing 0, 0, 1, 3, and 4.
             Note that the five elements can be returned in any order.
             It does not matter what you leave beyond the returned k (hence they are underscores).
```

Solution
--------

| Task | Solution                   |
|:----:|:---------------------------|
|  27  | [Remove Element][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/remove-element/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h1/p27/option/Practice.java>
