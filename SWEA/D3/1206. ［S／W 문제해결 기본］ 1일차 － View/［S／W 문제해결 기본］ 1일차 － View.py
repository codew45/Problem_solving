T = 10
for test_case in range(1, T + 1):
    n = int(input())
    arr = list(map(int,input().split()))
    res = 0
    for i in range(2, n-2):
        tmp = max(arr[i-2],arr[i-1],arr[i+1],arr[i+2])
        if tmp < arr[i]:
            res += arr[i]-tmp
    print("#%d"%test_case, res)