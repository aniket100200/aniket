# Shortest Job First

**Difficulty:** Easy  
**Topics:** Array, Greedy, Sorting, Operating Systems

## Problem Description

You are given an integer array `bt` representing the burst times of `n` processes. Assume all processes arrive
simultaneously at time `0` in the ready queue.

Your task is to implement the **Shortest Job First (SJF)** scheduling algorithm. SJF is a non-preemptive scheduling
algorithm that selects the waiting process with the smallest execution (burst) time to execute next. Calculate the
average waiting time for all processes and return the floor value of this average (integer division).

*Note: The waiting time for a process is the time it spends in the ready queue before it starts executing.*

## Input / Output Format

* **Input Parameters:**
    * `bt`: An integer array where `bt[i]` is the burst time of the $i$-th process.
* **Output Format:**
    * An integer representing the floor value of the average waiting time of all processes.
* **Important Notes or Assumptions:**
    * All processes arrive at time $t = 0$.
    * The algorithm is non-preemptive.
    * Calculate the integer floor of the average waiting time (Total Waiting Time / Number of Processes).

## Examples

### Example 1

**Input:**

```text
bt = [4, 3, 7, 1, 2]