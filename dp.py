n = 10
dp = [0]*(n+1)
dp[1]=1
for i in range(2, n+1):
    if i%2 == 0:
        dp[i] = dp[i-1] + dp[i-2]
    else:
        dp[i] = dp[i-1] + dp[i-3]

for i, x in enumerate(dp):
    print(f"dp({i}) = {x}")

def f(n):
    if n==0 or n==1:
        return n
    elif n%2:
        return f(n-1)+f(n-3)
    else:
        return f(n-1)+f(n-2)

print(f(10))