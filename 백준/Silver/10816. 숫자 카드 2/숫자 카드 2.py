import bisect

n = int(input())
card = sorted(map(int,input().split()))
m = int(input())
target = list(map(int, input().split()))

def cnt(arr,value):
    return bisect.bisect_right(arr,value)-bisect.bisect_left(arr,value)

for t in target:
    print(cnt(card,t),end=' ')