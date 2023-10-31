from collections import deque
import sys
input=sys.stdin.readline

n,k = map(int,input().split())
graph = []
data = []
dx = [-1,1,0,0]
dy = [0,0,-1,1]

for i in range(n):
    graph.append(list(map(int,input().split())))
    for j in range(n):
        if graph[i][j]!=0:
            data.append((graph[i][j],i,j,0))

data.sort()
q = deque(data)

target_s,target_x,target_y = map(int,input().split())
    
while q:
     v,x,y,s = q.popleft()
     if s==target_s:
          break
     for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if 0<=nx<n and 0<=ny<n:
                if graph[nx][ny]==0:
                    graph[nx][ny] = v
                    q.append((v,nx,ny,s+1))

print(graph[target_x-1][target_y-1])