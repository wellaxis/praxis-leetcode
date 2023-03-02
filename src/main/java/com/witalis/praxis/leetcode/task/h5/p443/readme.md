# [LeetCode][leetcode] task # 443: [String Compression][task]

Description
-----------

> Given an array of characters `chars`, compress it using the following algorithm:
> 
> Begin with an empty string `s`. For each group of **consecutive repeating characters** in `chars`:
> * If the group's length is `1`, append the character to `s`.
> * Otherwise, append the character followed by the group's length.
>
> The compressed string `s` **should not be returned separately**,
> but instead, be stored **in the input character array** `chars`.
> Note that group lengths that are `10` or longer will be split into multiple characters in `chars`.
> 
> After you are done **modifying the input array**, return _the new length of the array_.
> 
> You must write an algorithm that uses only constant extra space.


Example
-------

```sh
Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
```

Solution
--------

| Task | Solution                       |
|:----:|:-------------------------------|
| 443  | [String Compression][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/string-compression/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h5/p443/option/Practice.java>
