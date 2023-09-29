n = int(input())
A = list(map(int,input().split()))
dp=[1]*n

for i in range(n):
    for j in range(i):
        if A[j]<A[i]:
            dp[i] = max(dp[i],dp[j]+1)

subsequence = []
order = max(dp)
for i in range(n-1,-1,-1):
    if dp[i]==order:
        subsequence.append(A[i])
        order -=1
subsequence.reverse()
print(max(dp))
print(*subsequence)