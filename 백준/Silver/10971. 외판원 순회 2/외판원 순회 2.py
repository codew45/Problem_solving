import sys
input = sys.stdin.readline

def dfs(start, now, value, cnt):
    global min_value
    if cnt==n:
        if graph[now][start]!=0:
            min_value = min(min_value,value+graph[now][start])
        return
    if value>min_value:
        return
    for i in range(n):
        if visited[i]==0 and graph[now][i]!=0:
            visited[i] = 1
            dfs(start, i, value+graph[now][i],cnt+1)
            visited[i] = 0
        
        
n=int(input())
graph = []
visited = [0]*n
min_value = sys.maxsize
for i in range(n):
    graph.append(list(map(int,input().split())))
    
for i in range(n):
    visited[i] = 1
    dfs(i,i,0,1)
    visited[i] = 0
print(min_value)