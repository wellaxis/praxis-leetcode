# [LeetCode][leetcode] task # 832: [Flipping an Image][task]

Description
-----------

> Given an `n x n` binary matrix `image`, flip the image **horizontally**,
> then invert it, and return _the resulting image_.
> 
> To flip an image horizontally means that each row of the image is reversed.
> * For example, flipping `[1,1,0]` horizontally results in `[0,1,1]`.
>
> To invert an image means that each `0` is replaced by `1`, and each `1` is replaced by `0`.
> * For example, inverting `[0,1,1]` results in `[1,0,0]`.
 
 Example
-------

```sh
Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
    Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
```

Solution
--------

| Task | Solution                      |
|:----:|:------------------------------|
| 832  | [Flipping an Image][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/flipping-an-image/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h9/p832/option/Practice.java>
