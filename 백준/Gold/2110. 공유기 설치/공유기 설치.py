n,c=map(int,input().split())

data = sorted([int(input()) for _ in range(n)])

start = 1
end = data[-1]-data[0]
result = 0

while start<=end:
    mid = (start+end)//2
    current = data[0]
    cnt = 1
    
    for i in range(1,n):
        if data[i]-current>=mid:
            cnt +=1
            current = data[i]
    if cnt>=c:
        result = mid
        start = mid+1
    else:
        end = mid-1
print(result)