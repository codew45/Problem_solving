T = int(input())
for test_case in range(1, T + 1):
    N = input()
    tmp = N
    s = set()
    while True:
        for c in tmp:
            if int(c) not in s:
                s.add(int(c))
        if len(s)==10:
            print('#%d'%test_case,tmp)
            break
        tmp = str(int(tmp)+int(N))