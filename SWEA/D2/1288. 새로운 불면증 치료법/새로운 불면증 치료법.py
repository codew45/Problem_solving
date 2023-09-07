T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    numbers = [0]*10
    i = 1
    while 0 in numbers:
        tmp = str(N*i)
        for c in tmp:
            numbers[int(c)] +=1
        i+=1
    print('#%d'%test_case, tmp)