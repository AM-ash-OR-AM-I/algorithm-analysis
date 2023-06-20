import random


def add(a: str, b: str) -> str:
    """
    N-bit parallel adder using sum and carry
    """
    n = max(len(a), len(b))
    a, b = a.zfill(n), b.zfill(n)
    result = ""
    carry = 0
    for i in range(-1, -n - 1, -1):
        x, y = int(a[i]), int(b[i])
        sum_ = x ^ y ^ carry
        carry = (x & y) | (y & carry) | (carry & x)
        result = str(sum_) + result
    if carry:
        result = "1" + result
    return result


def multiply(a: str, b: str) -> int:
    """
    ### Uses divide and conquer approach
    - Converts the numbers to binary strings and then multiplies them
    - `T(n) = 3T(n/2) + O(n) => T(n) = O(n^(log2(3))) = O(n^1.584)`
    """
    n = max(len(a), len(b))
    a, b = a.zfill(n), b.zfill(n)
    if n == 0:
        return 0
    elif n == 1:
        return int(a) * int(b)
    first_half = n // 2
    second_half = n - first_half
    a1, a0 = a[:first_half], a[first_half:]
    b1, b0 = b[:first_half], b[first_half:]
    a1b1 = multiply(a1, b1)
    a0b0 = multiply(a0, b0)
    p = multiply(add(a1, a0), add(b1, b0))
    return (a1b1 << (2 * second_half)) + ((p - a0b0 - a1b1) << second_half) + a0b0


def karatsuba_fast_multiply(a: int, b: int) -> None:
    bin_a = bin(a)[2:]
    bin_b = bin(b)[2:]
    # Convert the integers to binary strings and then multiply them
    result = multiply(bin_a, bin_b)
    return result


if __name__ == "__main__":
    a = random.randint(10**1000, 10**1001)
    b = random.randint(10**1000, 10**1001)
    karatsuba_fast_multiply(a, b)
