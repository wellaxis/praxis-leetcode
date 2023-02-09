# [LeetCode][leetcode] task # 2306: [Naming a Company][task]

Description
-----------

> You are given an array of strings `ideas` that represents a list of names to be used in the process of naming a company.
> The process of naming a company is as follows:
> * Choose 2 **distinct** names from `ideas`, call them `ideaA` and `ideaB`.
> * Swap the first letters of `ideaA` and `ideaB` with each other.
> * If **both** of the new names are not found in the original `ideas`, then the name `ideaA ideaB`
> (the concatenation of `ideaA` and `ideaB`, separated by a space) is a valid company name. Otherwise, it is not a valid name.
>
> Return _the number of **distinct** valid names for the company_.

Example
-------

```sh
Input: ideas = ["coffee","donuts","time","toffee"]
Output: 6
Explanation: The following selections are valid:
    - ("coffee", "donuts"): The company name created is "doffee conuts".
    - ("donuts", "coffee"): The company name created is "conuts doffee".
    - ("donuts", "time"): The company name created is "tonuts dime".
    - ("donuts", "toffee"): The company name created is "tonuts doffee".
    - ("time", "donuts"): The company name created is "dime tonuts".
    - ("toffee", "donuts"): The company name created is "doffee tonuts".
    Therefore, there are a total of 6 distinct company names.

The following are some examples of invalid selections:
    - ("coffee", "time"): The name "toffee" formed after swapping already exists in the original array.
    - ("time", "toffee"): Both names are still the same after swapping and exist in the original array.
    - ("coffee", "toffee"): Both names formed after swapping already exist in the original array.
```

Solution
--------

| Task | Solution                     |
|:----:|:-----------------------------|
| 2306 | [Naming a Company][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/naming-a-company/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h24/p2306/option/Practice.java>
