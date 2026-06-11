# Lemonade Change

**Difficulty:** Easy  
**Topics:** Array, Greedy

## Problem Description

At a lemonade stand, each lemonade
costs $5. Customers are standing in a queue to buy from you and order one at a time (in the order specified by the integer array
`bills`). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.

You must provide the correct change to each customer so that the net transaction is that the customer pays $5. Note that
you do not have any change in hand at first.

Return `true` if and only if you can provide every customer with the correct change.

## Input / Output Format

* **Input Parameters:** * An integer array `bills` representing the bills that customers pay with, in the order they
  arrive.
* **Output Format:** * A boolean value: `true` if you can provide correct change to every customer, `false` otherwise.
* **Important Notes or Assumptions:**
    * You start with absolutely no bills in your register.
    * You cannot break higher denomination bills elsewhere; you can only give change using the bills previously
      collected from customers.
    * A $20 bill requires $15 in change (either one $10 and one $5, or three $5s).

## Examples

### Example 1

**Input:**

```text
bills = [5, 5, 5, 10, 20]