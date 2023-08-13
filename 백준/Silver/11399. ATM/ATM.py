n = int(input())
time = list(map(int,input().split()))
time.sort()
tmp = 0
sum = 0

for i in range(n):
    for j in range(i+1):
        tmp += time[j]
    sum += tmp
print(tmp)