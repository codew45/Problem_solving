n = int(input())
arr = list(map(int,input().split()))
s = set(arr)
s = sorted(s)
s_list = list(s)
d = {}

for i in range(len(s)):
    d[s_list[i]] = i
for i in range(len(arr)):
    print(d[arr[i]],end= ' ')