# Word Ladder I

## Metadata

- **Difficulty:** Hard
- **Topics:** Graph, BFS, Strings, Hashing, Queue

---

# Problem Description

Given two words `beginWord` and `endWord`, and a dictionary `wordList`, return the length of the shortest transformation
sequence from `beginWord` to `endWord`.

A valid transformation sequence follows these rules:

- Only one letter can be changed at a time.
- Each transformed word must exist in the `wordList`.
- The transformation begins with `beginWord`.
- The transformation ends with `endWord`.

Return the number of words in the shortest transformation sequence, including both `beginWord` and `endWord`.

If no such transformation sequence exists, return `0`.

---

# Input / Output Format

## Input

- `String beginWord` → Starting word
- `String endWord` → Target word
- `List<String> wordList` → List of valid dictionary words

## Output

- `int` → Length of the shortest transformation sequence
- Return `0` if transformation is impossible

## Notes

- All words have the same length.
- Words contain only lowercase English letters.
- Use Breadth-First Search (BFS) for shortest path traversal.

---

# Examples

## Example 1

### Input

```text
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
```

**Output**

```text
5
```