class KnapSack:
    """
    o | w | p
    1 | 2 | 5
    2 | 4 | 12
    3 | 1 | 3
    4 | 9 | 5
    5 | 10| 4

    optimal solution for first n objects
    `opt[n, c] = max(p[n] + opt[n-1, c-w[n]], opt[n-1, c])`|
    -------------------------------------------------------
    """

    N = 3
    CAPACITY = 5
    weights = (2, 4, 1, 9, 10)
    profit = (5, 12, 3, 5, 4)
    objects = [weights, profit]

    dp_matrix = [[0] * CAPACITY] * N


# for i in range()
