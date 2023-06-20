# Divide and Conquer

## Karatsuba Fast Multiplication Algorithm

### Theory
- [Karatsuba Fast Multiplication Algorithm](https://en.wikipedia.org/wiki/Karatsuba_algorithm)
- ```
  Time Complexity:
  T(n) = 3T(n/2) + O(n) => T(n) = O(n^(log2(3))) = O(n^1.584)
  ```

### Implementation
- [Karatsuba code for integer](./karatsuba_fast_multiply_efficient.py)
- [Karatsuba code for binary](./karatsuba_fast_multiply.py)

### Observations
- Using [timeit](https://docs.python.org/3/library/timeit.html) module to compare the time taken by the default multiplication algorithm and the karatsuba's algorithm.
- [karatsuba_test](./karatsuba_test.py) to compare the time taken by the default multiplication algorithm and the karatsuba's algorithm.
- Based on theory Karatsuba's algorithm is faster than the traditional multiplication algorithm however in practice it is slower than the traditional multiplication algorithm.
-  Karatsuba's algorithm has a higher computational overhead compared to the traditional algorithm for small numbers. There is a specific threshold, known as the crossover point, beyond which Karatsuba's algorithm becomes more efficient. For small numbers, the additional overhead outweighs the benefits, making the traditional algorithm more practical.
- Here are some results:
  - ```
    a = random.randint(1000**1000, 1000**1001)
    b = random.randint(1000**1000, 1000**1001)

    Results:
    Time taken by default multiply: 0.000112 seconds
    Time taken by karatsuba_fast_multiply: 0.637827 seconds
    ```
### Conclusion
- In practical scenarios, where performance is a key consideration, it is generally more efficient to rely on built-in multiplication operations or optimized libraries for multiplying large numbers. The built-in operations are highly optimized, take advantage of hardware optimizations, and are implemented in lower-level languages like C, which can provide significant performance benefits.

- The Karatsuba algorithm, while theoretically more efficient for very large numbers, may not always provide practical performance improvements in real-world scenarios, especially when compared to highly optimized built-in operations.
- Therefore, based on these results and the fact that the built-in multiplication operation is significantly faster, we can conclude that for general-purpose multiplication of large numbers, relying on the built-in multiplication in Python is more practical and efficient than implementing the Karatsuba algorithm.