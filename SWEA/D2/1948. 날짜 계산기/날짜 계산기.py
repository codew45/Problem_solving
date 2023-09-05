T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
days = [0,31,28,31,30,31,30,31,31,30,31,30,31]
for test_case in range(1, T + 1):
    m1, d1, m2, d2 = map(int,input().split())
    total = 1
    
    for i in range(m1,m2):
        total += days[i]
    total = total -d1+d2
    print('#%d'%test_case,'%d'%total)
    