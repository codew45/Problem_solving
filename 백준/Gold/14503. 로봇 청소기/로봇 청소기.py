from collections import deque
import sys
input = sys.stdin.readline

dx = [-1,0,1,0]
dy = [0,1,0,-1]

n, m = map(int,input().split())
r,c,d = map(int,input().split())
graph = []
visited = [[False for j in range(m)]for i in range(n)]
for i in range(n):
    graph.append(list(map(int,input().split())))

def bfs(a,b,d):
    queue = deque()
    queue.append((a,b))
    visited[a][b] = True
    cnt = 1
    
    while queue:
        x,y = queue.popleft()
        visited[x][y] = True
        flag = 0

        for _ in range(4):
            d = (3+d)%4
            nx = x+dx[d]
            ny = y+dy[d]

            if 0<=nx<n and 0<=ny<m and graph[nx][ny]==0:
                if not visited[nx][ny]:
                    cnt +=1
                    flag = 1
                    queue.append((nx,ny))
                    break

        if flag ==0:
            if graph[x-dx[d]][y-dy[d]]==1:
                return cnt
            else:
                nx = x-dx[d]
                ny = y-dy[d]
                queue.append((nx,ny))
                #visited[nx][ny] = True
    return cnt

print(bfs(r,c,d))