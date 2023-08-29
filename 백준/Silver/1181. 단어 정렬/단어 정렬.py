import sys
input = sys.stdin.readline
n=int(input())
list = []
for i in range(n):
    s = input().strip()
    if s not in list:
        list.append(s)
        
list.sort()
list.sort(key=len)

for i in list:
    print(i)