# [LeetCode][leetcode] task # 384: [Shuffle an Array][task]

Description
-----------

> Given an integer array `nums`, design an algorithm to randomly shuffle the array.
> All permutations of the array should be **equally** likely as a result of the shuffling.
> 
> Implement the `Solution` class:
> * `Solution(int[] nums)` Initializes the object with the integer array `nums`.
> * `int[] reset()` Resets the array to its original configuration and returns it.
> * `int[] shuffle()` Returns a random shuffling of the array.

Example
-------

```sh
Input
    ["Solution", "shuffle", "reset", "shuffle"]
    [[[1, 2, 3]], [], [], []]
Output
    [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
Explanation
    Solution solution = new Solution([1, 2, 3]);
    solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
                           // Any permutation of [1,2,3] must be equally likely to be returned.
                           // Example: return [3, 1, 2]
    solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
    solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
```

Solution
--------

| Task | Solution                     |
|:----:|:-----------------------------|
| 384  | [Shuffle an Array][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/shuffle-an-array/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h4/p384/option/Practice.java>
