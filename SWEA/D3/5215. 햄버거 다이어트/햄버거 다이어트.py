def dfs(idx, score, kcal):
    global answer
    if kcal>L:
        return
    if answer<score:
        answer = score
    if idx == N:
        return
    dfs(idx+1,score+data[idx][0],kcal+data[idx][1])
    dfs(idx+1,score,kcal)

T = int(input())
for test_case in range(1, T + 1):
    N,L=map(int,input().split())
    data = []
    answer =0
    for i in range(N):
        score, kcal = map(int,input().split())
        data.append((score,kcal))
    
    dfs(0,0,0)
    
    print('#{} {}'.format(test_case,answer))