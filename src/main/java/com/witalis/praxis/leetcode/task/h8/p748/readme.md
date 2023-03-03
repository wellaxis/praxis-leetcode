# [LeetCode][leetcode] task # 748: [Shortest Completing Word][task]

Description
-----------

> Given a string `licensePlate` and an array of strings `words`, find the **shortest completing** word in `words`.
> 
> A **completing** word is a word that **contains all the letters** in `licensePlate`.
> **Ignore numbers and spaces** in `licensePlate`, and treat letters as **case insensitive**.
> If a letter appears more than once in `licensePlate`, then it must appear in the word the same number of times or more.
> 
> For example, if `licensePlate = "aBc 12c"`, then it contains letters `'a'`, `'b'` (ignoring case), and `'c'` twice.
> Possible **completing** words are `"abccdef"`, `"caaacab"`, and `"cbca"`.
> 
> Return _the shortest **completing** word in `words`_. It is guaranteed an answer exists.
> If there are multiple shortest **completing** words, return the **first** one that occurs in words.


Example
-------

```sh
Input: licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
Output: "steps"
Explanation: licensePlate contains letters 's', 'p', 's' (ignoring case), and 't'.
    "step" contains 't' and 'p', but only contains 1 's'.
    "steps" contains 't', 'p', and both 's' characters.
    "stripe" is missing an 's'.
    "stepple" is missing an 's'.
    Since "steps" is the only word containing all the letters, that is the answer.
```

Solution
--------

| Task | Solution                             |
|:----:|:-------------------------------------|
| 748  | [Shortest Completing Word][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/shortest-completing-word/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h8/p748/option/Practice.java>
