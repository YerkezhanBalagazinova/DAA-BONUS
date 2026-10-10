# BST and Hash Table Performance Comparison

## Introduction

In this assignment, I implemented a Binary Search Tree and a Hash Table in Java.

The main goal was to compare insertion, searching, and deletion in both data structures. I also tested their performance with 100, 1,000, and 10,000 elements.

For the Hash Table, I used chaining to handle collisions.

## Analysis of Insertion, Searching, and Deletion

### Binary Search Tree

Insertion starts from the root and compares the new value with the current node. Smaller values go to the left and larger values go to the right until an empty position is found.

Searching also starts from the root. The program moves left or right depending on the comparison until the value is found or there are no more nodes.

Deletion has three cases: removing a node with no children, with one child, or with two children. If a node has two children, the smallest value from the right subtree is used to replace it.

### Hash Table

Insertion first calculates the bucket using the hash function. If another value is already in the same bucket, chaining is used and the value is stored in the linked list.

Searching calculates the same bucket and checks only the values stored in that chain.

Deletion also finds the correct bucket first, then removes the required value from the chain if it exists.

## Best-Case and Worst-Case Time Complexity

### Binary Search Tree

| Operation | Best Case | Average Case | Worst Case |
|---|---|---|---|
| Insert | O(1) | O(log n) | O(n) |
| Search | O(1) | O(log n) | O(n) |
| Delete | O(1) | O(log n) | O(n) |

For insertion, the best case is O(1) when the tree is empty and the new value becomes the root. The worst case is O(n) when the tree is very unbalanced and many nodes have to be checked.

For searching, the best case is O(1) when the value is in the root. The worst case is O(n) when the tree is unbalanced and the value is near the bottom or does not exist.

For deletion, the best case is O(1) when the required node can be found and removed immediately. The worst case is O(n) when the tree is unbalanced and many nodes have to be visited.

### Hash Table

| Operation | Best Case | Expected Case | Worst Case |
|---|---|---|---|
| Insert | O(1) | O(1) | O(n) |
| Search | O(1) | O(1) | O(n) |
| Delete | O(1) | O(1) | O(n) |

For insertion, the best case is O(1) when the bucket is empty. The worst case is O(n) when many values are stored in the same bucket and the whole chain has to be checked.

For searching, the best case is O(1) when the value is found immediately. The worst case is O(n) when many values collide into the same bucket.

For deletion, the best case is O(1) when the value is found immediately in its bucket. The worst case is O(n) when the program has to go through a long chain before finding the value.

## Experimental Setup

I tested both data structures with:

- 100 elements
- 1,000 elements
- 10,000 elements

The same values were used for both structures.

The values were shuffled before insertion so that the BST would not receive already sorted data.

I used a fixed random seed so the experiment could be repeated.

Each test was repeated 5 times and the average execution time was recorded.

The execution time was measured using `System.nanoTime()`.

## Results

| Size | Structure | Insert (ns) | Search (ns) | Delete (ns) |
|---:|---|---:|---:|---:|
| 100 | BST | 58,440 | 15,460 | 16,080 |
| 100 | Hash Table | 10,460 | 4,580 | 5,860 |
| 1,000 | BST | 91,340 | 82,360 | 111,740 |
| 1,000 | Hash Table | 33,940 | 20,340 | 21,600 |
| 10,000 | BST | 899,000 | 865,480 | 799,800 |
| 10,000 | Hash Table | 133,700 | 70,900 | 75,980 |

## Results Comparison

The Hash Table was faster than the BST in all of my tests.

With 100 elements, both structures were fast, but the Hash Table already had lower execution times.

With 1,000 elements, the difference became more noticeable.

The biggest difference appeared with 10,000 elements. BST search took 865,480 ns, while Hash Table search took 70,900 ns. BST insertion took 899,000 ns compared to 133,700 ns for the Hash Table. Deletion was also faster in the Hash Table.

The results match the theoretical complexity because the Hash Table has expected O(1) performance, while BST operations depend on the height of the tree.

## Why Performance Can Differ in Practice

The real execution time depends on more than only Big-O complexity.

For the BST, performance depends on the shape of the tree. A balanced tree has a smaller height, while an unbalanced tree needs more comparisons.

For the Hash Table, performance depends on how well the hash function distributes values. More collisions create longer chains and can make operations slower.

Memory access, Java execution, and constant operation costs can also affect the measured time.

## Conclusion

In this assignment, I compared a Binary Search Tree and a Hash Table using insertion, searching, and deletion.

The experimental results showed that the Hash Table was faster in all three operations for the tested data sizes.

The Hash Table is a good choice when fast exact-key searching is needed because its expected time complexity is O(1).

The BST can be slower, but it has an important advantage because it keeps values in an ordered structure. This can be useful when sorted data or range operations are needed.