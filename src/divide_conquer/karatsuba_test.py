from functools import partial
import random
import timeit
from karatsuba_fast_multiply_efficient import karatsuba_fast_multiply_faster

"""
Practical comparison of karatsuba_fast_multiply and default multiplication
"""

def default_multiply(a: int, b: int) -> None:
    result = a * b
    # print(result)


a = random.randint(1000**1000, 1000**1001)
b = random.randint(1000**1000, 1000**1001)

# assert karatsuba_fast_multiply_faster(a, b) == karatsuba_fast_multiply(a, b)
repeats = 1
iterations = 1


times_default = timeit.Timer(partial(default_multiply, a, b)).repeat(
    repeats, iterations
)
time_taken_default = min(times_default) / iterations
print(f"Time taken by default multiply: {time_taken_default:.6f} seconds")

times = timeit.Timer(partial(karatsuba_fast_multiply_faster, a, b)).repeat(
    repeats, iterations
)
time_taken = min(times) / iterations
print(f"Time taken by karatsuba_fast_multiply_faster: {time_taken:.6f} seconds")


"""
Time taken by default multiply: 0.000112 seconds
Time taken by karatsuba_fast_multiply_faster: 0.637827 seconds

It can be seen that the default multiplication is faster than karatsuba multiplication.
Even though theoretically karatsuba multiplication is faster, built-in multiplication
is significantly faster due to machine level optimizations.
"""