import sys
input = sys.stdin.readline
cnt = [0]*10001
n = int(input())

for i in range(n):
    a = int(input())
    cnt[a] += 1

for i in range(len(cnt)):
    for j in range(cnt[i]):
        print(i)