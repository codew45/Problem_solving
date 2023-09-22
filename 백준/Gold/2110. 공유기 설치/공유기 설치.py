
n,c= map(int,input().split())
house = sorted([int(input()) for _ in range(n)])

house.sort()

start,end = 1, house[-1]-house[0]
answer = 0

while start<=end:
    mid = (start+end)//2
    current = house[0]
    cnt = 1

    for i in range(1,n):
        if house[i]-current>=mid:
            cnt +=1
            current = house[i]
            
    if cnt>=c:
        if answer<mid:
            answer = mid
        start = mid+1
    else:
        end = mid-1

print(answer)