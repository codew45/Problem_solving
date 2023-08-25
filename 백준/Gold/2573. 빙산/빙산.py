from collections import deque
import sys
input = sys.stdin.readline

dx = [-1,1,0,0]
dy = [0,0,-1,1]

n,m = map(int,input().split())
graph = []
for i in range(n):
    graph.append(list(map(int,input().split())))

def bfs(a,b):
    queue = deque()
    queue.append((a,b))
    visited[a][b] = 1
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if 0<=nx<n and 0<=ny<m and visited[nx][ny]==0:
                if graph[nx][ny]!=0:
                    queue.append((nx,ny))
                    visited[nx][ny] = 1
                else:
                    cnt[x][y] +=1
    return 1

year = 0

while True:
    visited = [[0]*m for i in range(n)]
    cnt =[[0]*m for i in range(n)]
    result = []

    for i in range(n):
        for j in range(m):
            if not visited[i][j] and graph[i][j]!=0:
                result.append(bfs(i,j))

    for i in range(n):
        for j in range(m):
            graph[i][j] = max(0,graph[i][j]-cnt[i][j])
            
    if len(result)>=2 or len(result)==0:
        break

    year+=1

if len(result)>=2:
    print(year)
else:
    print(0)