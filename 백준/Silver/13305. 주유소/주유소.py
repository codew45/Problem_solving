n=int(input())
dist = list(map(int,input().split()))
dist.append(0)
oil = list(map(int,input().split()))
price = oil[0]
total = 0

for i in range(1,n):
    total += price*dist[i-1]
    if price>oil[i]:
        price = oil[i]
print(total)