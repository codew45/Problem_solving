n = int(input())
arr = list(map(int,input().split()))
s = set(arr)
sorted_arr = []
for i in range(len(arr)):
    sorted_arr.append([i,arr[i]])
sorted_arr.sort(key=lambda x:(x[1]), reverse=True)
res = []
for i in range(len(arr)):
    if sorted_arr[i][1] in s:
        s.remove(sorted_arr[i][1])
    res.append([sorted_arr[i][0], sorted_arr[i][1], len(s)])
res.sort(key=lambda x:(x[0]))

for i in res:
    print(i[2],end= ' ')