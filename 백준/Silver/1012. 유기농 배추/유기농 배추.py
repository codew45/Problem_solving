from collections import deque
import sys
input = sys.stdin.readline

def bfs(ay,bx):
    q = deque()
    q.append((ay,bx))
    visited[ay][bx] = True
    while q:
        y,x = q.popleft()
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if 0<=nx<M and 0<=ny<N:
                if not visited[ny][nx] and graph[ny][nx]==1:
                    q.append((ny,nx))
                    visited[ny][nx] = True
                    

T = int(input())
dx = [-1,1,0,0]
dy = [0,0,-1,1]
for i in range(T):
    M,N,K = map(int,input().split())
    graph = [[0 for _ in range(M)]for _ in range(N)]
    visited = [[False for _ in range(M)]for _ in range(N)]

    cnt = 0
    for _ in range(K):
        x,y = map(int,input().split())
        graph[y][x] = 1
    for j in range(N):
        for k in range(M):
            # j : y, k : x
            if graph[j][k]==1 and not visited[j][k]:
                bfs(j,k)
                
                cnt +=1
    print(cnt)
    