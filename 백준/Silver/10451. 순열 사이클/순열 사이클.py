import sys
input = sys.stdin.readline

t = int(input())

def dfs(v):
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            dfs(i)

for i in range(t):
    cnt = 0
    n = int(input())
    graph = [[]for i in range(n+1)]
    visited = [False]*(n+1)
    data = list(map(int,input().split()))
    for i in range(1,n+1):
        graph[i].append(data[i-1])
    for i in range(1,n+1):
        if not visited[i]:
            dfs(i)
            cnt +=1
    print(cnt)