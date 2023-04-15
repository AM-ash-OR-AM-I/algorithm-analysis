from functools import lru_cache
import timeit


def fib_loop(n):
    """
    Most efficient way using only loop
    T(n) = O(n)
    Space(n) = O(1)
    """
    f1 = 0
    f2 = 1
    for _ in range(n - 1):
        f1, f2 = f2, f1 + f2
    return f2


@lru_cache
def fib(n):
    """
    Using Recursion + lru_cache
    T(n) = 2*n = O(n)
    Space(n) = 2*n = O(n) (Stack size)
    """
    if n in (0, 1):
        return n
    return fib(n - 1) + fib(n - 2)


def fib_arr(n):
    """
    Uses DP only with down to top approach.
    (f[2] -> f[3] -> f[4] -> f[5])
    T(n) = n = O(n)
    Space(n) = n = O(n)
    """
    f = [0] * (n + 1)
    f[0] = 0
    f[1] = 1
    for i in range(2, n + 1):
        f[i] = f[i - 1] + f[i - 2]
    return f[-1]


def fib_rec_dp(n):
    """
    Uses recursion + DP(using array) + stack_call in recursion
    T(n) = n = O(n)
    Space(n) = n = O(n) [Stack and array size]
    """

    def recursion(n):
        if f[n] is None:
            f[n] = recursion(n - 1) + recursion(n - 2)
        return f[n]

    f = [0, 1] + [None] * (n - 1)
    return recursion(n)


# for i in range(120):
# print(fib_arr(10000))
time_taken_loop = timeit.timeit(lambda: fib_loop(400), number=100)
print(f"{time_taken_loop = }")
time_taken_arry = timeit.timeit(lambda: fib_arr(400), number=100)
print(f"{time_taken_arry = }")
# time_taken_recr = timeit.timeit(lambda: fib(400), number=1)
# print(f"{time_taken_recr = }")
time_taken_redp = timeit.timeit(lambda: fib_rec_dp(400), number=100)
print(f"{time_taken_redp = }")
# print(fib_arr(1000))
# print(fib_loop(1000))
