n,k=map(int,input().split())
coins = []
cnt = 0
for i in range(n):
    coins.append(int(input()))
coins.sort(reverse=True)

for coin in coins:
    if k>= coin:
        cnt+=k//coin
        k=k%coin
print(cnt)