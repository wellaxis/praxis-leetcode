# [LeetCode][leetcode] task # 71: [Simplify Path][task]

Description
-----------

> Given a string path, which is an absolute path (starting with a slash '/')
> to a file or directory in a Unix-style file system,
> convert it to the simplified canonical path.
> 
> In a Unix-style file system, a period '.' refers to the current directory,
> a double period '..' refers to the directory up a level,
> and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'.
> 
> For this problem, any other format of periods such as '...'
> are treated as file/directory names.
> 
> The canonical path should have the following format:
* The path starts with a single slash '/'.
* Any two directories are separated by a single slash '/'.
* The path does not end with a trailing '/'.
* The path only contains the directories on the path
  from the root directory to the target file or directory
  (i.e., no period '.' or double period '..')
>
> Return the simplified canonical path.

Example
-------

```sh
Input: path = "/a/./b/../../c/"
Output: "/c"
```

Solution
--------

| Task | Solution |
| :------: | :------ |
| 71 | [Simplify Path][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/simplify-path/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/p71/option/Practice.java>
