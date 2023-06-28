## Some interesting stuff for AD-II
### SAT
- SAT game: http://www.cril.univ-artois.fr/~roussel/satgame/satgame.php?level=2&lang=eng
- SAT solver: https://developers.google.com/optimization/cp/cp_solver
- SAT in machine learning: https://www.borealisai.com/research-blogs/tutorial-9-sat-solvers-i-introduction-and-applications/

### Hopfield Neural Networks
  - It's used as Associative Memory in machine learning
  - https://youtu.be/piF6D6CQxUw

### Metroplolis Algorithm
  - Boltzmann distribution in desmos: https://www.desmos.com/calculator/tnrxmdumst

### NP vs NP-Hard
  - Are there any problems that are NP but not NP-Hard and not in P?
    - This is an open problem, which is equivalent to P != NP
    - If proven, it would mean that there are problems that are hard to solve but easy to verify
    - If (P = NP) => NP = NP-Complete, Modern cryptography would be broken because it uses SAT and other NP-hard problems.


### Randomised Quick Sort
- The worst case of quick sort is when the pivot is the smallest or the largest element in the array. This can be avoided by choosing a random pivot.
- Here are codes:
  - [Quicksort Randomised](./src/sorting/quick_sort_randomised.py)
  - [Randomised select](./src/sorting/select_randomised.py)
  - [Comparison between quicksort and randomised quicksort](./src/sorting/compare_quick_sort_randomised.py)
