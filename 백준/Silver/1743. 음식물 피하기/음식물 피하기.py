from collections import deque
import sys
input = sys.stdin.readline

def bfs(a,b):
    q = deque()
    q.append((a,b))
    visited[a][b] = 1
    cnt = 1
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if 0<=nx<N and 0<=ny<M and visited[nx][ny]==0 and graph[nx][ny]==1:
                q.append((nx,ny))
                visited[nx][ny]=1
                cnt +=1
    return cnt

N,M,K = map(int,input().split())
    
graph = [[0 for j in range(M)]for i in range(N)]
visited = [[0 for j in range(M)]for i in range(N)]
cnt_list = []
dx = [-1,1,0,0]
dy = [0,0,-1,1]

for i in range(K):
    x,y = map(int,input().split())
    graph[x-1][y-1] = 1

for i in range(N):
    for j in range(M):
        if visited[i][j]==0 and graph[i][j]==1:
            cnt_list.append(bfs(i,j))
print(max(cnt_list))