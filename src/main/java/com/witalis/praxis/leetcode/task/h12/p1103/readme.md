# [LeetCode][leetcode] task # 1103: [Distribute Candies to People][task]

Description
-----------

> Suppose we have a class:
> We distribute some number of `candies`, to a row of `n = num_people people`
> in the following way:
> 
> We then give 1 candy to the first person, 2 candies to the second person,
> and so on until we give `n` candies to the last person.
> 
> Then, we go back to the start of the row, giving `n + 1` candies to the first person,
> `n + 2` candies to the second person, and so on until we give `2 * n` candies to the last person.
> 
> This process repeats (with us giving one more candy each time, and moving
> to the start of the row after we reach the end) until we run out of candies.
> The last person will receive all of our remaining candies
> (not necessarily one more than the previous gift).
> 
> Return an array (of length `num_people` and sum `candies`)
> that represents the final distribution of candies.

Example
-------

```sh
Input: candies = 10, num_people = 3
Output: [5,2,3]
Explanation:
    On the first turn, ans[0] += 1, and the array is [1,0,0].
    On the second turn, ans[1] += 2, and the array is [1,2,0].
    On the third turn, ans[2] += 3, and the array is [1,2,3].
    On the fourth turn, ans[0] += 4, and the final array is [5,2,3].
```

Solution
--------

| Task | Solution                                 |
|:----:|:-----------------------------------------|
| 1103 | [Distribute Candies to People][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/distribute-candies-to-people/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h12/p1103/option/Practice.java>
