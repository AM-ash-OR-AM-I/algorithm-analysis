import random


def multiply(a: int, b: int) -> int:
    """
    Karatsuba multiplication algorithm
    """
    if a < 10 or b < 10:
        return a * b

    # Determine the number of digits
    n = max(len(str(a)), len(str(b)))
    half = n // 2

    # Split the numbers into halves
    a1, a0 = divmod(a, 10**half)
    b1, b0 = divmod(b, 10**half)

    # Recursively compute the sub-products
    a1b1 = multiply(a1, b1)
    a0b0 = multiply(a0, b0)
    p = multiply(a1 + a0, b1 + b0)

    # Compute the final product using the sub-products
    return (a1b1 * 10 ** (2 * half)) + ((p - a0b0 - a1b1) * 10**half) + a0b0


def karatsuba_fast_multiply_faster(a: int, b: int) -> None:
    result = multiply(a, b)
    return result


if __name__ == "__main__":
    a = random.randint(10**1000, 10**1001)
    b = random.randint(10**1000, 10**1001)
    karatsuba_fast_multiply_faster(a, b)
