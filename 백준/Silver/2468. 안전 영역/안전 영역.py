import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
graph = [[]for i in range(n)]

for i in range(n):
    graph[i] = list(map(int,input().split()))

max_height = max(map(max,graph))

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(x,y,h):
    queue = deque()
    queue.append((x,y))
    visited[x][y] = True
    while queue:
        a,b = queue.popleft()
        for i in range(4):
            nx = a+dx[i]
            ny = b+dy[i]
            if nx>=0 and nx<n and ny>=0 and ny<n:
                if not visited[nx][ny]:
                    queue.append((nx,ny))
                    visited[nx][ny]=True

res = []
for i in range(max_height):
    cnt = 0
    visited = [[False for j in range(n)]for k in range(n)]
    for j in range(n):
        for k in range(n):
            if graph[j][k]<=i:
                visited[j][k] = True
    for j in range(n):
        for k in range(n):
            if not visited[j][k]:
                bfs(j,k,i)
                cnt +=1
    res.append(cnt)
print(max(res))