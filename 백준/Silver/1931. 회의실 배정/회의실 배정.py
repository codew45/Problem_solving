import sys
input = sys.stdin.readline

n = int(input())
data = []
for i in range(n):
    d = tuple(map(int,input().split()))
    data.append(d)
data.sort(key=lambda x:(x[1],x[0]))

tmp = data[0][1]
cnt = 1
for i in range(1,len(data)):
    if tmp<=data[i][0]:
        cnt += 1
        tmp = data[i][1]
print(cnt)