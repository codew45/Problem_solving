import sys
input = sys.stdin.readline

def dfs(depth, start, value):
    global min_value
    if depth == n and graph[start][0]!=0:
        min_value = min(min_value,value+graph[start][0])
        return
    if value>min_value:
        return
    for i in range(n):
        if visited[i]==0 and graph[start][i]!=0:
            visited[i]=1
            dfs(depth+1,i,value+graph[start][i])
            visited[i]=0



n = int(input())
min_value = sys.maxsize
graph = []
for i in range(n):
    graph.append(list(map(int,input().split())))
visited = [0]*n

visited[0]=1
dfs(1,0,0)
print(min_value)