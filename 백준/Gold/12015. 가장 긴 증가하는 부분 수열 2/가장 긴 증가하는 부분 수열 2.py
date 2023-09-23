n = int(input())
arr = list(map(int,input().split()))
res = [0]

for x in arr:
    if res[-1]<x:
        res.append(x)
    else:
        start = 0
        end = len(res)
        while start<end:
            mid = (start+end)//2
            if res[mid]<x:
                start = mid+1
            else:
                end = mid
        res[end] = x
print(len(res)-1)   