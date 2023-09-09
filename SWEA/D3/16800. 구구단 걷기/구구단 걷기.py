import math
T = int(input())
for test_case in range(1, T + 1):
    num = int(input())
    arr = []
    for i in range(1,int(math.sqrt(num))+1):
        if num%i==0:
            arr.append((i,num//i))
    for i,(x,y) in enumerate(arr):
        arr[i] = (x-1)+(y-1)
    print('#%d'%test_case,min(arr))