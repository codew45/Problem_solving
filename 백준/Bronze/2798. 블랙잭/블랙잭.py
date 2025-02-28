n,m = map(int,input().split())
data = list(map(int,input().split()))

res = 0
tmp = 0

for i in range(n-2):
    for j in range(i+1,n-1):
        for k in range(j+1,n):
            tmp = data[i]+data[j]+data[k]
            if tmp>=res and tmp<=m:
                res = tmp
print(res)