# Algorithms and Data Structures
This repository contains my notes and implementations of algorithms and data structures in CSW-II and AD-I/II.

## AD-I codes:
  - [Sorting](./src/sorting/)
  - [Graphs](./src/csw/graph/)
  - [Greedy Algorithms](./src/greedy/)
  - [Divide and Conquer](./src/divide_and_conquer/)
  - [Dynamic Programming](./src/dp/)

## AD-II
Implementation & Some interesting stuff I found while studying for AD-II.
### SAT
- SAT game: http://www.cril.univ-artois.fr/~roussel/satgame/satgame.php?level=2&lang=eng
- SAT solver: https://developers.google.com/optimization/cp/cp_solver
- SAT in machine learning: https://www.borealisai.com/research-blogs/tutorial-9-sat-solvers-i-introduction-and-applications/

### NP vs NP-Hard
  - Are there any problems that are NP but not NP-Hard and not in P?
    - This is an open problem, which is equivalent to P != NP
    - If proven, it would mean that there are problems that are hard to solve but easy to verify
    - If (P = NP) => NP = NP-Complete, Modern cryptography would be broken because it uses SAT and other NP-hard problems.

### Local Search
#### Gradient Descent
  - Choosing a local minimum.
#### Metropolis Algorithm - Simulated Annealing
  - Boltzmann distribution in desmos: https://www.desmos.com/calculator/pwjyj4yoyg
#### Hopfield Neural Networks
  - It's used as Associative Memory in machine learning
  - https://youtu.be/piF6D6CQxUw

### Randomised Algorithms
#### Quick Sort
- The worst case of quick sort is when the pivot is the smallest or the largest element in the array. This can be avoided by choosing a random pivot.
- Here are codes:
  - [Quicksort Randomised](./src/sorting/quick_sort_randomised.py)
  - [Randomised select](./src/sorting/select_randomised.py)
  - [Comparison between quicksort and randomised quicksort](./src/sorting/compare_quick_sort_randomised.py)

#### Hashing (Hash Table)
- https://youtu.be/S5NY1fqisSY
- Chaining
  <!-- - [Chaining](./src/hashing/Chaining.java)
  - [Chaining with linked list](./src/hashing/ChainingLinkedList.java) -->
- Open Addressing
  - Linear Probing
  - Quadratic Probing
  - Double Hashing
- Universal Hashing

### Approximation Algorithms
#### 0/1 Knapsack
- Approximation algorithms are used to find a solution to a problem that is close to the optimal solution.
  - [0/1 Knapsack optimal](./src/dp/Knapsack01.java)
  - [0/1 Knapsack approximation](./src/dp/Knapsack01.java)

## CSW-II codes:
  - [Code](./src/csw/)